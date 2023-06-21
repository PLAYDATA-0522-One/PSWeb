package com.playdata.game.dto;

public class Monster {

    private int id;
    private String name;
    private int hp;
    private int attackpoint;
    private int drop_per;
    private int exp;
    private static int now_hp;

    @Override
    public String toString() {
        return "Monster{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", attackpoint=" + attackpoint +
                ", drop_per=" + drop_per +
                ", exp=" + exp +
                ", now_hp=" + now_hp +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttackpoint() {
       int result = (int)Math.random()*attackpoint + (int)attackpoint/2;
        return result; // 기존 어택포인트 랜덤 반경 추가함.
    }

    public void setAttackpoint(int attackpoint) {
        this.attackpoint = attackpoint;
    }

    public int getDrop_per() {
        return drop_per;
    }

    public void setDrop_per(int drop_per) {
        this.drop_per = drop_per;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getNow_hp() {
        return now_hp;
    }

    public void setNow_hp(int now_hp) {
        this.now_hp = now_hp;
    }

    public Monster(int id, String name, int hp, int attackpoint, int drop_per, int exp, int now_hp) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.attackpoint = attackpoint;
        this.drop_per = drop_per;
        this.exp = exp;
        this.now_hp = now_hp;
    }
}
