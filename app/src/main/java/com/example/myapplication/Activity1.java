package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Activity1 extends AppCompatActivity {

    private TextView display;
    private TextView resultDisplay;

    private StringBuilder numberBuilder;
    private String operator;
    private double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        display = findViewById(R.id.display);
        resultDisplay = findViewById(R.id.resultDisplay);

        numberBuilder = new StringBuilder();
        operator = "";
        result = 0.0;
        Toolbar toolbar = findViewById(R.id.toolbar);
        setTitle("Calculator");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Navigate back to the previous activity (MainActivity)
        return true;
    }

    public void onClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        switch (buttonText) {
            case "C":
                clearDisplay();
                break;
            case "DEL":
                deleteLastCharacter();
                break;
            case "=":
                calculateResult();
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                setOperator(buttonText);
                break;
            default:
                appendNumber(buttonText);
                break;
        }
    }

    private void appendNumber(String number) {
        numberBuilder.append(number);
        display.setText(numberBuilder.toString());
    }

    private void setOperator(String operator) {
        this.operator = operator;
        result = Double.parseDouble(numberBuilder.toString());
        resultDisplay.setText(numberBuilder.toString() + " " + operator);
        numberBuilder.setLength(0);
        display.setText("");
    }

    private void calculateResult() {
        double operand = Double.parseDouble(numberBuilder.toString());

        switch (operator) {
            case "+":
                result += operand;
                break;
            case "-":
                result -= operand;
                break;
            case "*":
                result *= operand;
                break;
            case "/":
                if (operand != 0) {
                    result /= operand;
                } else {
                    display.setText("Error");
                    return;
                }
                break;
        }

        display.setText(String.valueOf(result));
        resultDisplay.setText("");
        numberBuilder.setLength(0);
    }

    private void clearDisplay() {
        numberBuilder.setLength(0);
        operator = "";
        result = 0.0;
        display.setText("");
        resultDisplay.setText("");
    }

    private void deleteLastCharacter() {
        if (numberBuilder.length() > 0) {
            numberBuilder.deleteCharAt(numberBuilder.length() - 1);
            display.setText(numberBuilder.toString());
        }
    }
}



