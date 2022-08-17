package com.ty.foodapp.controller;

import com.ty.foodapp.dao.FoodMenuDao;
import com.ty.foodapp.dto.FoodMenu;

public class TestUpdateFoodMenu {
	public static void main(String[] args) {
		FoodMenuDao dao = new FoodMenuDao();
		FoodMenu menu = dao.getFoodMenuById(6);
		if (menu != null) {
			menu.setCost(369);
			menu.setDescription("italian");
			dao.updateFoodMenu(menu);
		} else {
			System.out.println("data not found");
		}
	}

}
