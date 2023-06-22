package com.playdata.game.dao;

import com.playdata.game.config.JdbcConnection;
import com.playdata.game.dto.Character;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CharacterDao {
    private static final String URL = "jdbc:mysql://localhost:3306/game";
    private static final String USERNAME = "your_username";



    public static List<Character> findByCharacter(String uname, String job) {
        List<Character> characters = new ArrayList<Character>();
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "SELECT * FROM characters WHERE uname = ? AND job = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, uname);
            pst.setString(2, job);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int level = rs.getInt("level");

                // Character 객체 생성 및 필드 설정
                Character character = new Character();
                character.setUid(id);
                character.setLevel(level);
                character.setUname(uname);
                character.setJob(job);
                characters.add(character);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return characters;
    }
    public Character insert(int level, String uname, String job, int hp, int attackPoint) {
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "INSERT INTO characters(level, uname, job, hp, attackPoint) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, level);
            pst.setString(2, uname);
            pst.setString(3, job);
            pst.setInt(4, hp);
            pst.setInt(5, attackPoint);
            pst.executeUpdate();

            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);

                // 생성된 캐릭터 객체를 반환
                Character character = new Character();
                character.setLevel(level);
                character.setUname(uname);
                character.setJob(job);
                character.setHp(hp);
                character.setAttackPoint(attackPoint);
                return character;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to insert character", e);
        } finally {
            // 리소스 해제
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;

    }
    public void createCharacter(Character character) {
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "INSERT INTO characters (uname, job, level) VALUES (?, ?, ?)";

        PreparedStatement pst = null;
        System.out.println(character.toString());
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, character.getUname());
            pst.setString(2, character.getJob());
            pst.setInt(3, character.getLevel());

            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create character", e);
        } finally {
            // 리소스 해제
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public Character getCharacter(String name,int id)
    {
        Connection conn = new JdbcConnection().getJdbc();
        String name2=null;
        Integer id2=null;
        Integer level2=null;
        Integer attackpoint2=null;
        Integer hp2=null;
        String job2=null;
        String sql = "select id, name,level,attackpoint,hp,job " +
                "from chara " +
                "where id=? and name=? ";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2,name);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                id2= resultSet.getInt("id");
                name2=resultSet.getString("name");
                level2 = resultSet.getInt("level");
                attackpoint2 = resultSet.getInt("attackpoint");
                hp2 = resultSet.getInt("hp");
                job2= resultSet.getString("job");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Character character = new Character();
        return character;
    }
    public Job getJobStat(String name)
    {
        Connection conn = new JdbcConnection().getJdbc();
        Integer id2=null;
        Integer attackpoint2=null;
        Integer hp2=null;
        String name2=null;
        Integer level2=null;
        String sql = "select id, name ,attackpoint,hp,level " +
                "from jobs " +
                "where name=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                id2=resultSet.getInt("id");
                name2= resultSet.getString("name");
                attackpoint2=resultSet.getInt("attackpoint");
                hp2=resultSet.getInt("hp");
                level2=resultSet.getInt("level");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Job job=new Job(id2,attackpoint2,hp2,name2,level2);
        return job;
    }

    public List<Character> findByCharacter1(String uname, String job) {
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
        String sql = "UPDATE characters SET level = ?, uname = ?, job = ?, hp = ?, attackPoint = ? WHERE uid = ?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, character.getLevel());
            pst.setString(2, character.getUname());
            pst.setString(3, character.getJob());
            pst.setInt(4, character.getHp());
            pst.setInt(5, character.getAttackPoint());
            pst.setInt(6, character.getUid());

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

