package com.playdata.game.dao;

import com.playdata.game.config.JdbcConnection;
import com.playdata.game.dto.Character;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatGroup {
    public void showStat(Character character){
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "insert into characters(hp, attack_point) values(?, ?)";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,character.getHp());
            pst.setInt(2, character.getAttackPoint());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
