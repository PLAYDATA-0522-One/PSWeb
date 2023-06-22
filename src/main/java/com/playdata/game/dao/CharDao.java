package com.playdata.game.dao;

import com.playdata.game.config.JdbcConnection;
import com.playdata.game.dto.Monster;
import com.playdata.game.dto.UserNow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class CharDao {
    public UserNow changeUserData(Monster monster, UserNow userNow) //여기에 와서 사람과 몬스터간의 일을 모두 행한다.
    {
            if(changeCharacterHp(monster, userNow))
            {
                userNow.now_battle=true;
                //

            }
            else {
                if(userNow.getNow_hp()<0)
                {
                    System.out.println("사망하셨습니다.");

                }
                else
                {
                    getCharacterExp(monster, userNow);
                    getCharacterGold(monster, userNow);
                    getCharacterEquipment(monster, userNow);

                }
                userNow.setNow_battle(false);

                //섹션으로 바꾸고
                //charcter is dead
                //맨뒤 페이지로 돌아감
                //끝
            }

        System.out.println(userNow.toString());
        System.out.println(monster.toString());

        return userNow;
        //html에 프린트해줌
    }
    public void getCharacterExp(Monster monster, UserNow userNow) //경험치를 얻음
    {
        int nowex = userNow.getExp();
        userNow.setExp(monster.getExp()+nowex);
        if(userNow.getExp()>=100)
        {
            characterLevelup(monster,userNow);
        }
        //System.out.println(userNow.getExp());
    }
    public void characterLevelup(Monster monster, UserNow userNow) //exp가 100이상일때 레벨업을 한다.
    {

        userNow.setExp(userNow.getExp()%100);
        userNow.setLevel(userNow.getLevel()+1);
        userNow.setHp(userNow.getHp()+20);
        userNow.setNow_hp(userNow.getHp());
        userNow.setAttackpoint(userNow.getAttackpoint()+10);
        //System.out.println(userNow.getExp());
    }
    public void fullHp(UserNow userNow)
    {
        userNow.setHp(userNow.getNow_hp());
    }

    public boolean changeCharacterHp(Monster monster, UserNow userNow) //몬스터와 싸워서 체력을 잃는다.
    {
        int changeMonsterHp=0;
        int changeCharacterHp=0;
        changeCharacterHp = userNow.getHp()- monster.getAttackpoint();
        changeMonsterHp = monster.getNow_hp()-userNow.getAttackpoint();
        userNow.setHp(changeCharacterHp);
        monster.setNow_hp(changeMonsterHp);
        //System.out.println(userNow.getHp());
        ///
        //System.out.println(monster.getNow_hp());

        if(userNow.getHp()<=0||monster.getNow_hp()<=0) //0이되면 죽는다.
        {
            return false;
            //dead
        }
        return true;
    }
    public void getCharacterGold(Monster monster, UserNow userNow) //몬스터에게서 골드를 얻는다.
    {

        int nowgold = userNow.getGold();
        int dropgold = (int)((Math.random() * 100)+1); //드랍율
        userNow.setGold(nowgold+dropgold);
        //System.out.println(userNow.getGold());
    }
    public void getCharacterEquipment(Monster monster, UserNow userNow) //몬스터에 드랍율에 따라 장비를 획득한다.
    {
        dropEquipment(monster);
    }
    public void addUserData(UserNow userNow) //처음 데이터를 넣는다.
    {
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "insert into user_now(uid,uname,level,hp,gold,exp,now_x,now_y,attackpoint) " +
                "values(?,?,?, ?, ?,?,?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, userNow.getUid());
            pst.setString(2, userNow.getUname());
            pst.setInt(3, userNow.getLevel());
            pst.setInt(4, userNow.getHp());
            pst.setInt(5, userNow.getGold());
            pst.setInt(6, userNow.getExp());
            pst.setInt(7, userNow.getNow_x());
            pst.setInt(8, userNow.getNow_y());
            pst.setInt(9, userNow.getAttackpoint());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void whatEquipment(int id) //id테이블을 통해서 어떤 장비를 획득했는지 확인
    {
        Connection conn = new JdbcConnection().getJdbc();
        String name2=null;
        Integer id2=null;
        String sql = "select id, name " +
                "from equipment " +
                "where id=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                id2=resultSet.getInt("id");
                name2= resultSet.getString("name");
                insertInventory(id2,name2);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void dropEquipment(Monster monster) //몬스터에 드랍율의 따라서 장비의 드랍율을 넘겨준다.
    {
        int over_range=100-((monster.getDrop_per())*1);
        int ran = (int)((Math.random() * 100)+1); //드랍율
        int what_eq = (int)((Math.random()*10)+1); //무슨 장비인지
        if(over_range>ran)
        {
            whatEquipment(what_eq);
            //아이템 드랍
        }
        else {

        }

    }
    public void insertInventory(int id, String equipment)  //얻은 장비를 인벤토리 테이블에 추가
    {
        String sql = "insert into inventory(id,name) " +
                "values(?, ?)";
        try {
            Connection conn = new JdbcConnection().getJdbc();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, equipment);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void setUserData(UserNow userNow) //몬스터에 드랍율에 따라 장비를 획득한다.
    {
        Connection conn = new JdbcConnection().getJdbc();
//        String sql = "update\n" +
//                "    user_now\n" +
//                "set\n" +
//                "     = ?\n" +
//                "     = ?\n" +
//                "     = ?\n" +
//                "     = ?\n" +
//                "     = ?\n" +
//                "     = ?\n" ;
        String sql = "update\n" +
                "    user_now\n" +
                "set\n" +
                "    level = ?\n" +
                "    hp = ?\n" +
                "    gold = ?\n" +
                "    exp = ?\n" +
                "    now_x = ?\n" +
                "    now_y = ?\n" +
                "    attackpoint = ?\n" +

                "where\n" +
                "    uid = ? and uname = ?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, userNow.getLevel());
            pst.setInt(2, userNow.getHp());
            pst.setInt(3,userNow.getGold());
            pst.setInt(4,userNow.getExp());
            pst.setInt(5, userNow.getNow_x());
            pst.setInt(6,userNow.getNow_y());
            pst.setInt(7,userNow.getAttackpoint());
            pst.setInt(8,userNow.getUid());
            pst.setString(9,userNow.getUname());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
