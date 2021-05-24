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
		Session session  = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction  = session.beginTransaction();
			session.save(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println("EXCEPTION !---- save error ----!");
			System.out.println(e.getMessage());
		}  finally {
			session.close();
		}
		
		
//		session.close();
		
	}

	public void updateUser(User user) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction =  session.beginTransaction();
			session.update(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println("EXCEPTION !---- UpdateUser error ----!");
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		
		
//		session.close();
		
	}

	public User getUserById(int id) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		User user = null;
		try {
			transaction = session.beginTransaction();
			user = session.get(User.class, id);
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println("EXCEPTION !---- get User by ID error ----!");
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		
//		session.close();
		return user;
	}

	public List<User> getAllUsers() {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<User> users = null;
		try {
			transaction = session.beginTransaction();
			users = session.createQuery("FROM users").list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println("EXCEPTION !---- get all User error ----!");
			System.out.println(e.getMessage());
		} finally {
			session.close();			
		}
		

		return users;
	}

	public void deleteUser(User user) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			 transaction = session.beginTransaction();
			 session.delete(user);
			 transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println("EXCEPTION !---- Delete User error ----!");
			System.out.println(e.getMessage());
		} finally {
			session.close();	
		}
		
		
		
	}

	

}
