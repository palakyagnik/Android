package com.example.myappsimplelogin;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {
    EditText etNumber1, etNumber2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnMod, btnClear;
    TextView tvResult;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);
        tvResult = findViewById(R.id.tvResult);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnMod = findViewById(R.id.btnMod);
        btnClear = findViewById(R.id.btnClear);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etNumber1.getText().toString().isEmpty() || etNumber2.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity3.this, "Enter both numbers", Toast.LENGTH_SHORT).show();
                    return;
                }
                double num1 = Double.parseDouble(etNumber1.getText().toString());
                double num2 = Double.parseDouble(etNumber2.getText().toString());
                double result = 0;
                if(v.getId() == R.id.btnAdd)
                    result = num1 + num2;
                else if(v.getId() == R.id.btnSub)
                    result = num1 - num2;
                else if(v.getId() == R.id.btnMul)
                    result = num1 * num2;
                else if(v.getId() == R.id.btnDiv) {
                    if(num2 == 0) {
                        Toast.makeText(MainActivity3.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = num1 / num2;
                }
                else if(v.getId() == R.id.btnMod)
                    result = num1 % num2;
                tvResult.setText("Result: " + result);
            }
        };
        btnAdd.setOnClickListener(listener);
        btnSub.setOnClickListener(listener);
        btnMul.setOnClickListener(listener);
        btnDiv.setOnClickListener(listener);
        btnMod.setOnClickListener(listener);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNumber1.setText("");
                etNumber2.setText("");
                tvResult.setText("Result: ");
            }
        });
    }
}