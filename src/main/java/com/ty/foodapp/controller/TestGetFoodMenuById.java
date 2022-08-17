package com.ty.foodapp.controller;

import com.ty.foodapp.dao.FoodMenuDao;
import com.ty.foodapp.dto.FoodMenu;

public class TestGetFoodMenuById {
	public static void main(String[] args) {
		FoodMenuDao dao = new FoodMenuDao();
		FoodMenu menu = dao.getFoodMenuById(7);
		if(menu!=null) {
			System.out.println(menu);
		}
		else {
			System.out.println("data not found");
		}
	}

}
