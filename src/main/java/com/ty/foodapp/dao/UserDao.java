package com.ty.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.foodapp.dto.FoodMenu;
import com.ty.foodapp.dto.User;
import com.ty.foodapp.helper.EntityHelper;

public class UserDao {

	public void createUser(User user) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
	}

	public boolean deleteUserById(int id) {
		boolean result = false;
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		User user = entityManager.find(User.class, id);
		if (user != null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			result = true;
		}

		return result;
	}

	public User getUserById(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		return entityManager.find(User.class, id);
	}

	public boolean validateUser(String email, String password) {
		boolean result = false;
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		String jpql = "select u from User u where email=?1 and password=?2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, email);
		query.setParameter(2, password);

		List<User> users = query.getResultList();
		if (!users.isEmpty()) {
			result = true;
		}
		return result;
	}

	public boolean validateUser(Long phone, String password) {
		boolean result = false;
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		String jpql = "select u from User u where phone=?1 and password=?2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, phone);
		query.setParameter(2, password);

		List<User> users = query.getResultList();
		if (!users.isEmpty()) {
			result = true;
		}
		return result;
	}

}
