package com.example.android.belot;

/**
 * Created by Velis on 21.02.2018.
 */

public class Team {
    private int score;

    //default constructor
    Team(){
        this.score=0;
    }

    //constructor
    Team(int score){
        this.score=score;
    }

    // adding a score to @score
    public void addScore(int score){
        this.score+=score;
    }

    //deleting the scores
    public void delScore(){
        this.score=0;
    }

    //return the value in @score
    public int getScore(){
        return this.score;
    }

    //set scores
    public void setScore(int num){this.score=num;}
}
