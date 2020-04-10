package com.example.whowantstobeamillionaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class QuestionOne extends AppCompatActivity {

    RadioButton deer, rabbit, elephant, donkey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);
        deer = (RadioButton)findViewById(R.id.Deer);
        rabbit = (RadioButton)findViewById(R.id.Rabbit);
        elephant = (RadioButton)findViewById(R.id.Elephant);
        donkey = (RadioButton)findViewById(R.id.Donkey);

    }

    public void NextQuestion(View view){

        //----------------------------------------------------------------------------------------
        //                              - Validate answer
        //----------------------------------------------------------------------------------------

        String answerSelected = "";
        if (deer.isChecked()){
            answerSelected = "Deer";
        }
        if (rabbit.isChecked()){
            answerSelected = "Rabbit";
        }
        if (elephant.isChecked()){
            answerSelected = "Elephant";
        }
        if (donkey.isChecked()){
            answerSelected = "Donkey";
        }

        if (answerSelected.equals("Elephant")){
            Toast.makeText(getApplicationContext(), "Correct! You earned $100"  , Toast.LENGTH_SHORT).show();

            double earnedMoney = 100.00;
            Intent intent=new Intent(QuestionOne.this, QuestionTwo.class);
            intent.putExtra("earnedMoney",earnedMoney);
            startActivity(intent);
            finish();
        }
        else{
            double earnedMoney = 0; // 0 because we haven't earned any money
            Intent intent=new Intent(QuestionOne.this, GameOver.class);
            intent.putExtra("earnedMoney", earnedMoney);
            startActivity(intent);
            finish();
        }


    }
}
