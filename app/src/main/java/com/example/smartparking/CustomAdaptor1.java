package com.example.smartparking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class CustomAdapter1 extends RecyclerView.Adapter<CustomAdapter1.ViewHolder1> {

    private static List<ParkingStation> localDataSet;
    private Context context;
    private View view;

    public static class ViewHolder1 extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final TextView textView1;
        private final TextView textView2;

        public TextView getTextView2() {
            return textView2;
        }

        public ViewHolder1(View view) {
            super(view);
            textView = view.findViewById(R.id.textView38);
            textView1 = view.findViewById(R.id.textView42);
            textView2 = view.findViewById(R.id.textView52);

        }

        public TextView getTextView() {
            return textView;
        }

        public TextView getTextView1() {
            return textView1;
        }
    }

    public CustomAdapter1(Context context, List<ParkingStation> dataSet) {
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
//        viewHolder.getTextView().setText(String.valueOf(localDataSet.get(position).getParkingSpaceTwoWheeler()));
//        viewHolder.getTextView1().setText(String.valueOf(localDataSet.get(position).getParkingSpaceFourWheeler()));
//        viewHolder.getTextView2().setText(String.valueOf(localDataSet.get(position).getName()));
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}

