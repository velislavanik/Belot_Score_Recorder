package com.example.android.belot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Team teamA = new Team();
    Team teamB = new Team();
    Game game = new Game();
    String lineA = "";
    String lineB = "";
    int lastAScore=0;
    int lastBScore=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // on press Team A button
    public void scoreA(View view) {
        EditText num = (EditText) findViewById(R.id.edit_score);

        try {
            int number = Integer.parseInt(num.getText().toString());
            if (number > 0) {
                setPointA(number);
                teamA.addScore(number);
                lastAScore=number;
            }

        } catch (NumberFormatException nfe) {
            System.out.println("Could not parse " + nfe);
        }
    }

    //setting current score for team A
    private void setPointA(int score) {
        if (teamA.getScore()>0) {
            int sum = score + teamA.getScore();
            lineA+="+"+score+"="+sum+"\n"+sum;
            TextView textA = (TextView) findViewById(R.id.writeA);
            textA.setText(lineA);
        }
        else {
            lineA = score+"";
            TextView textA = (TextView) findViewById(R.id.writeA);
            textA.setText(lineA);
        }
    }

    //on press Team B button
    public void scoreB(View view) {
        EditText num = (EditText) findViewById(R.id.edit_score);

        try {
            int number = Integer.parseInt(num.getText().toString());
            if (number > 0) {
                setPointB(number);
                teamB.addScore(number);
                lastBScore=number;
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Could not parse " + nfe);
        }
    }

    //setting current score for team B
    private void setPointB(int score) {
        if (teamB.getScore()>0) {
            int sum = score + teamB.getScore();
            lineB+="+"+score+"="+sum+"\n"+sum;
            TextView textB = (TextView) findViewById(R.id.writeB);
            textB.setText(lineB);
        }
        else {
            lineB =""+score;
            TextView textB = (TextView) findViewById(R.id.writeB);
            textB.setText(lineB);
        }
    }

    // on press Reset button clear current game scores and game result
    public void delScore(View view) {
        game.delPoints();
        TextView gameA = (TextView) findViewById(R.id.gameA);
        gameA.setText("0");
        TextView gameB = (TextView) findViewById(R.id.gameB);
        gameB.setText("0");
        clear();
    }

    //on press Game Over button add point to the winner, clear current game score
    public void gameOver(View view) {
        if ((teamA.getScore()>151)||(teamB.getScore()>151)) {
            if ((teamA.getScore()) > (teamB.getScore())) {
                int p = game.addPointsToA();
                String pInt = String.valueOf(p);
                TextView textA = (TextView) findViewById(R.id.gameA);
                textA.setText(pInt);
            } else if ((teamA.getScore()) < (teamB.getScore())) {
                int p = game.addPointsToB();
                String pInt = String.valueOf(p);
                TextView textB = (TextView) findViewById(R.id.gameB);
                textB.setText(pInt);
            }
            clear();
        }
        else
            Toast.makeText(getApplicationContext(), "151 has not been reached yet.", Toast.LENGTH_SHORT).show();
    }

    // clear current game scores, textView-s for both team and the editView for typing scores
    private void clear() {
        teamA.delScore();
        teamB.delScore();
        lineA = "";
        lineB = "";
        lastAScore=0;
        lastBScore=0;
        TextView textA = (TextView) findViewById(R.id.writeA);
        textA.setText("0+");
        TextView textB = (TextView) findViewById(R.id.writeB);
        textB.setText("0+");
        TextView edit = (TextView) findViewById(R.id.edit_score);
        edit.setText("0");
    }

    //on press delete last scores button substracts the last typed by mistake scores for team A
    // only the last added score can be deleted
    public void scoreAEdit(View view){
        if (lastAScore>0){
            int sum = teamA.getScore()-lastAScore;
            lineA+="-"+lastAScore+"="+sum+"\n"+sum;
            teamA.setScore(sum);
            TextView textA = (TextView) findViewById(R.id.writeA);
            textA.setText(lineA);
            lastAScore=0;
        }
    }

    //on press delete last scores button substracts the last typed by mistake scores for team B
    // only the last added score can be deleted
    public void scoreBEdit(View view){
        if (lastBScore>0){
            int sum = teamB.getScore()-lastBScore;
            lineB+="-"+lastBScore+"="+sum+"\n"+sum;
            teamB.setScore(sum);
            TextView textB = (TextView) findViewById(R.id.writeB);
            textB.setText(lineB);
            lastBScore=0;
        }
    }
}

