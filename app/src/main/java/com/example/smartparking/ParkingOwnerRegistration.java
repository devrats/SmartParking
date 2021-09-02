package com.example.smartparking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ParkingOwnerRegistration extends AppCompatActivity {

    private Button button;
    private EditText name;
    private EditText email;
    private EditText password;
    private EditText mobile;
    private EditText parkingStationName;
    private EditText fourWheeler;
    private EditText twoWheeler;
    private EditText fourWheeler3;
    private EditText fourWheeler6;
    private EditText fourWheeler12;
    private EditText fourWheeler24;
    private EditText fourWheeler48;
    private EditText twoWheeler3;
    private EditText twoWheeler6;
    private EditText twoWheeler12;
    private EditText twoWheeler24;
    private EditText twoWheeler48;
    private EditText address;
    private EditText city;
    private EditText state;
    private EditText highlight;
    private FirebaseAuth auth;
    String userMobile;
    String userParkingStationName;
    String userName;
    String userFourWheeler;
    String userTwoWheeler;
    String userFourWheeler3;
    String userFourWheeler6;
    String userFourWheeler12;
    String userFourWheeler24;
    String userFourWheeler48;
    String userTwoWheeler3;
    String userTwoWheeler6;
    String userTwoWheeler12;
    String userTwoWheeler24;
    String userTwoWheeler48;
    String userAddress;
    String userCity;
    String userState;
    String userHighlights;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parking_owner_register_activity);
        auth = FirebaseAuth.getInstance();
        button = findViewById(R.id.button7);
        name = findViewById(R.id.editTextTextPersonName2);
        email = findViewById(R.id.editTextTextPersonName4);
        password = findViewById(R.id.editTextTextPassword);
        mobile = findViewById(R.id.editTextTextPersonName7);
        parkingStationName = findViewById(R.id.editTextTextPersonName8);
        fourWheeler = findViewById(R.id.editTextNumber9);
        twoWheeler = findViewById(R.id.editTextNumber10);
        fourWheeler3 = findViewById(R.id.editTextNumber11);
        fourWheeler6 = findViewById(R.id.editTextNumber12);
        fourWheeler12 = findViewById(R.id.editTextNumber13);
        fourWheeler24 = findViewById(R.id.editTextNumber14);
        fourWheeler48 = findViewById(R.id.editTextNumber15);
        twoWheeler3 = findViewById(R.id.editTextNumber16);
        twoWheeler6 = findViewById(R.id.editTextNumber5);
        twoWheeler12 = findViewById(R.id.editTextNumber6);
        twoWheeler24 = findViewById(R.id.editTextNumber7);
        twoWheeler48 = findViewById(R.id.editTextNumber8);
        address = findViewById(R.id.editTextNumber25);
        city = findViewById(R.id.editTextNumber26);
        state = findViewById(R.id.editTextNumber27);
        highlight = findViewById(R.id.editTextTextMultiLine);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = email.getText().toString();
                String userPassword = password.getText().toString();
                userMobile = mobile.getText().toString();
                userParkingStationName = parkingStationName.getText().toString();
                userName = name.getText().toString();
                userFourWheeler = fourWheeler.getText().toString();
                userTwoWheeler = twoWheeler.getText().toString();
                userFourWheeler3 = fourWheeler3.getText().toString();
                userFourWheeler6 = fourWheeler6.getText().toString();
                userFourWheeler12 = fourWheeler12.getText().toString();
                userFourWheeler24 = fourWheeler24.getText().toString();
                userFourWheeler48 = fourWheeler48.getText().toString();
                userTwoWheeler3 = twoWheeler3.getText().toString();
                userTwoWheeler6 = twoWheeler6.getText().toString();
                userTwoWheeler12 = twoWheeler12.getText().toString();
                userTwoWheeler24 = twoWheeler24.getText().toString();
                userTwoWheeler48 = twoWheeler48.getText().toString();
                userAddress = address.getText().toString();
                userCity = city.getText().toString();
                userState = state.getText().toString();
                userHighlights = highlight.getText().toString();
                if(TextUtils.isEmpty(userEmail)){
                    email.setError("Please Enter email");
                } else if(TextUtils.isEmpty(userPassword) || userPassword.length()<=6){
                    password.setError("Please enter password");
                } else {
                    Toast.makeText(getApplicationContext(), "Creating Account", Toast.LENGTH_SHORT).show();
                    registerUser(userEmail,userPassword);
                }
            }
        });
    }

    private void registerUser(String userEmail, String userPassword) {
        auth.createUserWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    String uid = auth.getCurrentUser().getUid();
                    HashMap hashMap = new HashMap<>();
                    hashMap.put("name",userName);
                    hashMap.put("email",userEmail);
                    hashMap.put("mobileNumber",userMobile);
                    hashMap.put("parkingSpaceTwoWheeler",userFourWheeler);
                    hashMap.put("parkingSpaceFourWheeler",userTwoWheeler);
                    hashMap.put("charger4_3",userFourWheeler3);
                    hashMap.put("charger4_6",userFourWheeler6);
                    hashMap.put("charger4_12",userFourWheeler12);
                    hashMap.put("charger4_24",userFourWheeler24);
                    hashMap.put("charger4_48",userFourWheeler48);
                    hashMap.put("charger2_3",userTwoWheeler3);
                    hashMap.put("charger2_6",userTwoWheeler6);
                    hashMap.put("charger2_12",userTwoWheeler12);
                    hashMap.put("charger2_24",userTwoWheeler24);
                    hashMap.put("charger2_48",userTwoWheeler48);
                    hashMap.put("address",userAddress);
                    hashMap.put("city",userCity);
                    hashMap.put("state",userState);
                    hashMap.put("highlight",userHighlights);
                    hashMap.put("parkingStationName",userParkingStationName);
                    hashMap.put("role","owner");
                    hashMap.put("uid",uid);
                    FirebaseDatabase.getInstance("https://smart-parking-74085-default-rtdb.firebaseio.com/").getReference().child("smartParking").child("parkingOwner").child(uid).updateChildren(hashMap);
                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Registration Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}