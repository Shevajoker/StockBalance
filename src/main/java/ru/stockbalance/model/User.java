package ru.stockbalance.model;

import javax.persistence.*;

/**
 * 
 * @author Designer
 *
 */

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String login;
	private String password;
	
	
	
	/**
	 * Constructor
	 */
	
	public User(){}
	
	/**
	 * Constructor
	 * 
	 * @param login
	 * @param password
	 */
	public User (String login, String password){
		
		if(login != null && login.length() < 20) {
			this.login = login;	
		} else {
			System.out.println("Invalid LOGIN!!!!");
		}
		
		if(password != null && password.length() < 20) {
			this.password = password;	
		} else {
			System.out.println("Invalid PASSWORD!!!!");
		}
		
		
		
		
	}

	
	/**
	 * Getters and Setters
	 * 
	 */
	
	public int getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Override ToString
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + "]";
	}
	
	
	
	
	
	
	
}
