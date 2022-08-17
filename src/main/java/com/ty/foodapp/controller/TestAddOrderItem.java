package com.ty.foodapp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ty.foodapp.dao.FoodMenuDao;
import com.ty.foodapp.dao.FoodOrderDao;
import com.ty.foodapp.dto.FoodMenu;
import com.ty.foodapp.dto.OrderItem;

public class TestAddOrderItem {
	public static void main(String[] args) {
		FoodMenuDao dao = new FoodMenuDao();
		FoodMenu menu1 = dao.getFoodMenuById(1);
		FoodMenu menu2 = dao.getFoodMenuById(2);
		
		List<OrderItem> items =new ArrayList();
		
		FoodOrderDao dao2 = new FoodOrderDao();
		OrderItem item1 = dao2.addOrderItem(menu1, 1);
		OrderItem item2 = dao2.addOrderItem(menu2, 2);
        items.add(item1);
        items.add(item2);
		
		dao2.createFoodOrder(items);
	}

}
