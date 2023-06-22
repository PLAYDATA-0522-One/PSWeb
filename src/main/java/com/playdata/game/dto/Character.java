package com.playdata.game.dto;

public class Character {
    private int id;
    private int uid;
    private int level;
    private String uname;
    private String job;
    private int hp;
    private int attackPoint;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public int getLevel() {
        return level;
    }

    public String getUname() {
        return uname;
    }

    public String getJob() {
        return job;
    }

    public int getHp() {
        return hp;
    }

    public int getAttackPoint() {
        return attackPoint;
    }



    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAttackPoint(int attackPoint) {
        this.attackPoint = attackPoint;
    }




    @Override
    public String toString() {
        return "Character{" +
                "uid=" + uid +
                ", level=" + level +
                ", uname='" + uname + '\'' +
                ", job='" + job + '\'' +
                ", hp=" + hp +
                ", attackPoint=" + attackPoint +
                '}';
    }

}



