package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find buttons by their IDs
        Button buttonVisit = findViewById(R.id.buttonVisit);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonUpdate = findViewById(R.id.buttonUpdate);
        Button buttonDeleted = findViewById(R.id.buttonDeleted);

        // Set click listeners for the buttons
        buttonVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to another activity when "Visite Yap" button is clicked
                Intent intent = new Intent(MainActivity.this, VisitActivity.class);
                startActivity(intent);
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to another activity when "Visite Yap" button is clicked
                Intent intent = new Intent(MainActivity.this, AddPatientActivity.class);
                startActivity(intent);
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to another activity when "Visite Yap" button is clicked
                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                startActivity(intent);
            }
        });

        buttonDeleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DeletedPatientActivity.class);
                startActivity(intent);
            }
        });
    }
}