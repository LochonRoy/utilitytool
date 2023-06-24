package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Activity2 extends AppCompatActivity {

    private EditText editTextWeight;
    private EditText editTextHeight;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        textViewResult = findViewById(R.id.textViewResult);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setTitle("BMI Calculator");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Navigate back to the previous activity (MainActivity)
        return true;
    }

    public void calculateBMI(View view) {
        String weightString = editTextWeight.getText().toString();
        String heightString = editTextHeight.getText().toString();

        if (weightString.isEmpty() || heightString.isEmpty()) {
            Toast.makeText(this, "Please enter weight and height.", Toast.LENGTH_SHORT).show();
            return;
        }

        double weight = Double.parseDouble(weightString);
        double height = Double.parseDouble(heightString) / 100.0; // convert cm to m

        double bmi = weight / (height * height);

        String result;
        if (bmi < 18.5) {
            result = "Underweight";
        } else if (bmi >= 18.5 && bmi < 25) {
            result = "Normal weight";
        } else if (bmi >= 25 && bmi < 30) {
            result = "Overweight";
        } else {
            result = "Obese";
        }

        textViewResult.setText(String.format("%.1f", bmi));
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }
}

