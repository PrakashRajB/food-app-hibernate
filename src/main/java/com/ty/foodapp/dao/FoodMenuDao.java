package com.ty.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.foodapp.dto.FoodMenu;
import com.ty.foodapp.helper.EntityHelper;

public class FoodMenuDao {

	public void addFoodMenu(FoodMenu menu) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(menu);
		entityTransaction.commit();
	}

	public List<FoodMenu> getAllFoodMenu() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String jpql = "select m from FoodMenu m";
		Query query = entityManager.createQuery(jpql);

		List<FoodMenu> menuList = query.getResultList();

		return menuList;
	}

	public boolean deleteFoodMenubyId(int id) {
		boolean result = false;
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		FoodMenu menu = entityManager.find(FoodMenu.class, id);
		if (menu != null) {
			entityTransaction.begin();
			entityManager.remove(menu);
			entityTransaction.commit();
			result = true;
		}
		return result;
	}
	
	public void updateFoodMenu(FoodMenu menu ) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction =entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.merge(menu);
		entityTransaction.commit();
	}

	public FoodMenu getFoodMenuById(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		FoodMenu menu = entityManager.find(FoodMenu.class, id);
		return menu;
	}

}
