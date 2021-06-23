package com.alex.alimentos.viewholder;

import android.view.View;
import android.widget.TextView;

import com.alex.alimentos.OnListClick;
import com.alex.alimentos.R;
import com.alex.alimentos.entity.FoodEntity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FoodViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextName;
    private TextView mTextCalories;


    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);

        this.mTextName = itemView.findViewById(R.id.text_name);
        this.mTextCalories = itemView.findViewById(R.id.text_calories);

    }

    public void bind(final FoodEntity food, final OnListClick listener){
        this.mTextName.setText(String.valueOf(food.getName()));
        this.mTextCalories.setText(String.valueOf(food.getCalories()));

        this.mTextName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(food.getId());
            }
        });
    }

}
