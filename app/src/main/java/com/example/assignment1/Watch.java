package com.example.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Watch extends AppCompatActivity {
    private int seconds = 0;
    private boolean running = false;
    Button startButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);

        startButton = (Button) findViewById(R.id.startTimer);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                running = true;
            }
        });

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setSelectedItemId(R.id.home);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.watch:

                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.notes:
                        startActivity(new Intent(getApplicationContext(),Notes.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });


        checkInstance(savedInstanceState);

        startWatch();
    }



    private void checkInstance(Bundle savedInstanceState) {
        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("SECONDS");
            running = savedInstanceState.getBoolean("RUNNING");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("SECONDS", seconds);
        outState.putBoolean("RUNNING", running);


    }



    private void startWatch(){
        final TextView txtTime = findViewById(R.id.txtTime);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600) / 60;
                int secs = seconds%60;
                String time = hours +" : " + minutes + " : " + secs;
                txtTime.setText(time);
                if(running){
                    seconds++;
                }
                handler.postDelayed(this, 1000);

            }
        });
    }



    public void stopTimer(View view) {
        running = false;
    }

    public void resetTimer(View view) {
        running = false;
        seconds = 0;
    }
}