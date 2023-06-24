package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.text.DecimalFormat;

public class Activity3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerCurrency;
    private EditText editTextAmount;
    private TextView textViewResult;

    private String selectedCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        spinnerCurrency = findViewById(R.id.spinnerCurrency);
        editTextAmount = findViewById(R.id.editTextAmount);
        textViewResult = findViewById(R.id.textViewResult);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.currency_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCurrency.setAdapter(adapter);
        spinnerCurrency.setOnItemSelectedListener(this);
        // Set up the toolbar and enable the Up button
        Toolbar toolbar = findViewById(R.id.toolbar);
        setTitle("Currency Converter");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Navigate back to the previous activity (MainActivity)
        return true;
    }

    public void convertCurrency(View view) {
        String amountString = editTextAmount.getText().toString();

        if (amountString.isEmpty()) {
            textViewResult.setText("Please enter an amount.");
            return;
        }

        double amount = Double.parseDouble(amountString);
        double convertedAmount = 0.0;

        switch (selectedCurrency) {
            case "USD to BDT":
                convertedAmount = amount * 108.5;
                break;
            case "Yuan to BDT":
                convertedAmount = amount * 16.5;
                break;
            case "Rupee to BDT":
                convertedAmount = amount * 1.2;
                break;
        }

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        String result = decimalFormat.format(convertedAmount) + " BDT";

        textViewResult.setText(result);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedCurrency = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
