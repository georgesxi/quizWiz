package com.example.george.quizwiz;


import android.os.Bundle;



public class quizActivity extends MainActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity);

        //used to display the back button
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

    }


}
