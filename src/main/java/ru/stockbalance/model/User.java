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
		this.login = login;
		this.password = password;
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
