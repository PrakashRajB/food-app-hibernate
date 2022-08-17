package com.ty.foodapp.controller;

import java.util.List;

import com.ty.foodapp.dao.FoodOrderDao;
import com.ty.foodapp.dto.FoodOrder;
import com.ty.foodapp.dto.OrderItem;

public class TestGetFoodOrder {
	public static void main(String[] args) {

		FoodOrderDao dao = new FoodOrderDao();
		FoodOrder foodOrder = dao.getFoodOrderById(1);
		System.out.println(foodOrder);
		List<OrderItem> items=foodOrder.getItems();
		
//		OrderItem item=dao.getOrderItemById(2);
//		dao.removeOrderItem(item);
//		items.remove(item);
//		foodOrder.setItems(items);
//		dao.updateFoodOrder(foodOrder);
		
		System.out.println(foodOrder.getItems());
	}

}
