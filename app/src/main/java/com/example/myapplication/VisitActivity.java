package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class VisitActivity extends AppCompatActivity {


    private ListView listView;
    private PatientListAdapter patientListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit);
        DataSource dataSource = new DataSource(this);
        dataSource.open();


        listView = findViewById(R.id.listView);

        // Assume patientsList is a list of Patient objects
        List<Patient> patientsList = dataSource.getAllPatients();

        patientListAdapter = new PatientListAdapter(this, patientsList);
        listView.setAdapter(patientListAdapter);
    }
}