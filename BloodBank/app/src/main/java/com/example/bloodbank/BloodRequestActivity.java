package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class BloodRequestActivity extends AppCompatActivity {

    ArrayAdapter<CharSequence> Blood_List;
    ArrayAdapter<CharSequence> City_List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_request);

        Spinner bloodgrp = (Spinner) findViewById(R.id.spinner_bloodgrp);
        Spinner city = (Spinner) findViewById(R.id.spinner_city);

        Blood_List = ArrayAdapter.createFromResource(this, R.array.bg_arrays, android.R.layout.select_dialog_item);
        City_List = ArrayAdapter.createFromResource(this,R.array.city_arrays, android.R.layout.select_dialog_item);

        bloodgrp.setAdapter(Blood_List);
        city.setAdapter(City_List);
    }

    public void submit(View view)
    {
        Spinner bloodgrp = (Spinner) findViewById(R.id.spinner_bloodgrp);
        Spinner city = (Spinner) findViewById(R.id.spinner_city);

        Intent i = new Intent(this,BloodDonerListActivity.class);
        i.putExtra("bloodgrp", bloodgrp.getSelectedItem().toString());
        i.putExtra("city", city.getSelectedItem().toString());

        startActivity(i);
    }

}