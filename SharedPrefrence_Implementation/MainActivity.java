package com.example.myappsharedpref;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText;
    Button saveBtn, showBtn;
    TextView savedNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        saveBtn = findViewById(R.id.saveBtn);
        showBtn = findViewById(R.id.showBtn);
        savedNames = findViewById(R.id.savedName);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", name);
                editor.apply();
                Toast.makeText(getApplicationContext(), "Name saved!", Toast.LENGTH_SHORT).show();
                savedNames.setText(name);
            }
        });
        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                String savedName = sharedPreferences.getString("username", "No name saved");
                Toast.makeText(getApplicationContext(), "Saved Name: " + savedName, Toast.LENGTH_SHORT).show();
                savedNames.setText(savedName);
            }
        });
    }
}