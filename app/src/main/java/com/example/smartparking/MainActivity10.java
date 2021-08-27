package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity10 extends AppCompatActivity {

    private static List<ParkingStation> parkingStations = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        for (int index = 0; index < 100; index++) {
            ParkingStation parkingStation = new ParkingStation("name" + index,index+35,index+90);
            parkingStations.add(parkingStation);
        }
        RecyclerView recyclerView = findViewById(R.id.recycleView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CustomAdapter1 customAdapter = new CustomAdapter1(MainActivity10.this, parkingStations);
        System.out.println(parkingStations);
        recyclerView.setAdapter(customAdapter);
    }
}