package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPatientActivity extends AppCompatActivity {

    private DataSource dataSource;
    private EditText nameEditText, surnameEditText, idNoEditText, ageEditText,
            chronicEditText, historyEditText, treatmentEditText, noteEditText;

    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);

        dataSource = new DataSource(this);
        dataSource.open();

        // Initialize EditTexts
        nameEditText = findViewById(R.id.nameEditText);
        surnameEditText = findViewById(R.id.surnameEditText);
        idNoEditText = findViewById(R.id.idNoEditText);
        ageEditText = findViewById(R.id.ageEditText);
        chronicEditText = findViewById(R.id.chronicEditText);
        historyEditText = findViewById(R.id.historyEditText);
        treatmentEditText = findViewById(R.id.treatmentEditText);
        noteEditText = findViewById(R.id.noteEditText);

        // Initialize Button
        addButton = findViewById(R.id.addButton);

        // Set click listener for the "Ekle" (Add) button
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve data from EditTexts
                if(dataSource != null){
                    Patient newPatient = new Patient();


                    String name = nameEditText.getText().toString();
                    String surname = surnameEditText.getText().toString();
                    String idNo = idNoEditText.getText().toString();

                    String chronicDiseases = chronicEditText.getText().toString();



                    // Create a new Patient object and populate its fields


                    newPatient.setName(name);
                    newPatient.setSurname(surname);
                    newPatient.setIdNo(idNo);

                    newPatient.setChronicDiseases(chronicDiseases);




                    Log.d("MyApp", "Before insertPatient"); // Add this line
                    long insertedId = dataSource.insertPatient(newPatient);
                    Log.d("MyApp", "After insertPatient"); // Add this line
                    //dataSource.insertPatient(newPatient);
                }



                // Display a success message or handle any other actions
            }
        });
    }
}