package com.playdata.game.dao;

import com.playdata.game.config.JdbcConnection;
import com.playdata.game.dto.Monster;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MonsterDao {

    public Monster meetMonster(int id) //인수에 따라 몬스터를 만난다.
    {
        Connection conn = new JdbcConnection().getJdbc();
        Integer id2=null;
        String name2=null;
        Integer hp2=null;
        Integer attackpoint2= null;
        Integer drop_per2=null;
        Integer exp2=null;
        Integer now_hp2=null;
        String sql = "select id, name, hp, attackpoint,drop_per,exp,now_hp " +
                "from monster " +
                "where id=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                id2= resultSet.getInt("id");
                name2=resultSet.getString("name");
                hp2=resultSet.getInt("hp");
                attackpoint2=resultSet.getInt("attackpoint");
                drop_per2=resultSet.getInt("drop_per");
                exp2=resultSet.getInt("exp");
                now_hp2=resultSet.getInt("now_hp");


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
         Monster monster = new Monster(id2,name2,hp2,attackpoint2,drop_per2,exp2,now_hp2);
        return monster;
    }
    public int randomMonster() //어떤 몬스터인지 확인
    {
        int ran = (int)(Math.random() * 12+1);

        return ran;
    }




}
