package com.ty.foodapp.controller;

import com.ty.foodapp.dao.FoodMenuDao;
import com.ty.foodapp.dto.FoodMenu;

public class TestAddFoodMenu {
	public static void main(String[] args) {
		FoodMenu menu=new FoodMenu();
		menu.setName("Burger");
		menu.setDescription("mexican");
		menu.setCost(130);
		
		FoodMenuDao dao=new FoodMenuDao();
		dao.addFoodMenu(menu);
		System.out.println("---------------------");
	}

}
