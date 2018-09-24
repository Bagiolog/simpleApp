package com.example.stage3.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RecyclerViewAdapter extends RecyclerView.Adapter {
    String[] vettoreNomi;
    Context context;

    public RecyclerViewAdapter(String[]nomi,Context context){
        this.vettoreNomi=nomi;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        TextView nome=viewHolder.itemView.findViewById(R.id.tNome);
        nome.setText(vettoreNomi[i]);
    }



    @Override
    public int getItemCount() {
        return vettoreNomi.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nome;
        public MyViewHolder(View itemView) {
            super(itemView);
            nome = (TextView) itemView.findViewById(R.id.tNome);
        }
    }



}
