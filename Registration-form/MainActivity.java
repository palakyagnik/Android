package com.example.regisform;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText etName,etEmail,etPassword;
    RadioGroup radioGroupGender;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                int genderId = radioGroupGender.getCheckedRadioButtonId();
                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || genderId == -1) {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    RadioButton rb = findViewById(genderId);
                    String gender = rb.getText().toString();
                    Toast.makeText(MainActivity.this, "Registered Successfully\n" + "Name: " + name + "\nEmail: " + email + "\nGender: " + gender, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}