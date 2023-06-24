package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuizActivity2 extends AppCompatActivity {

    private RadioGroup radioGroup3;
    private RadioGroup radioGroup4;
    private TextView question3;
    private TextView question4;
    private Button doneButton;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

        radioGroup3 = findViewById(R.id.radioGroup3);
        radioGroup4 = findViewById(R.id.radioGroup4);
        question3 = findViewById(R.id.question3);
        question4 = findViewById(R.id.question4);
        doneButton = findViewById(R.id.doneButton);

        // Retrieve the score from the previous activity
        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);

        // Set the questions
        question3.setText("Question 3: What is the capital of Japan?");
        question4.setText("Question 4: Who wrote the play Romeo and Juliet?");

        // Set the options for each question
        RadioButton q3Option1 = findViewById(R.id.q3Option1);
        RadioButton q3Option2 = findViewById(R.id.q3Option2);
        RadioButton q3Option3 = findViewById(R.id.q3Option3);
        RadioButton q3Option4 = findViewById(R.id.q3Option4);

        RadioButton q4Option1 = findViewById(R.id.q4Option1);
        RadioButton q4Option2 = findViewById(R.id.q4Option2);
        RadioButton q4Option3 = findViewById(R.id.q4Option3);
        RadioButton q4Option4 = findViewById(R.id.q4Option4);

        q3Option1.setText("Tokyo");
        q3Option2.setText("Osaka");
        q3Option3.setText("Kyoto");
        q3Option4.setText("Seoul");

        q4Option1.setText("William Shakespeare");
        q4Option2.setText("Charles Dickens");
        q4Option3.setText("Jane Austen");
        q4Option4.setText("Mark Twain");

        // Set a listener for the done button
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswersAndNavigate();
            }
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Navigate back to the previous activity (MainActivity)
        return true;
    }

    private void checkAnswersAndNavigate() {
        // Check the selected answers and update the score
        RadioButton selectedOption3 = findViewById(radioGroup3.getCheckedRadioButtonId());
        RadioButton selectedOption4 = findViewById(radioGroup4.getCheckedRadioButtonId());

        if (selectedOption3 != null && selectedOption4 != null) {
            if (selectedOption3.getId() == R.id.q3Option1) {
                score += 5;
            }
            if (selectedOption4.getId() == R.id.q4Option1) {
                score += 5;
            }
        }

        // Navigate to ResultActivity and pass the final score
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("score", score);
        startActivity(intent);
    }
}