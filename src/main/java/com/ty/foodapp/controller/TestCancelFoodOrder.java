package com.ty.foodapp.controller;

import com.ty.foodapp.dao.FoodOrderDao;
import com.ty.foodapp.dto.FoodOrder;

public class TestCancelFoodOrder {
	public static void main(String[] args) {
		FoodOrderDao dao = new FoodOrderDao();
		FoodOrder foodOrder = dao.getFoodOrderById(1);
		System.out.println(dao.cancelFoodOrder(foodOrder));
	}

}
