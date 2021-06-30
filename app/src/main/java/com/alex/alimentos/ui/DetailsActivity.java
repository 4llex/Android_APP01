package com.alex.alimentos.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.alex.alimentos.R;
import com.alex.alimentos.services.business.FoodBusiness;
import com.alex.alimentos.services.constants.FoodConstants;
import com.alex.alimentos.entities.FoodEntity;

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
        this.mViewHolder.mTextQuantity = findViewById(R.id.text_quantity);
        this.mViewHolder.mTextUnit = findViewById(R.id.text_unit);
        this.mViewHolder.mTextDescription = findViewById(R.id.text_description);


        this.getData();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            //Navegação pra MainActivity quando clica na seta

            //Esse condigo cria uma nova activity(criando uma pilha de activities)
            //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            //startActivity(intent);

            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    // Obtem o valor passado por parametro
    private void getData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            //Obtem Id passado por parametro e busca detado alimento
            int id = bundle.getInt(FoodConstants.FOOD_ID);
            FoodEntity food = new FoodBusiness().get(id);

            // Preenche os dados para visualização
            this.mViewHolder.mTextName.setText(food.getName());
            this.mViewHolder.mTextQuantity.setText(String.valueOf(food.getQuantity()));
            this.mViewHolder.mTextUnit.setText(food.getUnit());
            String strCalorias = String.format("%s %s", food.getCalories(), this.getString(R.string.calorias));
            this.mViewHolder.mTextCalories.setText(strCalorias);

            if (!"".equals(food.getDescription())) {
                this.mViewHolder.mTextDescription.setText(food.getDescription());
            }
        }
    }


    //ViewHolder
    private static class ViewHolder {
        TextView mTextName;
        TextView mTextCalories;
        TextView mTextQuantity;
        TextView mTextUnit;
        TextView mTextDescription;
    }

}