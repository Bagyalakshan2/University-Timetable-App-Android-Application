package com.example.loginapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;



public class NetOrSoft extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set your full timetable layout
        setContentView(R.layout.net_or_soft);

        Button network = findViewById(R.id.network);
        Button software = findViewById(R.id.software);


        network.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the Fulltimetable activity
                Intent intent = new Intent(NetOrSoft.this, Network.class);
                startActivity(intent);
            }
        });

        software.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the Fulltimetable activity
                Intent intent = new Intent(NetOrSoft.this, Software.class);
                startActivity(intent);
            }
        });



    }
}
