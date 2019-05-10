/*
 * PROJECT LICENSE
 *
 * This project was submitted by Janas Chatkevicius as part of the Nanodegree At Udacity.
 *
 * As part of Udacity Honor code, your submissions must be your own work, hence
 * submitting this project as yours will cause you to break the Udacity Honor Code
 * and the suspension of your account.
 *
 * Me, the author of the project, allow you to check the code as a reference, but if
 * you submit it, it's your own responsibility if you get expelled.
 *
 * Copyright (c) 2018 Janas Chatkevicius
 *
 * Besides the above notice, the following license applies and this license notice
 * must be included in all works derived from this project.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int finalScore = 0;

    public void calculateScore() {
        RadioGroup radiobuttonGroupOne = findViewById(R.id.question_one_radio_group);
        boolean scoreOne = radiobuttonGroupOne
                .getCheckedRadioButtonId() == R.id.question_one_answer_three_radiobutton;

        if (scoreOne) finalScore += 1;

        RadioGroup radiobuttonGroupTwo = findViewById(R.id.question_two_radio_group);
        boolean scoreTwo = radiobuttonGroupTwo
                .getCheckedRadioButtonId() == R.id.question_two_answer_one_radiobutton;

        if (scoreTwo) finalScore += 1;

        RadioGroup radiobuttonGroupThree = findViewById(R.id.question_three_radio_group);
        boolean scoreThree = radiobuttonGroupThree
                .getCheckedRadioButtonId() == R.id.question_three_answer_three_radiobutton;

        if (scoreThree) finalScore += 1;

        RadioGroup radiobuttonGroupFour = findViewById(R.id.question_four_radio_group);
        boolean scoreFour = radiobuttonGroupFour
                .getCheckedRadioButtonId() == R.id.question_four_answer_one_radiobutton;

        if (scoreFour) finalScore += 1;

        RadioGroup radiobuttonGroupFive = findViewById(R.id.question_five_radio_group);
        boolean scoreFive = radiobuttonGroupFive
                .getCheckedRadioButtonId() == R.id.question_five_answer_one_radiobutton;

        if (scoreFive) finalScore += 1;

        String answerWithFirstCapitalLetter;
        EditText editTextQuestionSix = findViewById(R.id.question_six_edit_text);
        String editTextString = editTextQuestionSix.getText().toString();
        boolean scoreSix;
        if (editTextString.equals("")) {
            scoreSix = false;
        } else {
            answerWithFirstCapitalLetter =
                    editTextString.substring(0, 1).toUpperCase() + editTextString.substring(1);
            scoreSix = answerWithFirstCapitalLetter.equals("Sun");
        }

        if (scoreSix) finalScore += 1;

        CheckBox checkBoxAnswerOne = findViewById(R.id.question_seven_answer_one_checkbox);
        CheckBox checkBoxAnswerTwo = findViewById(R.id.question_seven_answer_two_checkbox);
        CheckBox checkBoxAnswerThree = findViewById(R.id.question_seven_answer_three_checkbox);
        CheckBox checkBoxAnswerFour = findViewById(R.id.question_seven_answer_four_checkbox);

        if (checkBoxAnswerThree.isChecked() || checkBoxAnswerFour.isChecked()) {
            finalScore += 0;
        } else if (checkBoxAnswerOne.isChecked() && checkBoxAnswerTwo.isChecked()) {
            finalScore += 1;
        }
    }

    public void submitAnswers(View view) {
        finalScore = 0;
        calculateScore();

        int allScore = 7;
        String toastMessage =
                "Answered correctly " +
                        String.valueOf(finalScore) +
                        " out of " + String.valueOf(allScore);
        Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show();
    }
}
