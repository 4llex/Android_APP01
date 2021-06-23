package com.alex.alimentos.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.alex.alimentos.R;
import com.alex.alimentos.business.FoodBusiness;
import com.alex.alimentos.constants.FoodConstants;
import com.alex.alimentos.entity.FoodEntity;

public class DetailsActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // Interface Elements
        this.mViewHolder.mTextName = findViewById(R.id.text_name);
        this.mViewHolder.mTextCalories = findViewById(R.id.text_calories);

        this.getData();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            //Navegação pra MainActivity quando clica na seta

            //Esse condigo cria uma nova activity(criando uma pilha de activities)
            //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            //startActivity(intent);

            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void getData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int id = bundle.getInt(FoodConstants.FOOD_ID);
            FoodEntity foodEntity = new FoodBusiness().get(id);

            this.mViewHolder.mTextName.setText(foodEntity.getName());
            this.mViewHolder.mTextCalories.setText(String.valueOf(foodEntity.getCalories()));
        }
    }

    private static class ViewHolder {
        TextView mTextName;
        TextView mTextCalories;
    }

}