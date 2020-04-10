package com.example.whowantstobeamillionaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionFour extends AppCompatActivity {

    RadioButton john, paul, george, ringo;
    TextView money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_four);
        money = (TextView) findViewById(R.id.earnedValue);
        john = (RadioButton)findViewById(R.id.John);
        paul = (RadioButton)findViewById(R.id.Paul);
        george = (RadioButton)findViewById(R.id.George);
        ringo = (RadioButton)findViewById(R.id.Ringo);
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
        if (john.isChecked()){
            answerSelected = "John Lennon";
        }
        if (paul.isChecked()){
            answerSelected = "Paul McCartney";
        }
        if (george.isChecked()){
            answerSelected = "George Harrison";
        }
        if (ringo.isChecked()){
            answerSelected = "Ringo Starr";
        }

        //Get money earned
        Bundle extras = getIntent().getExtras();
        int earnedSoFar = extras.getInt("earnedMoney");

        if (answerSelected.equals("Ringo Starr")){
            Toast.makeText(getApplicationContext(), "Correct! You earned $400"  , Toast.LENGTH_SHORT).show();

            int earnedMoney = 400 + earnedSoFar;
            Intent intent=new Intent(QuestionFour.this, QuestionFive.class);
            intent.putExtra("earnedMoney",earnedMoney);
            startActivity(intent);
            finish();
        }
        else{
            Intent intent=new Intent(QuestionFour.this, GameOver.class);
            intent.putExtra("earnedMoney", earnedSoFar);
            startActivity(intent);
            finish();
        }


    }
}
