package com.ty.foodapp.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityHelper {
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	static EntityManager entityManager;

	public static EntityManager getManager() {
		return entityManagerFactory.createEntityManager();
	}

}
