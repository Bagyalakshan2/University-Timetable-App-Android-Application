package com.example.loginapplication;
import android.graphics.Color;
import android.widget.TextView;
import java.util.Calendar;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class Network extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set your full timetable layout
        setContentView(R.layout.network);

        TextView monday = findViewById(R.id.dayMonday);
        TextView tuesday = findViewById(R.id.dayTuesday);
        TextView wednesday = findViewById(R.id.dayWednesday);
        TextView thursday = findViewById(R.id.dayThursday);
        TextView friday = findViewById(R.id.dayFriday);

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        switch(day) {
            case Calendar.MONDAY: monday.setBackgroundColor(Color.YELLOW); break;
            case Calendar.TUESDAY: tuesday.setBackgroundColor(Color.YELLOW); break;
            case Calendar.WEDNESDAY: wednesday.setBackgroundColor(Color.YELLOW); break;
            case Calendar.THURSDAY: thursday.setBackgroundColor(Color.YELLOW); break;
            case Calendar.FRIDAY: friday.setBackgroundColor(Color.YELLOW); break;
        }


    }
}
