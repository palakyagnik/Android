package com.example.myapplicationmca;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity5 extends AppCompatActivity {
    Button btnPickTime;
    TextView txtTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        btnPickTime = findViewById(R.id.btnPickTime);
        txtTime = findViewById(R.id.txtTime);
        btnPickTime.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, (view, selectedHour, selectedMinute) -> {
                String time = selectedHour + ":" + selectedMinute;
                txtTime.setText("Selected Time: " + time);
                }, hour, minute, true); // true = 24-hour format
            timePickerDialog.show();
        });
    }
}