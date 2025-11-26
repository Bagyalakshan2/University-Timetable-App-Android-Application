package com.example.loginapplication;
import com.example.loginapplication.PrefManager;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import java.text.SimpleDateFormat;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button changeCourseBtn;
    PrefManager pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Force light mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);

        pref = new PrefManager(this);

        // If no course chosen yet, go to selector
        if (pref.getCourse() == null) {
            startActivity(new Intent(this, SelectCourseActivity.class));
            finish();
            return;
        }

        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        changeCourseBtn = findViewById(R.id.btnChangeCourse);

        String selectedCourse = pref.getCourse();

        // Build timetables (replace with your real times)
        Map<String, List<String>> ict = new HashMap<>();
        Map<String, List<String>> se = new HashMap<>();
        Map<String, List<String>> cs = new HashMap<>();



        ict.put("Monday", Arrays.asList("10:30 - 12:30 : Wireless Network (Theory)",
                "10:20 - 12:30 : Wireless Network (Theory)",
                "13:30 - 15:30 : Practical For Mobile Application Development"
                ));



        ict.put("Tuesday", Arrays.asList("09:30 - 10:30 : Literature Survey",
                "13:30 - 14:30 : Embedded System (Theory)",
                "14:30 - 16:30 - Practical For Embedded System "
        ));

        ict.put("Wednesday", Arrays.asList("08:30 - 10:30 : Enterprises Architecture",
                "13:30 - 15:30 : Practical For Mobile Application Development"
        ));
        ict.put("Thursday", Arrays.asList("08:30 - 09:30 : Mobile Application (Theory)",
                "10:30 - 12:30 : Information System Security/Auditing (Theory)",
                "13:30 - 15:30 : Practical For Mobile Application Development"

        ));
        ict.put("Friday", Arrays.asList("08:30 - 10:30 : Practical For Embedded System",

                "13:30 - 16:30 : Practical For Wireless Network"

        ));





        se.put("Monday", Arrays.asList("08:30 - 10:30 : Practical For Embedded System",
                "10:30 - 12:30 : Wireless Network (Theory)",
                "13:30 - 15:30 : Practical For Service Oriented Web Application"
        ));



        se.put("Tuesday", Arrays.asList("09:30 - 10:30 : Literature Survey",
                "10:30 - 12:30 : Practical For Mobile Application Development",
                "14:30 - 14:30 - Embedded System  (Theory)"
        ));

        se.put("Wednesday", Arrays.asList("08:30 - 10:30 : Enterprises Architecture And Leadership",
                "10:30 - 12:30 : Practical For Mobile Application Development"
        ));
        se.put("Thursday", Arrays.asList("08:30 - 09:30 : Mobile Application (Theory)",
                "10:30 - 12:30 : Information System Security/Auditing (Theory)",
                "13:30 - 15:30 : Service Oriented Web Application"

        ));
        se.put("Friday", Arrays.asList("10:30 - 12:30 : Practical For Embedded System",

                "13:30 - 16:30 : Practical For Wireless Network"

        ));




        // Determine today's day name
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        String today = sdf.format(calendar.getTime()); // e.g., "Monday"

        List<String> lectures;
        if ("ICT".equals(selectedCourse)) {
            lectures = ict.getOrDefault(today, Collections.singletonList("No lectures"));
        } else if ("SE".equals(selectedCourse)) {
            lectures = se.getOrDefault(today, Collections.singletonList("No lectures"));
        } else {
            lectures = cs.getOrDefault(today, Collections.singletonList("No lectures"));
        }

        // Build display text
        StringBuilder sb = new StringBuilder();
        sb.append("Course: ").append(selectedCourse).append("\n");
        sb.append("Today (").append(today).append(")\n\n");
        for (String item : lectures) {
            sb.append("• ").append(item).append("\n");
        }

        textView.setText(sb.toString());

        // Change course button - goes back to SelectCourseActivity
        changeCourseBtn.setOnClickListener(v -> {
            // optional: clear stored course so SelectCourseActivity will always show fresh
            pref.clearCourse();
            startActivity(new Intent(this, SelectCourseActivity.class));
            finish();
        });
    }
}
