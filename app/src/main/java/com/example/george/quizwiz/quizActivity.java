package com.example.george.quizwiz;


import android.os.Bundle;

import butterknife.ButterKnife;


public class quizActivity extends MainActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity);
        ButterKnife.bind(this);
    }


}
