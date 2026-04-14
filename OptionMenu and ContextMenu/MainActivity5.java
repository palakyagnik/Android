package com.marwadi.myapplayouts;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {

    RelativeLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        mainLayout = findViewById(R.id.mainLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.red:
                mainLayout.setBackgroundColor(Color.RED);
                return true;

            case R.id.green:
                mainLayout.setBackgroundColor(Color.GREEN);
                return true;

            case R.id.blue:
                mainLayout.setBackgroundColor(Color.BLUE);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}