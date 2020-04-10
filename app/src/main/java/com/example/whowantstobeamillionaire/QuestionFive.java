package com.example.whowantstobeamillionaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionFive extends AppCompatActivity {

    RadioButton james, henry, victoria, william;
    TextView money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_five);
        money = (TextView) findViewById(R.id.earnedValue);
        james = (RadioButton)findViewById(R.id.James);
        henry = (RadioButton)findViewById(R.id.Henry);
        victoria = (RadioButton)findViewById(R.id.Victoria);
        william = (RadioButton)findViewById(R.id.William);
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
        if (james.isChecked()){
            answerSelected = "James II";
        }
        if (henry.isChecked()){
            answerSelected = "Henry VIII";
        }
        if (victoria.isChecked()){
            answerSelected = "Victoria";
        }
        if (william.isChecked()){
            answerSelected = "William I";
        }

        //Get money earned
        Bundle extras = getIntent().getExtras();
        int earnedSoFar = extras.getInt("earnedMoney");

        if (answerSelected.equals("James II")){
            Toast.makeText(getApplicationContext(), "Correct! You earned $500"  , Toast.LENGTH_SHORT).show();

            int earnedMoney = 500 + earnedSoFar;
            Intent intent=new Intent(QuestionFive.this, QuestionSix.class);
            intent.putExtra("earnedMoney",earnedMoney);
            startActivity(intent);
            finish();
        }
        else{
            Intent intent=new Intent(QuestionFive.this, GameOver.class);
            intent.putExtra("earnedMoney", earnedSoFar);
            startActivity(intent);
            finish();
        }


    }
}
