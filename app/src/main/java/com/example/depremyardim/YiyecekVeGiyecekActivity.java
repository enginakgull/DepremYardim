package com.example.depremyardim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class YiyecekVeGiyecekActivity extends AppCompatActivity {

    private Spinner citySpinner;
    private ArrayAdapter<CharSequence> cityAdapter;
    private TextView campLocationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yiyecek_ve_giyecek);

        citySpinner = findViewById(R.id.citySpinner);
        campLocationTextView = findViewById(R.id.campLocationTextView);


        cityAdapter= ArrayAdapter.createFromResource(this,R.array.city_array, android.R.layout.simple_spinner_item);
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(cityAdapter);

        showCampLocation(citySpinner);


    }

    public void showCampLocation(View v){
        citySpinner = findViewById(R.id.citySpinner);
        campLocationTextView = findViewById(R.id.campLocationTextView);

        String selectedValue = citySpinner.getSelectedItem().toString();
        campLocationTextView.setText(selectedValue+"");
    }
}