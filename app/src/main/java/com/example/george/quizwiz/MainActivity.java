package com.example.george.quizwiz;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
        //

        EditText firstBox = (EditText) findViewById(R.id.question1);
        if (TextUtils.isEmpty(firstBox.getText().toString())) {
            Toast.makeText(this, "Answer 1 cannot be empty", Toast.LENGTH_LONG).show();
        } else {
            int firstBoxText = Integer.parseInt(firstBox.getText().toString());
            firstBoxText1 = firstBoxText;
        }

        //Question 2
        //

        EditText secBox = (EditText) findViewById(R.id.question2);
        if (TextUtils.isEmpty(secBox.getText().toString())) {
            Toast.makeText(this, "Answer 2 cannot be empty", Toast.LENGTH_LONG).show();
        } else {
            int secBoxText = Integer.parseInt(secBox.getText().toString());
            secBoxText1 = secBoxText;
        }

        //Question 3
        //

        CheckBox checkBoxA = (CheckBox) findViewById(R.id.q3a);
        boolean q3Box1 = checkBoxA.isChecked();

        CheckBox checkBoxB = (CheckBox) findViewById(R.id.q3b);
        boolean q3Box2 = checkBoxB.isChecked();

        CheckBox checkBoxC = (CheckBox) findViewById(R.id.q3c);
        boolean q3Box3 = checkBoxC.isChecked();

        CheckBox checkBoxD = (CheckBox) findViewById(R.id.q3d);
        boolean q3Box4 = checkBoxD.isChecked();

        //Question 4
        //

        CheckBox checkBox4A = (CheckBox) findViewById(R.id.q4a);
        boolean q4Box1 = checkBox4A.isChecked();

        CheckBox checkBox4B = (CheckBox) findViewById(R.id.q4b);
        boolean q4Box2 = checkBox4B.isChecked();

        CheckBox checkBox4C = (CheckBox) findViewById(R.id.q4c);
        boolean q4Box3 = checkBox4C.isChecked();

        CheckBox checkBox4D = (CheckBox) findViewById(R.id.q4d);
        boolean q4Box4 = checkBox4D.isChecked();
        //End of Q4

        //Question 5
        //

        RadioGroup correct5 = (RadioGroup) findViewById(R.id.radio);
        int q5a = correct5.getCheckedRadioButtonId();
        if (q5a == -1) {

            //Do nothing a toast will be displayed

        } else {
            RadioButton button = (RadioButton) findViewById(q5a);
            heroName = button.getText().toString();
            Log.v("test", "this is " + q5a + "test" + heroName);
        }
        //End of Q5


        if (firstBoxText1 == -1 || secBoxText1 == -1 || q5a == -1) {
            //Don't run the results function if an answer is empty.
            // A Toast will be displayed informing the user
            Toast.makeText(this, "Please answer all questions", Toast.LENGTH_SHORT).show();

        } else {
            String results = evaluateAnswers(firstBoxText1, secBoxText1, q3Box1, q3Box2, q3Box3, q3Box4, q4Box1, q4Box2,
                    q4Box3, q4Box4, heroName);
            Toast.makeText(this, results, Toast.LENGTH_SHORT).show();

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
            EditText correctA = findViewById(R.id.question1);
            correctA.setBackgroundColor(Color.parseColor("green"));
            correctAnswers += 1;
        } else {
            q1 = false;
            EditText correctA = findViewById(R.id.question1);
            correctA.setBackgroundColor(Color.parseColor("red"));
        }
        if (secBoxText == 12) {
            q2 = true;
            EditText correctB = findViewById(R.id.question2);
            correctB.setBackgroundColor(Color.parseColor("green"));
            correctAnswers += 1;

        } else {
            q2 = false;
            EditText correctB = findViewById(R.id.question2);
            correctB.setBackgroundColor(Color.parseColor("red"));
        }

        if (q3a && q3b && q3c && !q3d) {
            q3 = true;
            CheckBox correctA = (CheckBox) findViewById(R.id.q3a);
            CheckBox correctB = (CheckBox) findViewById(R.id.q3b);
            CheckBox correctC = (CheckBox) findViewById(R.id.q3c);
            CheckBox correctD = (CheckBox) findViewById(R.id.q3d);

            correctA.setBackgroundColor(Color.parseColor("green"));
            correctB.setBackgroundColor(Color.parseColor("green"));
            correctC.setBackgroundColor(Color.parseColor("green"));
            correctD.setBackgroundColor(Color.parseColor("white"));

            correctAnswers += 1;


        } else {
            q3 = false;
            CheckBox correctA = (CheckBox) findViewById(R.id.q3a);
            CheckBox correctB = (CheckBox) findViewById(R.id.q3b);
            CheckBox correctC = (CheckBox) findViewById(R.id.q3c);
            CheckBox correctD = (CheckBox) findViewById(R.id.q3d);
            correctA.setBackgroundColor(Color.parseColor("green"));
            correctB.setBackgroundColor(Color.parseColor("green"));
            correctC.setBackgroundColor(Color.parseColor("green"));
            correctD.setBackgroundColor(Color.parseColor("red"));

        }

        //Question 4
        if (q4a && q4b && q4d && !q4c) {
            q4 = true;
            CheckBox correct4A = (CheckBox) findViewById(R.id.q4a);
            CheckBox correct4B = (CheckBox) findViewById(R.id.q4b);
            CheckBox correct4C = (CheckBox) findViewById(R.id.q4c);
            CheckBox correct4D = (CheckBox) findViewById(R.id.q4d);
            correct4A.setBackgroundColor(Color.parseColor("green"));
            correct4B.setBackgroundColor(Color.parseColor("green"));
            correct4C.setBackgroundColor(Color.parseColor("white"));
            correct4D.setBackgroundColor(Color.parseColor("green"));
            correctAnswers += 1;

        } else {
            q4 = false;
            CheckBox correct4A = (CheckBox) findViewById(R.id.q4a);
            CheckBox correct4B = (CheckBox) findViewById(R.id.q4b);
            CheckBox correct4C = (CheckBox) findViewById(R.id.q4c);
            CheckBox correct4D = (CheckBox) findViewById(R.id.q4d);
            correct4A.setBackgroundColor(Color.parseColor("green"));
            correct4B.setBackgroundColor(Color.parseColor("green"));
            correct4C.setBackgroundColor(Color.parseColor("red"));
            correct4D.setBackgroundColor(Color.parseColor("green"));

        }

        //Question 5
        if ("Ajax the Great".equals(q5)) {
            RadioGroup correct5A = (RadioGroup) findViewById(R.id.radio);
            correct5A.setBackgroundColor(Color.parseColor("green"));
            correctAnswers += 1;


        } else {
            RadioGroup correct5A = (RadioGroup) findViewById(R.id.radio);
            correct5A.setBackgroundColor(Color.parseColor("red"));
        }

        if (correctAnswers == 5) {
            String results = "Your total correct answers are: " + correctAnswers + " \nAre you a Greek God? Excellent!!!!";
            return results;
        } else if (correctAnswers > 3 && correctAnswers < 5) {
            String results = "Your total correct answers are: " + correctAnswers + " \nYou might be related to a demi-god!! \nCheck the Red lines for the errors!";

            return results;
        } else {

            String results = "Your total correct answers are: " + correctAnswers + " \nNot a Mythology fan eh? \nCheck the Red lines for the errors!";

            return results;
        }
    }


}
