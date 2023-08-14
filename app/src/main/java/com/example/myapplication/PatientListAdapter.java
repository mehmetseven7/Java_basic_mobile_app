package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class PatientListAdapter extends ArrayAdapter<Patient> {

    public PatientListAdapter(Context context, List<Patient> patients) {
        super(context, 0, patients);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_patient, parent, false);
        }

        Patient patient = getItem(position);

        TextView nameTextView = convertView.findViewById(R.id.nameTextView);
        TextView surnameTextView = convertView.findViewById(R.id.surnameTextView);

        nameTextView.setText("Name: " + patient.getName());
        surnameTextView.setText("Surname: " + patient.getSurname());

        // Set other patient information fields in a similar manner


        return convertView;
    }
}
