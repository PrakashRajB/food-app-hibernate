package com.ty.foodapp.controller;

import java.util.List;

import com.ty.foodapp.dao.FoodMenuDao;
import com.ty.foodapp.dto.FoodMenu;

public class TestGetAllFoodMenu {
	public static void main(String[] args) {
		FoodMenuDao dao = new FoodMenuDao();
		List<FoodMenu> menuList = dao.getAllFoodMenu();
		System.out.println(menuList);
	}

}
