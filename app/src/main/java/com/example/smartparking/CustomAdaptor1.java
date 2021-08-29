package com.example.smartparking;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CustomAdapter1 extends RecyclerView.Adapter<CustomAdapter1.ViewHolder1> {

    private static List<Vehicle> localDataSet;
    private Context context;
    private View view;

    public static class ViewHolder1 extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final TextView textView1;
        private final TextView textView2;
        private final Button button;

        public TextView getTextView2() {
            return textView2;
        }

        public ViewHolder1(View view) {
            super(view);
            textView = view.findViewById(R.id.textView38);
            textView1 = view.findViewById(R.id.textView42);
            textView2 = view.findViewById(R.id.textView52);
            button = view.findViewById(R.id.button15);
            FirebaseAuth auth = FirebaseAuth.getInstance();
            String uid = auth.getCurrentUser().getUid();
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String vehicleNumber = localDataSet.get(getAdapterPosition()).getVehicleNumber();
                    String type = localDataSet.get(getAdapterPosition()).getType();

                    DatabaseReference ref = FirebaseDatabase.getInstance("https://smart-parking-74085-default-rtdb.firebaseio.com/").getReference();
                    Query applesQuery = ref.child("smartParking").child("parking").child(uid).orderByChild("vehicleNumber").equalTo(vehicleNumber);
                    applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot appleSnapshot : dataSnapshot.getChildren()) {
                                appleSnapshot.getRef().removeValue();
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.d("onCancelled", databaseError.toException().toString());
                        }
                    });
                    if (localDataSet.get(getAdapterPosition()).getType().equals("2 Wheeler")) {
                        Log.d("mm", "hello1");
                        DatabaseReference reference = FirebaseDatabase.getInstance("https://smart-parking-74085-default-rtdb.firebaseio.com/").getReference().child("smartParking").child("parkingOwner").child(uid);
                        reference.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                ParkingStation value = dataSnapshot.getValue(ParkingStation.class);
                                int parkingSpaceTwoWheeler = Integer.parseInt(value.getParkingSpaceTwoWheeler());
                                int newParkingSpaceTwoWheeler = parkingSpaceTwoWheeler + 1;
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
                                int newParkingSpaceFourWheeler = parkingSpaceFourWheeler + 1;
                                reference.child("parkingSpaceFourWheeler").setValue(String.valueOf(newParkingSpaceFourWheeler));
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }
                }
            });
        }

        public TextView getTextView() {
            return textView;
        }

        public TextView getTextView1() {
            return textView1;
        }
    }

    public CustomAdapter1(Context context, List<Vehicle> dataSet) {
        this.context = context;
        localDataSet = dataSet;
    }

    @Override
    public ViewHolder1 onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_main11, viewGroup, false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder1 viewHolder, final int position) {
        viewHolder.getTextView().setText(String.valueOf(localDataSet.get(position).getVehicleNumber()));
        viewHolder.getTextView1().setText(String.valueOf(localDataSet.get(position).getType()));
        viewHolder.getTextView2().setText(String.valueOf(localDataSet.get(position).getTime()));
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}

