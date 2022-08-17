package com.ty.foodapp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;

import com.ty.foodapp.dto.FoodMenu;
import com.ty.foodapp.dto.FoodOrder;
import com.ty.foodapp.dto.OrderItem;

public class FoodOrderDao {
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();
	private EntityTransaction entityTransaction = entityManager.getTransaction();

	public void createFoodOrder(List<OrderItem> items) {
		FoodOrder foodOrder = new FoodOrder();

		Double totalItemsPrice = items.stream().collect(Collectors.summingDouble(item -> item.getCost()));

		foodOrder.setStatus("Ordered");
		foodOrder.setItems(items);
		foodOrder.setCost(totalItemsPrice);

		entityTransaction.begin();
		entityManager.persist(foodOrder);
		entityTransaction.commit();
	}

	public FoodOrder getFoodOrderById(int id) {

		FoodOrder foodOrder = entityManager.find(FoodOrder.class, id);

		return foodOrder;
	}

	public boolean cancelFoodOrder(FoodOrder foodOrder) {
		if (foodOrder != null) {
			entityTransaction.begin();
			entityManager.remove(foodOrder);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public void updateFoodOrder(FoodOrder foodOrder) {
		Double totalItemsPrice = foodOrder.getItems().stream()
				.collect(Collectors.summingDouble(item -> item.getCost()));
		foodOrder.setCost(totalItemsPrice);
		entityTransaction.begin();
		entityManager.merge(foodOrder);
		entityTransaction.commit();
	}

	public OrderItem addOrderItem(FoodMenu menu, int quantity) {
		OrderItem item = new OrderItem();

		item.setName(menu.getName());
		item.setCost(menu.getCost() * quantity);
		item.setQuantity(quantity);
		return item;
	}

	public OrderItem getOrderItemById(int id) {
		OrderItem item = entityManager.find(OrderItem.class, id);
		return item;
	}

	public void removeOrderItem(int foodId, int itemId) {
		FoodOrder foodOrder = getFoodOrderById(foodId);
		OrderItem item = getOrderItemById(itemId);
		List<OrderItem> items = foodOrder.getItems();
		items.remove(item);
		foodOrder.setItems(items);
		foodOrder.setCost(foodOrder.getCost() - item.getCost());
		updateFoodOrder(foodOrder);
		entityTransaction.begin();
		entityManager.remove(item);
		entityTransaction.commit();

	}

	public void updateOrderItem(int foodId, int orderId, int quantity) {
		OrderItem item = getOrderItemById(orderId);

		entityTransaction.begin();
		entityManager.merge(item);
		entityTransaction.commit();
	}

}
