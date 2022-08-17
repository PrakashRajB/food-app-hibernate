package com.ty.foodapp.controller;

import com.ty.foodapp.dao.UserDao;
import com.ty.foodapp.dto.User;
import com.ty.foodapp.helper.AES;

public class TeatCreateUser {
	public static void main(String[] args) {
		User user = new User();
		user.setName("Mani");
		user.setEmail("mani@gmail.com");
		user.setPhone(9551266885l);
		user.setPassword(AES.encrypt("mani1234"));
		user.setRole("manager");

		UserDao dao = new UserDao();
        dao.createUser(user);
        System.out.println("-----------------------------");
	}
}
