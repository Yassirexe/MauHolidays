package com.example.mauholidays;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class currency extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        Spinner spinner = (Spinner) findViewById(R.id.currencyChoices);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        TextView currencyRateForeign = (TextView) findViewById(R.id.currencyRate);
        TextView muRates = (TextView) findViewById(R.id.muRates);
        EditText unchanged = (EditText) findViewById(R.id.currencyInput);
        TextView answer = (TextView) findViewById(R.id.currencyAnswer);
        TextView sercetRate = (TextView) findViewById(R.id.secretRate);

        unchanged.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                answer.setText("0.00");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String txtvalue;
                txtvalue = unchanged.getText().toString();
                if(txtvalue.equals("")) {
                    answer.setText("0.00");
                    return;
                }
                try {
                    float value;
                    value = Float.parseFloat(txtvalue);
                    float rate = Float.parseFloat(sercetRate.getText().toString());
                    float bans = rate * value;
                    String cans = String.valueOf(bans);
                    answer.setText(cans);
                } catch (Exception e) {
                    Log.i(TAG, "onTextChanged: Error");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String txtvalue, cans; float value, bans, rate;

                switch (position) {
                    case 0 : {
                        currencyRateForeign.setText("1 USD = 45.516463 MUR Rupees");
                        muRates.setText("1 MUR = 0.0219980 USD");
                        sercetRate.setText("45.516463");
                        txtvalue =  unchanged.getText().toString();
                        if(txtvalue.equals("")) {
                            answer.setText("0.00");
                            break;
                        }
                        value = Float.parseFloat(txtvalue);
                        rate = 45.516463f;
                        bans = rate * value;
                        cans = String.valueOf(bans);
                        answer.setText(cans);
                        break;
                    }
                    case 1: {
                        currencyRateForeign.setText("1 EUR = 48.725838 MUR Rupees");
                        muRates.setText("1 MUR = 0.0205230 EUR");
                        sercetRate.setText("48.725838");
                        txtvalue =  unchanged.getText().toString();
                        if(txtvalue.equals("")) {
                            answer.setText("0.00");
                            break;
                        }
                        value = Float.parseFloat(txtvalue);
                        rate = 48.725838f;
                        bans = rate * value;
                        cans = String.valueOf(bans);
                        answer.setText(cans);
                        break;
                    }
                    case 2: {
                            currencyRateForeign.setText("1 GBP = 56.5637 MUR Rupees");
                        muRates.setText("1 MUR = 0.0176792 GBP");
                        sercetRate.setText("56.5637");
                        txtvalue =  unchanged.getText().toString();
                        if(txtvalue.equals("")) {
                            answer.setText("0.00");
                            break;
                        }
                        value = Float.parseFloat(txtvalue);
                        rate = 56.5637f;
                        bans = rate * value;
                        cans = String.valueOf(bans);
                        answer.setText(cans);

                        break;
                    }
                    case 3: {
                        currencyRateForeign.setText("1 CAD = 33.827199 MUR Rupees");
                        muRates.setText("1 MUR = 0.0295620 CAD" );
                        sercetRate.setText("33.827199");
                        txtvalue =  unchanged.getText().toString();
                        if(txtvalue.equals("")) {
                            answer.setText("0.00");
                            break;
                        }
                        value = Float.parseFloat(txtvalue);
                        rate = 33.827199f;
                        bans = rate * value;
                        cans = String.valueOf(bans);
                        answer.setText(cans);
                        break;
                    }
                    case 4: {
                        currencyRateForeign.setText("1 INR = 0.55103793 MUR Rupees");
                        muRates.setText("1 MUR = 1.81442 INR" );
                        sercetRate.setText("0.55103793");
                        txtvalue =  unchanged.getText().toString();
                        if(txtvalue.equals("")) {
                            answer.setText("0.00");
                            break;
                        }
                        value = Float.parseFloat(txtvalue);
                        rate = 0.55103793f;
                        bans = rate * value;
                        cans = String.valueOf(bans);
                        answer.setText(cans);
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                currencyRateForeign.setText("1 USD = 45.516463 MUR Rupees");
                muRates.setText("1 MUR = 0.0219980 USD");
                sercetRate.setText("45.516463");
            }
        });

    }
}