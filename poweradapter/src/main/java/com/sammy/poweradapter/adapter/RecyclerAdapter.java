package com.sammy.poweradapter.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private final RecyclerDataSource source;

    public RecyclerAdapter(RecyclerDataSource source){

        this.source = source;
        source.attachToAdapter(this);
        setHasStableIds(true);
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(parent,source.rendererForType(viewType));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.bind(source.getItem(position));
    }

    @Override
    public int getItemCount() {
        return source.getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return source.viewSourceForPosition(position);
    }

    @Override
    public long getItemId(int position) {
        return source.getItem(position).getId();
    }
}
