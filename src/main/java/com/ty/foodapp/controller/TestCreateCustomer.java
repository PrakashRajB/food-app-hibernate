package com.ty.foodapp.controller;

import com.ty.foodapp.dao.CustomerDao;
import com.ty.foodapp.dto.Customer;

public class TestCreateCustomer {
	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setName("prakash");
		customer.setEmail("prakash@gmail.com");
		customer.setPhone(9080919278l);

		CustomerDao customerDao = new CustomerDao();
		customerDao.createCustomer(customer);
		System.out.println("------------------------");
	}

}
