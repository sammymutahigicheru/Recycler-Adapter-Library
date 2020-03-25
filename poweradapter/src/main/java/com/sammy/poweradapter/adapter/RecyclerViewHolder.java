package com.sammy.poweradapter.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sammy.poweradapter.item.ItemRenderer;
import com.sammy.poweradapter.item.RecyclerItem;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private final ItemRenderer<RecyclerItem> renderer;

    public RecyclerViewHolder(@NonNull ViewGroup parent, ItemRenderer<RecyclerItem> renderer) {
        super(renderer.createView(parent));
        this.renderer = renderer;
    }
    void bind(RecyclerItem item){
        renderer.renderer(itemView,item);
    }
}
