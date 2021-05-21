package ru.stockbalance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import ru.stockbalance.model.User;
import ru.stockbalance.util.HibernateSessionFactoryUtil;

/**
 * User CRUD
 * 
 * @author Designer
 *
 */
public class UserDaoImp implements UserDAO<User>{

	public void saveUser(User user){
		
		//Exception - length login and password must be < 20 
		
		// Open session. getSession Factory - from util.HibernateSessionFactoryUtil
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(user);
		} catch (Exception e) {
			System.out.println("EXCEPTION !---- save error ----!");
			System.out.println(e.getMessage());
		} 
		
		try {
			transaction.commit();
		} catch (Exception hibernateException) {
				System.out.println("EXCEPTION !---- commit error ----!");
				System.out.println(hibernateException.getMessage());
		} finally {
			session.close();
		}
		
		
		session.close();
		
	}

	public void updateUser(User user) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(user);
		transaction.commit();
		session.close();
		
	}

	public User getUserById(int id) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		User user = session.get(User.class, id);
		transaction.commit();
		session.close();
		return user;
	}

	public List<User> getAllUsers() {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		List<User> users = session.createQuery("FROM users").list();
		transaction.commit();
		session.close();
		return users;
	}

	public void deleteUser(User user) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(user);
		transaction.commit();
		session.close();
		
	}

	

}
