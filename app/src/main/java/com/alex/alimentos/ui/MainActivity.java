package com.alex.alimentos.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.alex.alimentos.services.listener.OnListClick;
import com.alex.alimentos.ui.adapter.FoodAdapter;
import com.alex.alimentos.services.business.FoodBusiness;
import com.alex.alimentos.services.constants.FoodConstants;
import com.alex.alimentos.entities.FoodEntity;
import com.alex.alimentos.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();
    private OnListClick mListener;
    private int mFilter = 0;
    private FoodBusiness mFoodBusiness = new FoodBusiness();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.mListener = new OnListClick() {
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


        this.mViewHolder.mRecyclerFood = findViewById(R.id.recycler_food);
        this.mViewHolder.mRecyclerFood.setLayoutManager(new LinearLayoutManager(this)); // contexto "alma da aplicação - todos os dados, estado da app, activities, as informações da app estao no contexto "

        this.listFood();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);

        switch (item.getItemId()){
            case R.id.filter_low:{
                this.mFilter = FoodConstants.FILTER.CAL_LOW;
                break;
            }
            case R.id.filter_medium:{
                this.mFilter = FoodConstants.FILTER.CAL_MEDIUM;
                break;
            }
            default:{
                this.mFilter = FoodConstants.FILTER.CAL_HIGH;
                break;
            }
        }

        this.listFood();
        return super.onOptionsItemSelected(item);
    }

    private void listFood(){
        List<FoodEntity> list = this.mFoodBusiness.getList(this.mFilter);
        this.mViewHolder.mRecyclerFood.setAdapter( new FoodAdapter(list, this.mListener));
    }

    private static class ViewHolder {
        RecyclerView mRecyclerFood;
    }

}