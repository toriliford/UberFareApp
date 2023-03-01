package com.example.uberfareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        EditText editText = (EditText) findViewById(R.id.ETMiles);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PriceScreen.class));
            }
        });

        double initialFee = 3.0;
        double mileageRate = 3.25;
        double smartCarFee = 2.0;
        double minivanFee = 5.0;

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putFloat();
        editor.apply();
    }


}