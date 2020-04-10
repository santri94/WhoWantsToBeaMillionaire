package com.example.whowantstobeamillionaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void PlayGame(View view){
        Intent intent=new Intent(MainActivity.this, QuestionOne.class);
        //intent.putExtra("answersAndEmail",answersAndEmail);
        startActivity(intent);
        finish();

    }
}
