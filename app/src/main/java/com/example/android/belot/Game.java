package com.example.android.belot;

/**
 * Created by Velis on 22.02.2018.
 */

public class Game{
    int teamA;
    int teamB;

    //constructor
    Game(){
        teamA=0;
        teamB=0;
    }

    //add point to game result for team A
    public int addPointsToA(){
       return this.teamA+=1;

    }

    //add point to game result for team B
    public int addPointsToB(){
       return this.teamB+=1;
    }

    //reset games
    public void delPoints(){
        this.teamA=0;
        this.teamB=0;
    }



}
