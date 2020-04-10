package com.example.whowantstobeamillionaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionSix extends AppCompatActivity {

    RadioButton irving, georgeGershwin, aaron, cole;
    TextView money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_six);
        money = (TextView) findViewById(R.id.earnedValue);
        irving = (RadioButton)findViewById(R.id.Irving);
        georgeGershwin = (RadioButton)findViewById(R.id.GeorgeGershwin);
        aaron = (RadioButton)findViewById(R.id.Aaron);
        cole = (RadioButton)findViewById(R.id.Cole);
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
        if (irving.isChecked()){
            answerSelected = "Irving Berlin";
        }
        if (georgeGershwin.isChecked()){
            answerSelected = "George Gershwin";
        }
        if (aaron.isChecked()){
            answerSelected = "Aaron Copland";
        }
        if (cole.isChecked()){
            answerSelected = "Cole Porter";
        }

        //Get money earned
        Bundle extras = getIntent().getExtras();
        int earnedSoFar = extras.getInt("earnedMoney");

        if (answerSelected.equals("George Gershwin")){
            Toast.makeText(getApplicationContext(), "Correct! You earned $600"  , Toast.LENGTH_SHORT).show();

            int earnedMoney = 600 + earnedSoFar;
            Intent intent=new Intent(QuestionSix.this, QuestionSeven.class);
            intent.putExtra("earnedMoney",earnedMoney);
            startActivity(intent);
            finish();
        }
        else{
            Intent intent=new Intent(QuestionSix.this, GameOver.class);
            intent.putExtra("earnedMoney", earnedSoFar);
            startActivity(intent);
            finish();
        }


    }
}
