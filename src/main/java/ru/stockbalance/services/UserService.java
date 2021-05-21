package ru.stockbalance.services;

import java.util.List;

import ru.stockbalance.dao.UserDaoImp;
import ru.stockbalance.model.User;

public class UserService {

	UserDaoImp userDao = new UserDaoImp();
	
	public UserService() {}
	
	public void saveUser(User user) {
		userDao.saveUser(user);
	}
	
	
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}
	
	public List<User> getAllUsers(){
		return userDao.getAllUsers();
	}
	
	public void updateUser (User user) {
		userDao.updateUser(user);
	}
	
	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}
	
	
}
