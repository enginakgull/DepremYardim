package com.example.depremyardim;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class YiyecekVeGiyecekActivity extends AppCompatActivity {

    private Spinner citySpinner, districtSpinner;
    private ArrayAdapter<CharSequence> cityAdapter;
    private Button showButton;
    private TextView resultTxt;

    private String selectedCity, selectedDistrict;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yiyecek_ve_giyecek);

        citySpinner = findViewById(R.id.citySpinner);
        districtSpinner = findViewById(R.id.districtSpinner);
        showButton = findViewById(R.id.showButton);
        resultTxt = findViewById(R.id.campLocationTextView);

        cityAdapter = ArrayAdapter.createFromResource(this,
                R.array.il_liste, android.R.layout.simple_spinner_item);
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(cityAdapter);

        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCity = parent.getItemAtPosition(position).toString();
                updateIlceList(selectedCity);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        districtSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedDistrict = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sonuc = " " + selectedCity + " ilinin, " + selectedDistrict+ " ilçesinde giyecek ve yiyecek yardımı yapılmaktadır.";
                resultTxt.setText(sonuc);
            }
        });
    }

    private void updateIlceList(String selectedIl) {
        ArrayAdapter<CharSequence> ilceAdapter;
        switch (selectedIl) {
            case "Ankara":
                ilceAdapter = ArrayAdapter.createFromResource(this,
                        R.array.ilce_listesi_ankara, android.R.layout.simple_spinner_item);
                break;
            case "İstanbul":
                ilceAdapter = ArrayAdapter.createFromResource(this,
                        R.array.ilce_listesi_istanbul, android.R.layout.simple_spinner_item);
                break;
            case "İzmir":
                ilceAdapter = ArrayAdapter.createFromResource(this,
                        R.array.ilce_listesi_izmir, android.R.layout.simple_spinner_item);
                break;
            // Diğer iller için de case bloklarını buraya ekleyin
            default:
                ilceAdapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_item);
                break;
        }

        ilceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        districtSpinner.setAdapter(ilceAdapter);
    }

}