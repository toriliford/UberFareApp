package com.example.uberfareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class PriceScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_screen);

        TextView t1, t2;
        t1 = findViewById(R.id.textViewOne);
        t2 = findViewById(R.id.textViewTwo);

        final DecimalFormat df = new DecimalFormat("0.00");

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        String carName = sharedPreferences.getString("Car Name", "");
        int miles = sharedPreferences.getInt("Miles", 0);
        double totalCost = sharedPreferences.getFloat("Total Cost", 0);

        String t1String = "Your trip will be " + miles + " miles in a " + carName + ".";
        String t2String = "$" + df.format(totalCost);

        t1.setText(t1String);
        t2.setText(t2String);

        Button btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent2 = new Intent(PriceScreen.this, MainActivity.class);
                startActivity(intent2);
            }
        });
    }
}