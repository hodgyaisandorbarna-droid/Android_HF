package com.example.hazi1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText num1 = findViewById(R.id.numb1);
        EditText num2 = findViewById(R.id.numb2);

        Button btn1 = findViewById(R.id.plus);
        Button btn2 = findViewById(R.id.minus);
        Button btn3 = findViewById(R.id.multiply);
        Button btn4 = findViewById(R.id.division);

        TextView result = findViewById(R.id.result);

        btn1.setOnClickListener(v -> {
            double a = Double.parseDouble(num1.getText().toString());
            double b = Double.parseDouble(num2.getText().toString());
            result.setText("Eredmény: " + (a + b));
        });
        btn2.setOnClickListener(v -> {
            double a = Double.parseDouble(num1.getText().toString());
            double b = Double.parseDouble(num2.getText().toString());
            result.setText("Eredmény: " + (a - b));
        });

        btn3.setOnClickListener(v -> {
            double a = Double.parseDouble(num1.getText().toString());
            double b = Double.parseDouble(num2.getText().toString());
            result.setText("Eredmény: " + (a * b));
        });

        btn4.setOnClickListener(v -> {
            double a = Double.parseDouble(num1.getText().toString());
            double b = Double.parseDouble(num2.getText().toString());
            if (b == 0)
                result.setText("Nullával nem lehet osztani!");
            else
                result.setText("Eredmény: " + (a / b));
        });
    }
}