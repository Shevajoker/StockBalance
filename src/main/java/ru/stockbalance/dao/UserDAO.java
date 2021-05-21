package ru.stockbalance.dao;

import java.util.List;

public interface UserDAO<Entity> {

	public void saveUser(Entity user);
	public void updateUser(Entity user);
	public Entity getUserById(int id);
	public List<Entity> getAllUsers();
	public void deleteUser(Entity user);
	
}
