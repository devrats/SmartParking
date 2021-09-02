package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Search extends AppCompatActivity {

    TextView textView;
    Button button;
    FirebaseAuth auth;
    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        textView = findViewById(R.id.textView24);
        auth = FirebaseAuth.getInstance();
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        textView.setText("Hey! " + name + " Search Here According To City");
        button = findViewById(R.id.button12);
        searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent1 = new Intent(getApplicationContext(), ParkingRecycleView.class);
                intent1.putExtra("query",query);
                startActivity(intent1);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });
    }
}