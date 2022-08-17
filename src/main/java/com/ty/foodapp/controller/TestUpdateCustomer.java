package com.ty.foodapp.controller;

import com.ty.foodapp.dao.CustomerDao;
import com.ty.foodapp.dto.Customer;

public class TestUpdateCustomer {
	public static void main(String[] args) {
		CustomerDao customerDao = new CustomerDao();
		Customer customer = customerDao.getCustomer(9080919279l);
		if (customer != null) {
			customer.setPhone(9382699359l);
			customer.setName("rahul");
			customer.setEmail("allen@gmail.com");
			customerDao.updateCustomer(customer);
			System.out.println("Successful");
		} else {
			System.out.println("There is no customer");
		}
	}

}
