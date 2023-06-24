package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class Activity4 extends AppCompatActivity {

    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;
    private TextView question1;
    private TextView question2;
    private Button nextButton;

    private int score = 0; // To keep track of the score

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        radioGroup1 = findViewById(R.id.radioGroup1);
        radioGroup2 = findViewById(R.id.radioGroup2);
        question1 = findViewById(R.id.question1);
        question2 = findViewById(R.id.question2);
        nextButton = findViewById(R.id.nextButton);

        // Set the questions
        question1.setText("Question 1: What is the capital of France?");
        question2.setText("Question 2: Who painted the Mona Lisa?");

        // Set the options for each question
        RadioButton q1Option1 = findViewById(R.id.q1Option1);
        RadioButton q1Option2 = findViewById(R.id.q1Option2);
        RadioButton q1Option3 = findViewById(R.id.q1Option3);
        RadioButton q1Option4 = findViewById(R.id.q1Option4);

        RadioButton q2Option1 = findViewById(R.id.q2Option1);
        RadioButton q2Option2 = findViewById(R.id.q2Option2);
        RadioButton q2Option3 = findViewById(R.id.q2Option3);
        RadioButton q2Option4 = findViewById(R.id.q2Option4);

        q1Option1.setText("London");
        q1Option2.setText("Paris");
        q1Option3.setText("Rome");
        q1Option4.setText("Berlin");

        q2Option1.setText("Leonardo da Vinci");
        q2Option2.setText("Pablo Picasso");
        q2Option3.setText("Vincent van Gogh");
        q2Option4.setText("Michelangelo");

        // Set a listener for the next button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswersAndNavigate();
            }
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setTitle("Simple Quiz");
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
        RadioButton selectedOption1 = findViewById(radioGroup1.getCheckedRadioButtonId());
        RadioButton selectedOption2 = findViewById(radioGroup2.getCheckedRadioButtonId());

        if (selectedOption1 != null && selectedOption2 != null) {
            if (selectedOption1.getId() == R.id.q1Option2) {
                score += 5;
            }
            if (selectedOption2.getId() == R.id.q2Option1) {
                score += 5;
            }
        }

        // Navigate to QuizActivity2
        Intent intent = new Intent(this, QuizActivity2.class);
        intent.putExtra("score", score); // Pass the score to the next activity
        startActivity(intent);
    }
}