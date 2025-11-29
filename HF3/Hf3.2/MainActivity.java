package com.example.hazi32;

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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText edtCode, edtName, edtPrice;
    private Button btnAdd, btnCancel, btnShow;
    private TextView tvProducts;
    private ArrayList<Product> productList = new ArrayList<>();

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

       edtCode =  findViewById(R.id.edtCode);
       edtName = findViewById(R.id.edtName);
       edtPrice = findViewById(R.id.edtPrice);

       btnAdd = findViewById(R.id.btnAdd);
       btnCancel = findViewById(R.id.btnCancel);
       btnShow = findViewById(R.id.btnShow);

       tvProducts = findViewById(R.id.tvProducts);

       btnAdd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String code = edtCode.getText().toString();
               String name = edtName.getText().toString();
               String priceStr = edtPrice.getText().toString();

               if(!code.isEmpty() && !name.isEmpty() && !priceStr.isEmpty()) {
                   Double price = Double.parseDouble(priceStr);
                   Product p = new Product(code,name,price);
                   productList.add(p);
               }
           }


       });
       btnCancel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               edtCode.setText("");
               edtName.setText("");
               edtPrice.setText("");
           }
       });
       btnShow.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               StringBuilder sb = new StringBuilder();

               for (Product p:productList){
                   sb.append(p.toString()).append("\n");
               }
               tvProducts.setText(sb.toString());
           }
       });

        }
    private class Product {
        private String code;
        private String name;
        private double price;

        public Product(String code,String name, double price){
            this.code = code;
            this.name = name;
            this.price = price;
        }
        @Override
        public String toString() {
            return code + " - " + name + " - $" + price;
        }
    }
}
