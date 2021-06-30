package com.alex.alimentos.services.business;

import com.alex.alimentos.services.constants.FoodConstants;
import com.alex.alimentos.entities.FoodEntity;
import com.alex.alimentos.services.repository.FoodRepository;

import java.util.ArrayList;
import java.util.List;

public class FoodBusiness {

    private FoodRepository mFoodRepository = new FoodRepository();


    // Retorna um alimento especifico
    public FoodEntity get(int id) {
        return this.mFoodRepository.get(id);
    }


    //retorna lista de alimentos
    public List<FoodEntity> getList(int filter){

        List<FoodEntity> list = this.mFoodRepository.getList(); // uma lista com todos elementos
        List<FoodEntity> filtered = new ArrayList<>(); // uma lista vazia

        if (filter == FoodConstants.FILTER.NO_FILTER){
            return list;
        }

        for (FoodEntity f : list){

            if (filter == FoodConstants.FILTER.CAL_LOW){
                if(f.getCalories() <= 99){
                    filtered.add(f);
                }
            } else if (filter == FoodConstants.FILTER.CAL_MEDIUM){
                if(f.getCalories() >=100 && f.getCalories() <= 199){
                    filtered.add(f);
                }
            } else if (filter == FoodConstants.FILTER.CAL_HIGH){
                if(f.getCalories() >= 200){
                    filtered.add(f);
                }
            }

        }



        return filtered;
    }



}
