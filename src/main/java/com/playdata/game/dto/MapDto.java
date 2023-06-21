package com.playdata.game.dto;

public class MapDto {

    private int[][] map;

    public MapDto(int i,int j){
        this.map = new int[i][j];
    }

    public int[][] getMap() {
        return map;
    }

    public void setMap(int y,int x,int mode){
        this.map[y][x] = mode;

    }
}
