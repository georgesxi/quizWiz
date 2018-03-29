package com.example.george.quizwiz;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    /**
     * ButterKnife views
     */
    //Question 1
    @Nullable
    @BindView(R.id.question1)
    EditText question1;
    //Question 2
    @Nullable
    @BindView(R.id.question2)
    EditText question2;
    //Question 3
    @Nullable
    @BindView(R.id.q3a)
    CheckBox q3AnswerA;
    @Nullable
    @BindView(R.id.q3b)
    CheckBox q3AnswerB;
    @Nullable
    @BindView(R.id.q3c)
    CheckBox q3AnswerC;
    @Nullable
    @BindView(R.id.q3d)
    CheckBox q3AnswerD;
    //Question 4
    @Nullable
    @BindView(R.id.q4a)
    CheckBox q4AnswerA;
    @Nullable
    @BindView(R.id.q4b)
    CheckBox q4AnswerB;
    @Nullable
    @BindView(R.id.q4c)
    CheckBox q4AnswerC;
    @Nullable
    @BindView(R.id.q4d)
    CheckBox q4AnswerD;
    //Question 5
    @Nullable
    @BindView(R.id.q5_radio_group)
    RadioGroup question5RadioGroup;

    /**
     * End ButterKnife view binding
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void exit(View view) {
        finish();
    }

    public void startQuiz(View view) {
        //Displays XML quiz Activity
        //This is used to start using a new class when the activity changes
        Intent intent = new Intent(this, quizActivity.class);
        startActivity(intent);
    }

    public void submit(View view) {
        int secBoxText1 = -1;
        int firstBoxText1 = -1;
        String heroName = "";

        //Question 1
        if (TextUtils.isEmpty(question1.getText().toString())) {
            Toast.makeText(this, "Answer 1 cannot be empty", Toast.LENGTH_LONG).show();
        } else {
            int firstBoxText = Integer.parseInt(question1.getText().toString());
            firstBoxText1 = firstBoxText;
        }
        //Question 2
        if (TextUtils.isEmpty(question2.getText().toString())) {
            Toast.makeText(this, "Answer 2 cannot be empty", Toast.LENGTH_LONG).show();
        } else {
            int secBoxText = Integer.parseInt(question2.getText().toString());
            secBoxText1 = secBoxText;
        }
        //Question 3
        boolean q3Box1 = q3AnswerA.isChecked();
        boolean q3Box2 = q3AnswerB.isChecked();
        boolean q3Box3 = q3AnswerC.isChecked();
        boolean q3Box4 = q3AnswerD.isChecked();
        //Question 4
        boolean q4Box1 = q4AnswerA.isChecked();
        boolean q4Box2 = q4AnswerB.isChecked();
        boolean q4Box3 = q4AnswerC.isChecked();
        boolean q4Box4 = q4AnswerD.isChecked();
        //End of Q4

        //Question 5
        int q5a = question5RadioGroup.getCheckedRadioButtonId();
        if (q5a == -1) {
            //Do nothing
        } else {
            RadioButton button = (RadioButton) findViewById(q5a);
            heroName = button.getText().toString();
        }
        //End of Q5

        if (firstBoxText1 == -1 || secBoxText1 == -1 || q5a == -1) {
            //Don't run the results function if an answer is empty.
            // A Toast will be displayed informing the user
            Toast.makeText(this, "Please answer all questions", Toast.LENGTH_LONG).show();

        } else {
            String results = evaluateAnswers(firstBoxText1, secBoxText1, q3Box1, q3Box2, q3Box3, q3Box4, q4Box1, q4Box2,
                    q4Box3, q4Box4, heroName);
            Toast.makeText(this, results, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * @param firstBoxText This is the first answer passed to the function (int)
     * @param secBoxText   This is the second answer passed to the function (int)
     * @param q3a          This is the first checkbox of question3 passed to the function (boolean)
     * @param q3b          This is the second checkbox of question3 passed to the function (boolean)
     * @param q3c          This is the third checkbox of question3 passed to the function (boolean)
     * @param q3d          This is the fourth checkbox of question 3 passed to the function (boolean)
     * @param q4a          This is the first checkbox of question4 passed to the function (boolean)
     * @param q4b          This is the second checkbox of question4 passed to the function (boolean)
     * @param q4c          This is the third checkbox of question4 passed to the function (boolean)
     * @param q4d          This is the fourth checkbox of question4 passed to the function (boolean)
     * @param q5           This is the selected radio button of question5 passed to the function (string)
     * @return returns the correct answers
     */
    private String evaluateAnswers(int firstBoxText, int secBoxText, boolean q3a, boolean q3b, boolean q3c, boolean q3d,
                                   boolean q4a, boolean q4b, boolean q4c, boolean q4d, String q5) {
        boolean q1 = false;
        boolean q2 = false;
        boolean q3 = false;
        boolean q4 = false;
        int correctAnswers = 0;

        if (firstBoxText == 12) {
            q1 = true;
            question1.setBackgroundColor(Color.parseColor("green"));
            correctAnswers += 1;
        } else {
            q1 = false;
            question1.setBackgroundColor(Color.parseColor("red"));
        }
        if (secBoxText == 12) {
            q2 = true;
            question2.setBackgroundColor(Color.parseColor("green"));
            correctAnswers += 1;

        } else {
            q2 = false;
            question2.setBackgroundColor(Color.parseColor("red"));
        }

        if (q3a && q3b && q3c && !q3d) {
            q3 = true;
            q3AnswerA.setBackgroundColor(Color.parseColor("green"));
            q3AnswerB.setBackgroundColor(Color.parseColor("green"));
            q3AnswerC.setBackgroundColor(Color.parseColor("green"));
            q3AnswerD.setBackgroundColor(Color.parseColor("white"));
            correctAnswers += 1;
        } else {
            q3 = false;
            q3AnswerA.setBackgroundColor(Color.parseColor("green"));
            q3AnswerB.setBackgroundColor(Color.parseColor("green"));
            q3AnswerC.setBackgroundColor(Color.parseColor("green"));
            q3AnswerD.setBackgroundColor(Color.parseColor("red"));
        }
        //Question 4
        if (q4a && q4b && q4d && !q4c) {
            q4 = true;
            q4AnswerA.setBackgroundColor(Color.parseColor("green"));
            q4AnswerB.setBackgroundColor(Color.parseColor("green"));
            q4AnswerC.setBackgroundColor(Color.parseColor("white"));
            q4AnswerD.setBackgroundColor(Color.parseColor("green"));
            correctAnswers += 1;
        } else {
            q4 = false;
            q4AnswerA.setBackgroundColor(Color.parseColor("green"));
            q4AnswerB.setBackgroundColor(Color.parseColor("green"));
            q4AnswerC.setBackgroundColor(Color.parseColor("red"));
            q4AnswerD.setBackgroundColor(Color.parseColor("green"));
        }

        //Question 5
        if ("Ajax the Great".equals(q5)) {
            question5RadioGroup.setBackgroundColor(Color.parseColor("green"));
            correctAnswers += 1;


        } else {
            question5RadioGroup.setBackgroundColor(Color.parseColor("red"));
        }

        if (correctAnswers == 5) {
            String results = "Your total correct answers are: " + correctAnswers + " \nAre you a Greek God? Excellent!!!!";
            return results;
        } else if (correctAnswers > 3 && correctAnswers < 5) {
            String results = "Your total correct answers are: " + correctAnswers + " \nYou might be related to a demi-god!! \nWrong answers are marked in red!";

            return results;
        } else {

            String results = "Your total correct answers are: " + correctAnswers + " \nNot a Mythology fan eh? \nWrong answers are marked in red!";

            return results;
        }
    }
}