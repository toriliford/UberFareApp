package com.example.uberfareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calcButton = (Button) findViewById(R.id.button);
        EditText editText = (EditText) findViewById(R.id.ETMiles);
        Spinner carSpinner = (Spinner) findViewById(R.id.carSpinner);

        double initialFee = 3.0;
        double smartCarFee = 2.0;
        double minivanFee = 5.0;
        double mileageRate = 3.25;

        CarType.popCarArray();
        ArrayAdapter<CarType> adapter = new ArrayAdapter<CarType>(this,
                android.R.layout.simple_spinner_item, CarType.carTypeArrayList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        carSpinner.setAdapter(adapter);
        carSpinner.setOnItemSelectedListener(this);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();

                CarType carType = (CarType) carSpinner.getSelectedItem();
                double totalCost = 0;
                String totalMilesStr = editText.getText().toString();
                String carName = carType.carName;

                switch(carName){
                    case "Smart Car":
                        totalCost = Double.parseDouble(totalMilesStr) * mileageRate + smartCarFee + initialFee;
                    case "Sedan":
                        totalCost = Double.parseDouble(totalMilesStr) * mileageRate + initialFee;
                    case "Minivan":
                        totalCost = Double.parseDouble(totalMilesStr) * mileageRate + minivanFee + initialFee;
                }

                editor.putString("Car Name", carName);
                editor.putInt("Miles", Integer.parseInt(totalMilesStr));
                editor.putFloat("Total Cost", (float) totalCost);
                editor.apply();

                Intent intent = new Intent(MainActivity.this, PriceScreen.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}