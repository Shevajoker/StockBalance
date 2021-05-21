package ru.stockbalance.main;

import ru.stockbalance.model.User;
import ru.stockbalance.services.UserService;

public class MainUser {

	
	public static void main(String[] args) {
		
		UserService userService = new UserService();
		User user = new User("Boby", "1234");
		
		userService.saveUser(user);
		
		
		
	}
	
}
