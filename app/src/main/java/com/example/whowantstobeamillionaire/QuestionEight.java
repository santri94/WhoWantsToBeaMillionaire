package com.example.whowantstobeamillionaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionEight extends AppCompatActivity {

    RadioButton carriage, wrestling, cocktail, horse;
    TextView money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_eight);
        money = (TextView) findViewById(R.id.earnedValue);
        carriage = (RadioButton)findViewById(R.id.Carriage);
        wrestling = (RadioButton)findViewById(R.id.Wrestling);
        cocktail = (RadioButton)findViewById(R.id.Cocktail);
        horse = (RadioButton)findViewById(R.id.Horse);
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
        if (carriage.isChecked()){
            answerSelected = "Carriage";
        }
        if (wrestling.isChecked()){
            answerSelected = "Wrestling Style";
        }
        if (cocktail.isChecked()){
            answerSelected = "Cocktail";
        }
        if (horse.isChecked()){
            answerSelected = "Horse";
        }

        //Get money earned
        Bundle extras = getIntent().getExtras();
        int earnedSoFar = extras.getInt("earnedMoney");

        if (answerSelected.equals("Horse")){
            Toast.makeText(getApplicationContext(), "Correct! You earned $800"  , Toast.LENGTH_SHORT).show();

            int earnedMoney = 800 + earnedSoFar;
            Intent intent=new Intent(QuestionEight.this, WinPage.class);
            intent.putExtra("earnedMoney",earnedMoney);
            startActivity(intent);
            finish();
        }
        else{
            Intent intent=new Intent(QuestionEight.this, GameOver.class);
            intent.putExtra("earnedMoney", earnedSoFar);
            startActivity(intent);
            finish();
        }


    }
}
