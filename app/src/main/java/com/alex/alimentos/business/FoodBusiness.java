package com.alex.alimentos.business;

import com.alex.alimentos.entity.FoodEntity;
import com.alex.alimentos.repository.FoodRepository;

import java.util.List;

public class FoodBusiness {

    public List<FoodEntity> getList(){
        return new FoodRepository().getList();
    }

    public FoodEntity get(int id) {
        return new FoodRepository().get(id);
    }

}
