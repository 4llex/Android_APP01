package com.alex.alimentos.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alex.alimentos.services.listener.OnListClick;
import com.alex.alimentos.R;
import com.alex.alimentos.entities.FoodEntity;
import com.alex.alimentos.ui.viewholder.FoodViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FoodAdapter extends RecyclerView.Adapter<FoodViewHolder> {

    int create = 0; // for debug
    int binder = 0; // for debug

    private List<FoodEntity> mList;
    private OnListClick mListClick;

    public FoodAdapter(List<FoodEntity> list, OnListClick listener){
        this.mList = list;
        this.mListClick = listener;
    }


    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        create++;
        View view = inflater.inflate(R.layout.item_food, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        binder++;
        FoodEntity foodEntity = this.mList.get(position);
        holder.bind(foodEntity, this.mListClick);
    }

    @Override
    public int getItemCount() {
        return this.mList.size();
    }
}
