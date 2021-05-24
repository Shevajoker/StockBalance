package ru.stockbalance.main;

import ru.stockbalance.model.User;
import ru.stockbalance.services.UserService;

public class MainUser {

	
	public static void main(String[] args) {
		
		UserService userService = new UserService();
		User user ;;
		
		user = userService.getUserById(5);
		
		if (user != null) {
		System.out.println(user.toString());
		} else {
			System.out.println("user - null!");
		}
		
		
	}
	
}
