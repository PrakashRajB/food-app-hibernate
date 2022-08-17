package com.ty.foodapp.controller;

import com.ty.foodapp.dao.FoodMenuDao;

public class TestDeleteFoodMenuById {
	public static void main(String[] args) {
		FoodMenuDao dao=new FoodMenuDao();
		boolean result=dao.deleteFoodMenubyId(6);
		System.out.println(result);
	}

}
