package com.example.hazi4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hazi4.R;

public class CurrencyAdapter extends ArrayAdapter<String> {

    private Context context;
    private String[] names;
    private double[] buy;
    private double[] sell;
    private Integer[] images;

    public CurrencyAdapter(Context context, String[] names, double[] buy, double[] sell, Integer[] images) {
        super(context, 0, names);
        this.context = context;
        this.names = names;
        this.buy = buy;
        this.sell = sell;
        this.images = images;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_row, parent, false);
        }

        ImageView img = convertView.findViewById(R.id.imgFlag);
        TextView txtCurrency = convertView.findViewById(R.id.txtCurrency);
        TextView txtBuy = convertView.findViewById(R.id.txtBuy);
        TextView txtSell = convertView.findViewById(R.id.txtSell);

        img.setImageResource(images[position]);
        txtCurrency.setText(names[position]);
        txtBuy.setText("Cumpără " + String.format("%.4f RON", buy[position]));
        txtSell.setText("Vinde " + String.format("%.4f RON", sell[position]));

        return convertView;
    }
}
