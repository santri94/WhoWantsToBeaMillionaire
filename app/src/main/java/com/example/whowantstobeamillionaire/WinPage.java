package com.example.whowantstobeamillionaire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class WinPage extends AppCompatActivity {

    TextView money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_page);
        money = (TextView) findViewById(R.id.earnedValue);
        setCurrentMoney();
    }

    public void setCurrentMoney() {
        Bundle extras = getIntent().getExtras();
        int earnedSoFar = extras.getInt("earnedMoney");

        money.setText("Earned $"+earnedSoFar);

    }
}
