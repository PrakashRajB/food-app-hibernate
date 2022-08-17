package com.ty.foodapp.controller;

import com.ty.foodapp.dao.CustomerDao;
import com.ty.foodapp.dto.Customer;

public class TestGetCustomer {
	public static void main(String[] args) {

		CustomerDao customerDao = new CustomerDao();
		Customer customer = customerDao.getCustomer(9080919278l);
		if (customer != null) {
			System.out.println(customer);
		}
		else {
			System.out.println("There is no customer with this phone number");
		}
	}

}
