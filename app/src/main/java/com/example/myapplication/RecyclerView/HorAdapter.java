package com.example.myapplication.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class HorAdapter extends RecyclerView.Adapter<HorAdapter.LinearViewHolder> {
    private Context mContext;

    public HorAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public HorAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LinearViewHolder linearViewHolder = new LinearViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.layout_hor, parent, false));
        linearViewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = linearViewHolder.getAdapterPosition();
                Toast.makeText(v.getContext(), "你点击的是第"+(position+1)+"个hello",Toast.LENGTH_LONG).show();
            }
        });
        return linearViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HorAdapter.LinearViewHolder holder, int position) {
        holder.textView.setText("hello");
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
        }
    }
}
