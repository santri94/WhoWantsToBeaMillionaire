package com.example.whowantstobeamillionaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionThree extends AppCompatActivity {

    RadioButton thirtyyearswar, hundredyearswar, warofroses, englishcivilwar;
    TextView money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_three);
        money = (TextView) findViewById(R.id.earnedValue);
        thirtyyearswar = (RadioButton)findViewById(R.id.ThirtyYearsWar);
        hundredyearswar = (RadioButton)findViewById(R.id.HundredYearsWar);
        warofroses = (RadioButton)findViewById(R.id.WarOfTheRoses);
        englishcivilwar = (RadioButton)findViewById(R.id.EnglishCivilWar);
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
        if (thirtyyearswar.isChecked()){
            answerSelected = "Thirty Years War";
        }
        if (hundredyearswar.isChecked()){
            answerSelected = "Hundred Years War";
        }
        if (warofroses.isChecked()){
            answerSelected = "War of the Roses";
        }
        if (englishcivilwar.isChecked()){
            answerSelected = "English Civil War";
        }

        //Get money earned
        Bundle extras = getIntent().getExtras();
        int earnedSoFar = extras.getInt("earnedMoney");

        if (answerSelected.equals("War of the Roses")){
            Toast.makeText(getApplicationContext(), "Correct! You earned $300"  , Toast.LENGTH_SHORT).show();

            int earnedMoney = 300 + earnedSoFar;
            Intent intent=new Intent(QuestionThree.this, QuestionFour.class);
            intent.putExtra("earnedMoney",earnedMoney);
            startActivity(intent);
            finish();
        }
        else{
            Intent intent=new Intent(QuestionThree.this, GameOver.class);
            intent.putExtra("earnedMoney", earnedSoFar);
            startActivity(intent);
            finish();
        }


    }
}
