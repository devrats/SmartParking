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

public class UserRegistration extends AppCompatActivity {

    private Button button;
    private Button button1;
    private EditText name;
    private EditText email;
    private EditText password;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_regestration_activity);
        auth = FirebaseAuth.getInstance();
        name = findViewById(R.id.editTextTextPersonName);
        email = findViewById(R.id.editTextTextPersonName3);
        password = findViewById(R.id.editTextNumber2);
        button = findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ParkingOwnerRegistration.class));
            }
        });
        button1 = findViewById(R.id.button3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = name.getText().toString();
                String userEmail = email.getText().toString();
                String userPassword = password.getText().toString();
                if(TextUtils.isEmpty(userEmail)){
                    email.setError("Please Enter email");
                } else if(TextUtils.isEmpty(userPassword) || userPassword.length()<=6){
                    password.setError("Please enter password");
                } else {
                    Toast.makeText(getApplicationContext(), "Creating Account", Toast.LENGTH_SHORT).show();
                    registerUser(userEmail,userPassword,userName);
                }
            }
        });
    }


    private void registerUser(String userEmail, String userPassword, String userName) {
        auth.createUserWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    String uid = auth.getCurrentUser().getUid();
                    HashMap hashMap = new HashMap();
                    hashMap.put("name",userName);
                    hashMap.put("email",userEmail);
                    hashMap.put("role","user");
                    hashMap.put("uid",uid);
                    FirebaseDatabase.getInstance("https://smart-parking-74085-default-rtdb.firebaseio.com/").getReference().child("smartParking").child("user").child(uid).updateChildren(hashMap);
                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Registration Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}