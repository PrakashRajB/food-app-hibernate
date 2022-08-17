package com.ty.foodapp.controller;

import com.ty.foodapp.dao.UserDao;
import com.ty.foodapp.dto.User;
import com.ty.foodapp.helper.AES;

public class TestGetUser {
	public static void main(String[] args) {
		UserDao dao=new UserDao();
		User user = dao.getUserById(10);
		if(user!=null) {
			System.out.println(user.getId());
			System.out.println(user.getName());
			System.out.println(user.getEmail());
			System.out.println(user.getPhone());
			System.out.println(AES.decrypt(user.getPassword()));
			System.out.println(user.getRole());
		}
		else {
			System.out.println("there is no user");
		}
	}

}
