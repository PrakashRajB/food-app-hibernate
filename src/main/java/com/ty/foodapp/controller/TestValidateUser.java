package com.ty.foodapp.controller;

import com.ty.foodapp.dao.UserDao;
import com.ty.foodapp.helper.AES;

public class TestValidateUser {
	public static void main(String[] args) {
		UserDao dao = new UserDao();
//		 boolean result = dao.validateUser("sekar@gmail.com", AES.encrypt("sekar1234"));
		boolean result = dao.validateUser(9382699359l, AES.encrypt("sekar1234"));
		if(result) {
			System.out.println("login sucesful");
		}
		else {
			System.out.println("invalid password or email");
		}
	}

}
