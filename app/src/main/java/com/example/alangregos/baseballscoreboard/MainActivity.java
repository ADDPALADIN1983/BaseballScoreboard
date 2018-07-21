package com.example.alangregos.baseballscoreboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int homeScore = 0;
    int homeBall = 0;
    int homeStrike = 0;
    int homeOut = 0;
    int awayScore = 0;
    int awayBall = 0;
    int awayStrike = 0;
    int awayOut = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void nextBatter(View view) {
        homeBall = 0;
        homeBallView(homeBall);
        homeStrike = 0;
        homeStrikeView(homeStrike);
        awayBall = 0;
        awayBallView(awayBall);
        awayStrike = 0;
        awayStrikeView(awayStrike);

    }

    public void clearOuts(View view) {
        awayOut = 0;
        awayOutView(awayOut);
        homeOut = 0;
        homeOutView(homeOut);
    }

    public void resetGame(View view) {
        homeScore = 0;
        homeTeamRunView(homeScore);
        awayScore = 0;
        awayTeamRunView(awayScore);
        nextBatter(view);
        clearOuts(view);
        homeTeamTakesTheField();

        TextView walked = (TextView) findViewById(R.id.batter_events);
        walked.setText("Walks, strike outs and field changes appear here.");

    }

    public void setHomeBall(View view) {
        if (homeBall < 3) {
            homeBall = homeBall + 1;
            homeBallView(homeBall);
            clearEvents();
        } else {
            nextBatter(view);
            batterWalked();

        }
    }

    public void homeBallView(int ball) {
        TextView ballView = (TextView) findViewById(R.id.home_team_balls);
        ballView.setText(String.valueOf(ball));
    }

    public void setHomeStrike(View view) {
        if (homeStrike < 2) {
            homeStrike = homeStrike + 1;
            homeStrikeView(homeStrike);
            clearEvents();
        } else {
            setHomeOut(view);
            nextBatter(view);
            batterStruckOut();

        }
    }

    public void homeStrikeView(int strike) {
        TextView strikeView = (TextView) findViewById(R.id.home_team_strikes);
        strikeView.setText(String.valueOf(strike));
    }

    public void setHomeOut(View view) {
        if (homeOut < 2) {
            homeOut = homeOut + 1;
            homeOutView(homeOut);
            clearEvents();
        } else {
            nextBatter(view);
            clearOuts(view);
            homeTeamTakesTheField();
        }
    }

    public void homeOutView(int out) {
        TextView outView = (TextView) findViewById(R.id.home_team_outs);
        outView.setText(String.valueOf(out));
    }

    public void setHomeScore(View view) {
        homeScore = homeScore + 1;
        homeTeamRunView(homeScore);
        clearEvents();
    }

    public void homeTeamRunView(int run) {
        TextView scoreView = (TextView) findViewById(R.id.home_team_score);
        scoreView.setText(String.valueOf(run));
    }

    public void setAwayBall(View view) {
        if (awayBall < 3) {
            awayBall = awayBall + 1;
            awayBallView(awayBall);
            clearEvents();
        } else {
            awayBall = 0;
            awayBallView(awayBall);
            batterWalked();

        }
    }

    public void awayBallView(int ball) {
        TextView ballView = (TextView) findViewById(R.id.away_team_balls);
        ballView.setText(String.valueOf(ball));
    }

    public void setAwayStrike(View view) {
        if (awayStrike < 2) {
            awayStrike = awayStrike + 1;
            awayStrikeView(awayStrike);
            clearEvents();
        } else {
            setAwayOut(view);
            nextBatter(view);
            batterStruckOut();
        }
    }

    public void awayStrikeView(int strike) {
        TextView strikeView = (TextView) findViewById(R.id.away_team_strikes);
        strikeView.setText(String.valueOf(strike));
    }

    public void setAwayOut(View view) {
        if (awayOut < 2) {
            awayOut = awayOut + 1;
            awayOutView(awayOut);
            clearEvents();
        } else {
            nextBatter(view);
            clearOuts(view);
            awayTeamTakesTheField();
        }
    }

    public void awayOutView(int out) {
        TextView outView = (TextView) findViewById(R.id.away_team_outs);
        outView.setText(String.valueOf(out));
    }

    public void setAwayScore(View view) {
        awayScore = awayScore + 1;
        awayTeamRunView(awayScore);
        clearEvents();
    }

    public void awayTeamRunView(int run) {
        TextView scoreView = (TextView) findViewById(R.id.away_team_score);
        scoreView.setText(String.valueOf(run));
    }
// 4 balls is a walk, 3 strikes is an out, and 3 outs teams switch from fielding to batting or vice versa

    public void batterWalked() {
        TextView walked = (TextView) findViewById(R.id.batter_events);
        walked.setText("The batter was walked.");
    }

    public void clearEvents() {
        TextView clear = (TextView) findViewById(R.id.batter_events);
        clear.setText("");

    }

    public void batterStruckOut() {
        TextView walked = (TextView) findViewById(R.id.batter_events);
        walked.setText("Three strikes and the batter was struck out.");
    }

    public void awayTeamTakesTheField() {
        TextView away = (TextView) findViewById(R.id.away_team_up_to_bat);
        away.setText("Takes the field.");
        TextView event = (TextView) findViewById(R.id.batter_events);
        event.setText("Three strikes and the away team takes the field.");
        TextView home = (TextView) findViewById(R.id.home_team_up_to_bat);
        home.setText("Steps up to the plate.");
    }

    public void homeTeamTakesTheField() {
        TextView home = (TextView) findViewById(R.id.home_team_up_to_bat);
        home.setText("Takes the field.");
        TextView event = (TextView) findViewById(R.id.batter_events);
        event.setText("Three strikes and the home team takes the field.");
        TextView away = (TextView) findViewById(R.id.away_team_up_to_bat);
        away.setText("Steps up to the plate.");
    }

}
