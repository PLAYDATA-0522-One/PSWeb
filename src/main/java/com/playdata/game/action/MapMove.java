package com.playdata.game.action;

import com.playdata.game.dto.MapDto;

public class MapMove {

    int X = 4;
    int Y = 3;
    int[] moveBox = new int[2];
    MapDto map = new MapDto(X,Y);
    public int[] moving(int move,int i,int j){
        if(move == 1){
            i = i - 1;
        }
        else if(move == 2){
            j = j - 1;
        }
        else if(move == 3){
            i = i + 1;
        }
        else if(move == 4){
            j = j + 1;
        }
        moveBox[0] = i; // Y좌표
        moveBox[1] = j; // X좌표

        return moveBox;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
}
