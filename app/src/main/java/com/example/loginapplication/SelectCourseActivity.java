package com.example.loginapplication;
import android.view.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class SelectCourseActivity extends AppCompatActivity {

    private Object View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Force light mode so colors stay consistent
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_course);

        Button btnFull = findViewById(R.id.btnfull);

        btnFull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the Fulltimetable activity
                Intent intent = new Intent(SelectCourseActivity.this, NetOrSoft.class);
                startActivity(intent);
            }
        });


        PrefManager pref = new PrefManager(this);

        Button btnICT = findViewById(R.id.btnICT);
        Button btnSE = findViewById(R.id.btnSE);




        btnICT.setOnClickListener(v -> {
            pref.saveCourse("ICT");
            startMainAndFinish();
        });

        btnSE.setOnClickListener(v -> {
            pref.saveCourse("SE");
            startMainAndFinish();
        });




    }

    private void startMainAndFinish(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
