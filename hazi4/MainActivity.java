package com.example.hazi4;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String[] names = {"EUR","USD","GBP","AUD","CAD","CHF","DKK","HUF"};
    double[] buy = {4.4100, 3.9750, 6.1250, 2.9600, 3.0950, 4.2300, 0.5850, 0.0136};
    double[] sell = {4.5500, 4.1450, 6.3550, 3.0600, 3.2650, 4.3300, 0.6150, 0.0146};
    Integer[] images = {
            R.drawable.eur,
            R.drawable.usd,
            R.drawable.gbp,
            R.drawable.aud,
            R.drawable.cad,
            R.drawable.chf,
            R.drawable.dkk,
            R.drawable.huf,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = findViewById(R.id.mylist);

        com.example.hazi4.CurrencyAdapter adapter = new com.example.hazi4.CurrencyAdapter(this, names, buy, sell, images);
        list.setAdapter(adapter);

        list.setOnItemClickListener((parent, view, position, id) -> {
            String msg = names[position] + " - Cumpără: " + buy[position] + ", Vinde: " + sell[position];
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        });
    }
}
