package com.playdata.game.dao;

import com.playdata.game.config.JdbcConnection;
//import com.playdata.game.config.LogoutThread;
import com.playdata.game.dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao    {

    public void insert(User user) {
        Connection conn = new JdbcConnection().getJdbc();

        String sql = "insert into users(username, password, name)" + "values(?,?,?)";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getName());
            pst.executeUpdate();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
    public User login (String id, String password){
        List<User> users = new ArrayList<User>();

        Connection conn = new JdbcConnection().getJdbc();

        String sql = "select id, username, name, create_at "+
                "from users "+
                "where username = ? and password = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, password);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                users.add(makeUser(resultSet));
            }
        } catch (SQLException e){;
            throw new RuntimeException(e);
        }
        if (users.size() != 0) {
            return users.get(0);
        }
        return null;
    }
    private User makeUser(ResultSet resultSet){
        Integer id;
        String password, username, name, createAt;
        try {
            id = resultSet.getInt("id");
        }catch (SQLException e) {
            id = null;
        }
        try {
            password = resultSet.getString("password");
        }catch (SQLException e) {
            password = null;
        }
        try {
            username = resultSet.getString("username");
        }catch (SQLException e) {
            username = null;
        }
        try {
            name = resultSet.getString("name");
        }catch (SQLException e) {
            name = null;
        }
        try {
            createAt = resultSet.getString("create_at");
        }catch (SQLException e) {
            createAt = null;
        }
        return new User(id,username,password,name,createAt);
    }
//    public void update (User user) {
//        Connection conn = new JdbcConnection().getJdbc();
//
//        String sql = "update users\n" +
//                "set password = ?,\n" +
//                "name = ?\n" +
//                "where id = ?";
//        try {
//            PreparedStatement pst = conn.prepareStatement(sql);
//            pst.setString(1, user.getPassword());
//            pst.setString(2, user.getName());
//            pst.setInt(3, user.getId());
//            pst.executeUpdate();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
    public boolean idCheck (String username) {
        List<User> users = new ArrayList<User>();
        boolean count = false;

        String name = username;

        Connection conn = new JdbcConnection().getJdbc();

        String sql = "select username "+
                "from users "+
                "where username = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,name);
            ResultSet resultSet = pst.executeQuery();

            if(resultSet.next()) {
                count = true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }


}
