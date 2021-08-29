package com.example.smartparking;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private static List<ParkingStation> localDataSet;
    private Context context;
    private View view;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final TextView textView1;
        private final TextView textView2;

        public TextView getTextView3() {
            return textView3;
        }

        private final TextView textView3;

        public TextView getTextView2() {
            return textView2;
        }

        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(view.getContext(),MainActivity8.class);
                    intent.putExtra("name", localDataSet.get(getAdapterPosition()).getName());
                    intent.putExtra("address", localDataSet.get(getAdapterPosition()).getAddress());
                    intent.putExtra("uid", localDataSet.get(getAdapterPosition()).getUid());
                    intent.putExtra("2Wheeler",localDataSet.get(getAdapterPosition()).getParkingSpaceTwoWheeler());
                    intent.putExtra("4Wheeler",localDataSet.get(getAdapterPosition()).getParkingSpaceFourWheeler());
                    intent.putExtra("highlight",localDataSet.get(getAdapterPosition()).getHighlight());
                    view.getContext().startActivity(intent);
                }
            });
            textView = view.findViewById(R.id.textView21);
            textView1 = view.findViewById(R.id.textView23);
            textView2 = view.findViewById(R.id.textView18);
            textView3 = view.findViewById(R.id.textView19);

        }

        public TextView getTextView() {
            return textView;
        }

        public TextView getTextView1() {
            return textView1;
        }
    }

    public CustomAdapter(Context context, List<ParkingStation> dataSet) {
        this.context = context;
        localDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_main6, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getTextView().setText(String.valueOf(localDataSet.get(position).getParkingSpaceTwoWheeler()));
        viewHolder.getTextView1().setText(String.valueOf(localDataSet.get(position).getParkingSpaceFourWheeler()));
        viewHolder.getTextView2().setText(String.valueOf(localDataSet.get(position).getName()));
        viewHolder.getTextView3().setText(String.valueOf(localDataSet.get(position).getAddress()));
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}

