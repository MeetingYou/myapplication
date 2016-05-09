package com.example.listviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFruits();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruits() {
        Fruit Apple = new Fruit("Apple", R.mipmap.apple);
        fruitList.add(Apple);
        Fruit Pear = new Fruit("Pear", R.mipmap.apple);
        fruitList.add(Pear);
        Fruit Banana = new Fruit("Banana", R.mipmap.apple);
        fruitList.add(Banana);
        Fruit Orange = new Fruit("Orange", R.mipmap.apple);
        fruitList.add(Orange);
        Fruit Grape = new Fruit("Grape", R.mipmap.apple);
        fruitList.add(Grape);
        Fruit Cherry = new Fruit("Cherry", R.mipmap.apple);
        fruitList.add(Cherry);
        Fruit Mango = new Fruit("Mango", R.mipmap.apple);
        fruitList.add(Mango);
        Fruit Watermelon = new Fruit("Watermelon", R.mipmap.apple);
        fruitList.add(Watermelon);
        Fruit Strawberry = new Fruit("Strawberry", R.mipmap.apple);
        fruitList.add(Strawberry);
        for (int i=0; i<10000; i++) {
            fruitList.add(new Fruit("Apple" + i, R.mipmap.apple));
        }
    }
}
