package com.ty.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.foodapp.dto.Customer;
import com.ty.foodapp.helper.EntityHelper;

public class CustomerDao {

	public void createCustomer(Customer customer) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager =entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();
	}

	public Customer getCustomer(long phone) {
		Customer customer = null;
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager =entityManagerFactory.createEntityManager();

		String jpql = "select c from Customer c where phone=?1";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, phone);

		List<Customer> customers = query.getResultList();
		if (!customers.isEmpty()) {
			customer = customers.get(0);
		}
		return customer;
	}

	public void updateCustomer(Customer customer) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager =entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.merge(customer);
		entityTransaction.commit();
	}
}
