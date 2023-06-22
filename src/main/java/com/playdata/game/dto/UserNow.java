package com.playdata.game.dto;

public class UserNow {
    private int uid;
    private String uname;
    private int level;
    private int hp;
    private int exp;
    private int gold;
    private int attackpoint;
    private int now_hp;
  private  int portion;

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
                ", attackpoint=" + attackpoint +
                ", now_hp=" + now_hp +
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

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }

    public UserNow(int uid, String uname, int level, int hp, int exp, int gold, int attackpoint, int portion) {
        this.uid = uid;
        this.uname = uname;
        this.level = level;
        this.hp = hp;
        this.now_hp = hp;
        this.exp = exp;
        this.gold = gold;
        this.attackpoint = attackpoint;
        this.portion = portion;

    }
}
