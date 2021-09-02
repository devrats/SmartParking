package com.example.smartparking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ParkingRecycleView extends AppCompatActivity {

    private static List<ParkingStation> parkingStations = new ArrayList<>();
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parking_recycleview_activity);
        auth = FirebaseAuth.getInstance();
        Intent intent = getIntent();
        String query = intent.getStringExtra("query");
        DatabaseReference reference = FirebaseDatabase.getInstance("https://smart-parking-74085-default-rtdb.firebaseio.com/").getReference().child("smartParking").child("parkingOwner");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                parkingStations.clear();
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    ParkingStation parkingStation = snapshot.getValue(ParkingStation.class);
                    if (parkingStation.getCity().equals(query)){
                        parkingStations.add(parkingStation);
                    }
                }
                RecyclerView recyclerView = findViewById(R.id.recycleView);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                CustomAdapter customAdapter = new CustomAdapter(ParkingRecycleView.this, parkingStations);
                recyclerView.setAdapter(customAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}