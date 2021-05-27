package ru.stockbalance.main;


import java.util.List;

import ru.stockbalance.model.User;
import ru.stockbalance.services.UserService;

public class MainUser {

	
	public static void main(String[] args) {
		
		UserService userService = new UserService();
		List<User> users = userService.getAllUsers();
		
		
//		User user ;;
//		
//		user = userService.getUserById(5);
//		
//		if (user != null) {
//		System.out.println(user.toString());
//		} else {
//			System.out.println("user - null!");
//		}
//		
		
	}
	
}
