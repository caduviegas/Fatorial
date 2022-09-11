package com.innaval.fatorial;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;
import java.util.Locale;

public class MainActivity extends Activity {

    EditText editText;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.et_calculofatorial);
        textView = findViewById(R.id.tv_resposta);
        button = findViewById(R.id.btn_calcular);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(editText.getText().toString());
                textView.setText("" + String.format(Locale.getDefault(), "%.2f", factorial(num)));
            }
        });
    }

    private double factorial(double num) {
        if (num < 2) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }
}

