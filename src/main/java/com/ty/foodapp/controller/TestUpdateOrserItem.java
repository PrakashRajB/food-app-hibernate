package com.ty.foodapp.controller;


import com.ty.foodapp.dao.FoodOrderDao;
import com.ty.foodapp.dto.OrderItem;

public class TestUpdateOrserItem {
	public static void main(String[] args) {

		FoodOrderDao dao = new FoodOrderDao();
		OrderItem item = dao.getOrderItemById(2);
		item.setQuantity(4);
		
	}

}
