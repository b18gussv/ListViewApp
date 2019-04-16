package org.brohede.marcus.listviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] mountainNames = {"Matterhorn","Mont Blanc","Denali", "Kebnekaise","K2","Mount Everest","Kangchenjunga"};
    private String[] mountainLocations = {"Alps","Alps","Alaska"};
    private int[] mountainHeights ={4478,4808,6190,};
    // Create ArrayLists from the raw data above and use these lists when populating your ListView.
    private ArrayList<String> listData=new ArrayList<>(Arrays.asList(mountainNames));
    private ArrayList<Mountain> mountainArrayList=new ArrayList<>();


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        mountainArrayList.add(new Mountain("Matterhorn","Alperna",4478));
        mountainArrayList.add(new Mountain("Mont Blanc","Alperna",4808));
        mountainArrayList.add(new Mountain("Denali","Alaska",6190));
        mountainArrayList.add(new Mountain("Kebnekaise","Skanderna",2106));
        mountainArrayList.add(new Mountain("K2","Himalaya",8611));
        mountainArrayList.add(new Mountain("Mount Everest","Himalaya",8848));
        mountainArrayList.add(new Mountain("Kangchenjunga","Himalaya",8586));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.list_item_textview,R.id.list_item_textview,listData);
        final ListView my_listview=(ListView) findViewById(R.id.list_item_textview);
        my_listview.setAdapter(adapter);

        my_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), mountainArrayList.get(position).info(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
