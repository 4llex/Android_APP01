package com.alex.alimentos.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.alex.alimentos.listener.OnListClick;
import com.alex.alimentos.adapter.FoodAdapter;
import com.alex.alimentos.business.FoodBusiness;
import com.alex.alimentos.constants.FoodConstants;
import com.alex.alimentos.entity.FoodEntity;
import com.alex.alimentos.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<FoodEntity> list = new FoodBusiness().getList();

        // entre a lista e o layout da lista existe o ADAPTER


        //(1) obter recycler view
        this.mViewHolder.mRecyclerFood = findViewById(R.id.recycler_food);

        OnListClick foodListener = new OnListClick() {
            @Override
            public void onClick(int id) {

                Bundle bundle = new Bundle();
                bundle.putInt(FoodConstants.FOOD_ID, id);

                //Navegação quando clica na comida
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        };

        //(2) definir um adapter - ADAPTER faz a junção dos dados com o elemento de interface () adaptar os dados
        FoodAdapter adapter = new FoodAdapter(list, foodListener);
        this.mViewHolder.mRecyclerFood.setAdapter(adapter);

        //(3) definir um layout - criar um layout da linha da lista
        this.mViewHolder.mRecyclerFood.setLayoutManager(new LinearLayoutManager(this)); // contexto "alma da aplicação - todos os dados, estado da app, activities, as informações da app estao no contexto "
    }


    private static class ViewHolder {
        RecyclerView mRecyclerFood;
    }

}