package com.playdata.game.dao;

import com.playdata.game.config.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MapDao {
    public int[] getMoveData() {
        return null;
    }
}
        //캐릭터 클래스 받아올까?
        //
        //Connection conn = new JdbcConnection().getJdbc();
        //여기서 좌표 읽기
//        String sql = "select id,username,name,create_at "
//                +"from users "
//                +"where username = ? and password = ?";
//        try{
//            PreparedStatement pst = conn.prepareStatement(sql);
//            pst.setString(1,id);
//            pst.setString(2, password);
//            ResultSet resultSet = pst.executeQuery();
//            while(resultSet.next()){
//                users.add(makeUser(resultSet));
//            }
//
//        }catch (SQLException e){
//            throw new RuntimeException(e);
//        }
//
//        if(users.size()!=0){
//            return users.get(0);
//        }
//        return null;



