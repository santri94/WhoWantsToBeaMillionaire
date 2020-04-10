package com.example.whowantstobeamillionaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionSeven extends AppCompatActivity {

    RadioButton fifteen, twenty, twentyfive, thirty;
    TextView money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_seven);
        money = (TextView) findViewById(R.id.earnedValue);
        fifteen = (RadioButton)findViewById(R.id.Fifteen);
        twenty = (RadioButton)findViewById(R.id.Twenty);
        twentyfive = (RadioButton)findViewById(R.id.TwentyFive);
        thirty = (RadioButton)findViewById(R.id.Thirty);
        setCurrentMoney();
    }

    public void setCurrentMoney() {
        Bundle extras = getIntent().getExtras();
        int earnedSoFar = extras.getInt("earnedMoney");

        money.setText("Earned $"+earnedSoFar);

    }

    public void NextQuestion(View view){


        //----------------------------------------------------------------------------------------
        //                              - Validate answer
        //                              - Get Current Money earned
        //----------------------------------------------------------------------------------------

        String answerSelected = "";
        if (fifteen.isChecked()){
            answerSelected = "15";
        }
        if (twenty.isChecked()){
            answerSelected = "20";
        }
        if (twentyfive.isChecked()){
            answerSelected = "25";
        }
        if (thirty.isChecked()){
            answerSelected = "30";
        }

        //Get money earned
        Bundle extras = getIntent().getExtras();
        int earnedSoFar = extras.getInt("earnedMoney");

        if (answerSelected.equals("25")){
            Toast.makeText(getApplicationContext(), "Correct! You earned $700"  , Toast.LENGTH_SHORT).show();

            int earnedMoney = 700 + earnedSoFar;
            Intent intent=new Intent(QuestionSeven.this, QuestionEight.class);
            intent.putExtra("earnedMoney",earnedMoney);
            startActivity(intent);
            finish();
        }
        else{
            Intent intent=new Intent(QuestionSeven.this, GameOver.class);
            intent.putExtra("earnedMoney", earnedSoFar);
            startActivity(intent);
            finish();
        }


    }
}
