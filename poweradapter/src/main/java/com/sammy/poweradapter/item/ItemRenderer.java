package com.sammy.poweradapter.item;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

public interface ItemRenderer<T extends RecyclerItem> {
    @LayoutRes
    int layoutRes();
    View createView(@NonNull ViewGroup parent);
    void renderer(@NonNull View itemView,@NonNull T item);
}
