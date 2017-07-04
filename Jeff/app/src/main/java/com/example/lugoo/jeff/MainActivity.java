package com.example.lugoo.jeff;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] data = {"Apple","Banana","Orange"};
    private List<Fruit> list = new ArrayList<>();
    private void initFruit()
    {
        Fruit apple = new Fruit("Apple",R.drawable.apple);
        list.add(apple);
        Fruit jeff = new Fruit("Apple",R.drawable.jeff);
        list.add(apple);
        Fruit jeff_a = new Fruit("Apple",R.drawable.jeff_a);
        list.add(apple);
        Fruit jeff_b = new Fruit("Apple",R.drawable.jeff_b);
        list.add(apple);
        Fruit jeff_c = new Fruit("Apple",R.drawable.jeff_c);
        list.add(apple);
        Fruit apple1 = new Fruit("Apple",R.drawable.apple);
        list.add(apple1);
        Fruit jeff1 = new Fruit("Apple",R.drawable.jeff);
        list.add(jeff1);
        Fruit jeff_a1 = new Fruit("Apple",R.drawable.jeff_a);
        list.add(jeff_a1);
        Fruit jeff_b1 = new Fruit("Apple",R.drawable.jeff_b);
        list.add(jeff_b1);
        Fruit jeff_c1 = new Fruit("Apple",R.drawable.jeff_c);
        list.add(jeff_c1);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruit();
        FruitAdapter arrayAdapter = new FruitAdapter(MainActivity.this,R.layout.layout,list);

         ListView listView = (ListView) findViewById(R.id.list_view);
         listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = list.get(position);
                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_LONG).show();
            }
        });

    }
}
