package com.playdata.game.dao;

import com.playdata.game.config.JdbcConnection;
import com.playdata.game.dto.Monster;
import com.playdata.game.dto.UserNow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class CharDao {

    public void setUserData(UserNow userNow){
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "update  user_now " +
                "set level = ?,hp =?,gold =?,exp = ?,attackpoint =? " +
                "where uid = ? and uname= ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, userNow.getLevel());
            pst.setInt(2, userNow.getHp());
            pst.setInt(3, userNow.getGold());
            pst.setInt(4, userNow.getExp());
            pst.setInt(5, userNow.getAttackpoint());
            pst.setInt(6, userNow.getUid());
            pst.setString(7, userNow.getUname());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void addUserData(UserNow userNow) //처음 데이터를 넣는다.
    {
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "insert into user_now(uid,uname,level,hp,gold,exp,attackpoint) " +
                "values(?,?,?, ?, ?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, userNow.getUid());
            pst.setString(2, userNow.getUname());
            pst.setInt(3, userNow.getLevel());
            pst.setInt(4, userNow.getHp());
            pst.setInt(5, userNow.getGold());
            pst.setInt(6, userNow.getExp());
            pst.setInt(7, userNow.getAttackpoint());
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
    public void setUserData1(UserNow userNow) //몬스터에 드랍율에 따라 장비를 획득한다.
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
            pst.setInt(5,userNow.getAttackpoint());
            pst.setInt(6,userNow.getUid());
            pst.setString(7,userNow.getUname());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
