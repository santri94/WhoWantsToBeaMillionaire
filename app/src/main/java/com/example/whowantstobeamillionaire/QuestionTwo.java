package com.example.whowantstobeamillionaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionTwo extends AppCompatActivity {

    RadioButton manuel, pedro, alfonso, javier;
    TextView money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_two);
        setCurrentMoney();
        money = (TextView) findViewById(R.id.textView2);
        manuel = (RadioButton)findViewById(R.id.Manuel);
        pedro = (RadioButton)findViewById(R.id.Pedro);
        alfonso = (RadioButton)findViewById(R.id.Alfonso);
        javier = (RadioButton)findViewById(R.id.Javier);
    }

    public void setCurrentMoney() {
        Bundle extras = getIntent().getExtras();
        Double earnedSoFar = extras.getDouble("earnedMoney");

        money.setText("Earned $"+earnedSoFar);

    }

    public void NextQuestion(View view){


        //----------------------------------------------------------------------------------------
        //                              - Validate answer
        //                              - Get Current Money earned
        //----------------------------------------------------------------------------------------

        String answerSelected = "";
        if (manuel.isChecked()){
            answerSelected = "Manuel";
        }
        if (pedro.isChecked()){
            answerSelected = "Pedro";
        }
        if (alfonso.isChecked()){
            answerSelected = "Alfonso";
        }
        if (javier.isChecked()){
            answerSelected = "Javier";
        }

        //Get money earned
        Bundle extras = getIntent().getExtras();
        Double earnedSoFar = extras.getDouble("earnedMoney");

        if (answerSelected.equals("Manuel")){
            Toast.makeText(getApplicationContext(), "Correct! You earned $200"  , Toast.LENGTH_SHORT).show();

            double earnedMoney = 200.00 + earnedSoFar;
            Intent intent=new Intent(QuestionTwo.this, QuestionThree.class);
            intent.putExtra("earnedMoney",earnedMoney);
            startActivity(intent);
            finish();
        }
        else{
            Intent intent=new Intent(QuestionTwo.this, GameOver.class);
            intent.putExtra("earnedMoney", earnedSoFar);
            startActivity(intent);
            finish();
        }


    }
}
