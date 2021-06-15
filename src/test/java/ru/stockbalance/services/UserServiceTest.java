package ru.stockbalance.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.stockbalance.model.User;

class UserServiceTest {

	private int id = 0;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testUserService() {
		UserService userService = new UserService();
		assertNotNull(userService);
	}

	@Test
	void testSaveUser() {
		UserService userService = new UserService();
		User user = new User("Jim", "qwerty");
		userService.saveUser(user);
		id = user.getId();
		User user2 = userService.getUserById(user.getId());
		assertEquals(user.getId(), user2.getId()); 
		
	}

	@Test
	void testGetUserById() {
		UserService userService = new UserService();
		assertInstanceOf(User.class, userService.getUserById(17));
	}

	@Test
	void testGetAllUsers() {
		List<User> users = null;
		UserService userService = new UserService();
		users = userService.getAllUsers();
		assertEquals(true, (users.size()>1), "GooD");
		

	}

	@Test
	void testUpdateUser() {
		UserService userService = new UserService();
		User user = userService.getUserById(17);
		user.setLogin("Set");
		userService.updateUser(user);
		assertEquals(user.getLogin(), "Set");
	}

	@Test
	void testDeleteUser() {
		UserService userService = new UserService();
		User user = userService.getUserById(id);
		userService.deleteUser(user);
		user = userService.getUserById(id);
		assertNull(user);
	}

	@Test
	void testCheckUser() {
		UserService userService = new UserService();
		User user = new User("qwe", "123");
		assertTrue(userService.checkUser(user.getLogin(), user.getPassword()));
	}

}
