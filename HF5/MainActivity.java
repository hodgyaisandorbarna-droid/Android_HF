package com.example.hazi5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    class Elem {
        String nev;
        int szin = Color.BLACK;
        Elem(String n) { nev = n; }
        public String toString() { return nev; }
    }

    ListView listView;
    ArrayAdapter<Elem> adapter;
    List<Elem> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.mylist);

        lista.add(new Elem("EUR"));
        lista.add(new Elem("USD"));
        lista.add(new Elem("HUF"));
        lista.add(new Elem("GBP"));
        lista.add(new Elem("AUD"));

        adapter = new ArrayAdapter<Elem>(this, android.R.layout.simple_list_item_1, lista) {
            @NonNull
            @Override
            public View getView(int position, View convertView, @NonNull ViewGroup parent) {
                TextView view = (TextView) super.getView(position, convertView, parent);
                Elem elem = getItem(position);
                if (elem != null) {
                    view.setText(elem.nev);
                    view.setTextColor(elem.szin);
                }
                return view;
            }
        };
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_sort) {
            Collections.sort(lista, new Comparator<Elem>() {
                @Override
                public int compare(Elem o1, Elem o2) { return o1.nev.compareTo(o2.nev); }
            });
            adapter.notifyDataSetChanged();
        } else if (item.getItemId() == R.id.action_clear) {
            lista.clear();
            adapter.notifyDataSetChanged();
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Válassz színt");
        menu.add(0, 101, 0, "Piros");
        menu.add(0, 102, 0, "Zöld");
        menu.add(0, 103, 0, "Sárga");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();


        if (info == null || info.position >= lista.size()) return false;

        Elem kivalasztott = lista.get(info.position);


        switch (item.getItemId()) {
            case 101: // Piros
                kivalasztott.szin = Color.RED;
                break;
            case 102: // Zöld
                kivalasztott.szin = Color.GREEN;
                break;
            case 103: // Sárga
                kivalasztott.szin = Color.YELLOW;
                break;
            default:
                return super.onContextItemSelected(item);
        }

        adapter.notifyDataSetChanged();
        return true;
    }
}