package com.example.capp012f2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    float num99;
    String str00 = "";
    char lastact = ' ';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText In1 = findViewById(R.id.in1);
        In1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ReadData();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void ReadData() {

        String str1, str2, str3;
        float num1, num2, num3;
        char action, c0;
        action = ' ';
        TextView Op1 = findViewById(R.id.op1);
        TextView Op2 = findViewById(R.id.op2);
        TextView Op3 = findViewById(R.id.op3);
        EditText In1 = findViewById(R.id.in1);
        str1 = In1.getText().toString();
        if (str1.length() > 0) {
            str2 = Op1.getText().toString();

            str3 = str1;

            c0 = str1.charAt(0);
            if (((c0 >= '0' && c0 <= '9') || c0 == '.')) {
                for (int i = 0; i < str1.length(); i++) {
                    str2 = str2 + str1.charAt(i);
                    str00 = str00 + str1.charAt(i);
                }

            } else {
                if (str1.equals("plus") || c0 == '+') action = '+';
                else if (str1.equals("minus") || c0 == '-') action = '-';
                else if (str1.equals("equals") || c0 == '=') action = '=';
                str2 = str2 + action;
                if (action != ' ') {
                    num1 = Float.parseFloat(str00);
                    str00 = "";
                    if (lastact == '+') num99 = num99 + num1;
                    if (lastact == '-') num99 = num99 - num1;
                    if (lastact == ' ') num99 = num1;
                    lastact = action;
                }
            }

            Op1.setText(str2);
            In1.setText("");
            Op2.setText(str3);
            Op3.setText(String.format(Locale.getDefault(), "%.2f", num99));

        }
    }
}