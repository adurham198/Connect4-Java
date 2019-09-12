package com.example.adurham.testc4;

public class Board {

    private int numCols;
    private int numRows;
    public boolean won;
    public Board[][] cells;
    char bcells[][];


    public void buildcells() {
        for (int r = 0; r <= 6; r++)
        {
            for (int c = 0; c<=7; c++)
            {
                bcells[r][c] = 'E';
            }
        }

    }

    public enum Turn
    {
        PLAYER, AI;
    }



}
