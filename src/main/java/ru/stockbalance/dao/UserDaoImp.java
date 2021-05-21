package ru.stockbalance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ru.stockbalance.model.User;
import ru.stockbalance.util.HibernateSessionFactoryUtil;

public class UserDaoImp implements UserDAO<User>{

	public void saveUser(User user) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
		
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	

}
