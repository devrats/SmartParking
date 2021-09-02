package com.example.smartparking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class BookParking extends AppCompatActivity {

    private TextView textView;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;
    private TextView textView10;
    private EditText editText;
    private EditText editText1;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private RadioButton radioButton1;
    private Button button;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_parking_activity);
        Intent intent = getIntent();
        auth = FirebaseAuth.getInstance();
        textView = findViewById(R.id.textView25);
        textView2 = findViewById(R.id.textView28);
        textView3 = findViewById(R.id.textView30);
        textView4 = findViewById(R.id.textView26);
        textView5 = findViewById(R.id.textView47);
        textView6 = findViewById(R.id.textView49);
        textView7 = findViewById(R.id.textView51);
        textView8 = findViewById(R.id.textView53);
        textView9 = findViewById(R.id.textView55);
        textView10 = findViewById(R.id.textView57);
        textView10.setText(intent.getStringExtra("highlight"));
        radioButton1 = findViewById(R.id.radioButton2);
        radioButton1.setChecked(true);
        button = findViewById(R.id.button13);
        editText = findViewById(R.id.editTextTextPersonName9);
        editText1 = findViewById(R.id.editTextTime);
        radioGroup = findViewById(R.id.radioGroup1);
        textView.setText(intent.getStringExtra("name"));
        textView2.setText(String.valueOf( intent.getStringExtra("2Wheeler")));
        textView3.setText(String.valueOf( intent.getStringExtra("4Wheeler")));
        textView4.setText(intent.getStringExtra("address"));
        String uid = intent.getStringExtra("uid");
        DatabaseReference reference = FirebaseDatabase.getInstance("https://smart-parking-74085-default-rtdb.firebaseio.com/").getReference().child("smartParking").child("parkingOwner").child(uid);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ParkingStation value = dataSnapshot.getValue(ParkingStation.class);
                textView5.setText(value.getCharger2_3());
                textView6.setText(value.getCharger2_6());
                textView7.setText(value.getCharger2_12());
                textView8.setText(value.getCharger2_24());
                textView9.setText(value.getCharger2_48());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);
                if(selectedId==-1){
                    Toast.makeText(getApplicationContext(),"Nothing selected", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(radioButton.getText().equals("2 Wheeler")){
                        DatabaseReference reference = FirebaseDatabase.getInstance("https://smart-parking-74085-default-rtdb.firebaseio.com/").getReference().child("smartParking").child("parkingOwner").child(uid);
                        reference.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                ParkingStation value = dataSnapshot.getValue(ParkingStation.class);
                                textView5.setText(value.getCharger2_3());
                                textView6.setText(value.getCharger2_6());
                                textView7.setText(value.getCharger2_12());
                                textView8.setText(value.getCharger2_24());
                                textView9.setText(value.getCharger2_48());
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
                                textView5.setText(value.getCharger4_3());
                                textView6.setText(value.getCharger4_6());
                                textView7.setText(value.getCharger4_12());
                                textView8.setText(value.getCharger4_24());
                                textView9.setText(value.getCharger4_48());
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vehicleNumber = editText.getText().toString();
                String time = editText1.getText().toString();
                HashMap hashMap = new HashMap();
                hashMap.put("vehicleNumber",vehicleNumber);
                hashMap.put("time",time);
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);
                if(selectedId==-1){
                    Toast.makeText(getApplicationContext(),"Nothing selected", Toast.LENGTH_SHORT).show();
                }
                else{
                    hashMap.put("type",radioButton.getText().toString());
                    Toast.makeText(getApplicationContext(), "Slot booked go ahead!", Toast.LENGTH_SHORT).show();
                    editText1.setText("");
                    editText1.setHint("time");
                    editText.setText("");
                    editText.setHint("vehicle Number");
                    FirebaseDatabase.getInstance("https://smart-parking-74085-default-rtdb.firebaseio.com/").getReference().child("smartParking").child("parking").child(uid).child(vehicleNumber).updateChildren(hashMap);
                    if(radioButton.getText().equals("2 Wheeler")){
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