package com.example.whowantstobeamillionaire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {

    TextView money;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        money = (TextView)findViewById(R.id.earnedMoney);
        setMoneyEarned();
    }

    public void setMoneyEarned() {
        Bundle extras = getIntent().getExtras();
        double tmp = extras.getDouble("earnedMoney");
        money.setText("$"+tmp);
    }
}
