package com.alex.alimentos.ui.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.alex.alimentos.services.listener.OnListClick;
import com.alex.alimentos.R;
import com.alex.alimentos.entities.FoodEntity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FoodViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextName;
    private TextView mTextCalories;
    private TextView mTextQuantity;
    private TextView mTextUnit;

    private Context mContext;


    // Metodo Construtor
    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);

        this.mContext = itemView.getContext();

        // mapeando os elementos da interface da linha
        this.mTextName = itemView.findViewById(R.id.text_name);
        this.mTextCalories = itemView.findViewById(R.id.text_calories);
        this.mTextQuantity = itemView.findViewById(R.id.text_quantity);
        this.mTextUnit = itemView.findViewById(R.id.text_unit);
    }

    public void bind(final FoodEntity food, final OnListClick listener) {

        //Atribui os valores para os elementos de interface
        this.mTextName.setText(String.valueOf(food.getName()));
        String strCalorias = String.format("%s %s", food.getCalories(), this.mContext.getString(R.string.calorias));
        this.mTextCalories.setText(strCalorias);
        this.mTextQuantity.setText(String.valueOf(food.getQuantity()));
        this.mTextUnit.setText(String.valueOf(food.getUnit()));

        //toda linha recebe o evento de click
        this.mTextName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(food.getId());
            }
        });
    }

}
