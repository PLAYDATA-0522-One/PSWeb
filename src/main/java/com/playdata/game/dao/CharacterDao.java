package com.playdata.game.dao;

import com.playdata.game.config.JdbcConnection;
import com.playdata.game.dto.Character;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CharacterDao {
    public Character insert(String uname, String job, int hp, int attackPoint) {
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "INSERT INTO characters(uname, job, hp, attackPoint) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, uname);
            pst.setString(2, job);
            pst.setInt(3, hp);
            pst.setInt(4, attackPoint);
            pst.executeUpdate();

            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                Character character = new Character();
                return character;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null; // 새로운 캐릭터 객체가 반환되지 않도록 수정해야 함

    }

    public List<Character> findByCharacter(String uname, String job) {
        List<Character> characters = new ArrayList<Character>();
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "SELECT * FROM characters WHERE uname = ? AND job = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, uname);
            pst.setString(2, job);

            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                characters.add(makeCharacter(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return characters;
    }

    public List<Character> getAllCharacters() {
        List<Character> characters = new ArrayList<Character>();
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "SELECT * FROM characters";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                characters.add(makeCharacter(resultSet));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return characters;
    }

    private Character makeCharacter(ResultSet resultSet) throws SQLException {
        int uid = resultSet.getInt("uid");
        int level = resultSet.getInt("level");
        String uname = resultSet.getString("uname");
        String job = resultSet.getString("job");
        int hp = resultSet.getInt("hp");
        int attackPoint = resultSet.getInt("attack_point");
        String image = resultSet.getString("image");
        return new Character();
    }

    public void update(Character character) {
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "UPDATE characters SET level = ?, uname = ?, job = ?, hp = ?, attackPoint = ?, image = ? WHERE uid = ?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, character.getLevel());
            pst.setString(2, character.getUname());
            pst.setString(3, character.getJob());
            pst.setInt(4, character.getHp());
            pst.setInt(5, character.getAttackPoint());
            pst.setString(6, character.getImage());
            pst.setInt(7, character.getUid());

            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(int uid, String uname) {
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "DELETE FROM characters WHERE uid = ? AND uname = ?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, uid);
            pst.setString(2, uname);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}