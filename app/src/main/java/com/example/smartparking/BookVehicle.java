package com.example.smartparking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class BookVehicle extends AppCompatActivity {

    private TextView textView;
    private TextView textView1;
    private TextView textView2;
    private Button button;
    private Button button2;
    private Button button3;
    RadioGroup radioGroup;
    RadioButton radioButton;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_vehicle_activity);
        auth = FirebaseAuth.getInstance();
        button = findViewById(R.id.button11);
        button2 = findViewById(R.id.button5);
        textView = findViewById(R.id.textView31);
        textView1 = findViewById(R.id.editTextTextPersonName10);
        textView2 = findViewById(R.id.editTextTime2);
        radioGroup = findViewById(R.id.radioGroup);
        button3 = findViewById(R.id.button10);
        Intent intent = getIntent();
        textView.setText("Hey " + intent.getStringExtra("name") + "!");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), VehicleRecycleView.class));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vehicleNumber = textView1.getText().toString();
                String time = textView2.getText().toString();
                HashMap hashMap = new HashMap();
                hashMap.put("vehicleNumber",vehicleNumber);
                hashMap.put("time",time);
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(selectedId);
                if(selectedId==-1){
                    Toast.makeText(getApplicationContext(),"Nothing selected", Toast.LENGTH_SHORT).show();
                }
                else{
                    hashMap.put("type",radioButton.getText().toString());
                    String uid = auth.getCurrentUser().getUid();
                    Toast.makeText(getApplicationContext(), "Value added", Toast.LENGTH_SHORT).show();
                    textView1.setText("");
                    textView1.setHint("time");
                    textView2.setText("");
                    textView2.setHint("vehicle Number");
                    FirebaseDatabase.getInstance("https://smart-parking-74085-default-rtdb.firebaseio.com/").getReference().child("smartParking").child("parking").child(uid).child(vehicleNumber).updateChildren(hashMap);
                    if(radioButton.getText().equals("2 Wheeler")){
                        Log.d("mm","hello1");
                        DatabaseReference reference = FirebaseDatabase.getInstance("https://smart-parking-74085-default-rtdb.firebaseio.com/").getReference().child("smartParking").child("parkingOwner").child(uid);
                        reference.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                ParkingStation value = dataSnapshot.getValue(ParkingStation.class);
                                int parkingSpaceTwoWheeler = Integer.parseInt(value.getParkingSpaceTwoWheeler());
                                int newParkingSpaceTwoWheeler = parkingSpaceTwoWheeler-1;
                                reference.child("parkingSpaceTwoWheeler").setValue(String.valueOf(newParkingSpaceTwoWheeler));
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    } else {
                        DatabaseReference reference = FirebaseDatabase.getInstance("https://smart-parking-74085-default-rtdb.firebaseio.com/").getReference().child("smartParking").child("parkingOwner").child(uid);
                        reference.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                ParkingStation value = dataSnapshot.getValue(ParkingStation.class);
                                int parkingSpaceFourWheeler = Integer.parseInt(value.getParkingSpaceFourWheeler());
                                int newParkingSpaceFourWheeler = parkingSpaceFourWheeler-1;
                                reference.child("parkingSpaceFourWheeler").setValue(String.valueOf(newParkingSpaceFourWheeler));
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }
                }
            }
        });
    }

}