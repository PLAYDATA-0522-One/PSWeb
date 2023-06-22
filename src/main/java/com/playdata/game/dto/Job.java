package com.playdata.game.dto;
public class Job {
    private int id;
    private int attackpoint;
    private int hp;
    private String name;
    private int level;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAttackpoint() {
        return attackpoint;
    }
    public void setAttackpoint(int attackpoint) {
        this.attackpoint = attackpoint;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public Job(int id, int attackpoint, int hp, String name, int level) {
        this.id = id;
        this.attackpoint = attackpoint;
        this.hp = hp;
        this.name = name;
        this.level = level;
    }
}