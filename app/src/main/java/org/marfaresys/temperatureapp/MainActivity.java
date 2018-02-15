package org.marfaresys.temperatureapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText_celsius;
    private EditText editText_fahrenheit;
    private TextView textView_warn;
    private Button button_celsiusToFahrenheit;
    private Button button_fahrenheitToCelsius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_celsius = findViewById(R.id.editText_celsius);
        editText_fahrenheit = findViewById(R.id.editText_fahrenheit);
        textView_warn = findViewById(R.id.textView_warn);
        button_celsiusToFahrenheit = findViewById(R.id.button_celsiusToFahrenheit);
        button_fahrenheitToCelsius = findViewById(R.id.button_fahrenheitToCelsius);

        button_celsiusToFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(TextUtils.isEmpty(editText_celsius.getText()))) {
                    textView_warn.setText("");
                    double celsius = Double.parseDouble(editText_celsius.getText().toString());
                    double fahrenheit = ((celsius * 9.0) / 5.0) + 32.0;
                    editText_fahrenheit.setText(String.format("%.2f", fahrenheit));
                }
                else {
                    textView_warn.setText("Celsius input is empty");
                }
            }
        });

        button_fahrenheitToCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(TextUtils.isEmpty(editText_fahrenheit.getText()))) {
                    textView_warn.setText("");
                    double fahrenheit = Double.parseDouble(editText_fahrenheit.getText().toString());
                    double celsius = (fahrenheit - 32.0) * (5.0 / 9.0);
                    editText_celsius.setText(String.format("%.2f", celsius));
                }
                else {
                    textView_warn.setText("Fahrenheit input is empty");
                }
            }
        });
    }
}
