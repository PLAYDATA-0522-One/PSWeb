package com.playdata.game.dto;

public class UserNow {
    public int uid;
    public String uname;
    public int level;
    public int hp;
    public int exp;
    public int gold;
    public int now_x;
    public int now_y;
    public int attackpoint;
    public int now_hp;
    public boolean now_battle;
    public boolean char_dead;

    public int getUid() {
        return uid;
    }

    @Override
    public String toString() {
        return "UserNow{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", level=" + level +
                ", hp=" + hp +
                ", exp=" + exp +
                ", gold=" + gold +
                ", now_x=" + now_x +
                ", now_y=" + now_y +
                ", attackpoint=" + attackpoint +
                ", now_hp=" + now_hp +
                ", now_battle=" + now_battle +
                ", char_dead=" + char_dead +
                '}';
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public void setHp(int Hp) {
        this.hp = Hp;
    }
    public int getHp() {
        return hp;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getNow_x() {
        return now_x;
    }

    public void setNow_x(int now_x) {
        this.now_x = now_x;
    }

    public int getNow_y() {
        return now_y;
    }

    public void setNow_y(int now_y) {
        this.now_y = now_y;
    }

    public int getAttackpoint() {
        return attackpoint; // 기존 어택포인트 랜덤 반경 추가함.
    }

    public int attack() {
        int result = (int)(Math.random()*attackpoint) + (int)(attackpoint/2);
        return result; // 기존 어택포인트 랜덤 반경 추가함.
    }

    public void setAttackpoint(int attackpoint) {
        this.attackpoint = attackpoint;
    }

    public int getNow_hp() {
        return now_hp;
    }

    public void setNow_hp(int now_hp) {
        this.now_hp = now_hp;
    }

    public boolean isNow_battle() {
        return now_battle;
    }

    public void setNow_battle(boolean now_battle) {
        this.now_battle = now_battle;
    }

    public boolean isChar_dead() {
        return char_dead;
    }

    public void setChar_dead(boolean char_dead) {
        this.char_dead = char_dead;
    }

    public UserNow(int uid, String uname, int level, int hp, int exp, int gold, int now_x, int now_y, int attackpoint, boolean now_battle, boolean char_dead) {
        this.uid = uid;
        this.uname = uname;
        this.level = level;
        this.hp = hp;
        this.now_hp = hp;
        this.exp = exp;
        this.gold = gold;
        this.now_x = now_x;
        this.now_y = now_y;
        this.attackpoint = attackpoint;
        this.now_battle = now_battle;
        this.char_dead = char_dead;
    }
}
