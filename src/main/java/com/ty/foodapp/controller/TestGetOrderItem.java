package com.ty.foodapp.controller;

import java.util.List;

import com.ty.foodapp.dao.FoodOrderDao;
import com.ty.foodapp.dto.FoodOrder;
import com.ty.foodapp.dto.OrderItem;

public class TestGetOrderItem {
	public static void main(String[] args) {
		FoodOrderDao dao = new FoodOrderDao();
		dao.removeOrderItem(1, 2);
	}

}
