package com.ty.foodapp.controller;

import com.ty.foodapp.dao.UserDao;

public class TestDeleteUser {
	public static void main(String[] args) {
		UserDao dao = new UserDao();
        dao.deleteUserById(9);
        System.out.println("-------------------------------");
	}

}
