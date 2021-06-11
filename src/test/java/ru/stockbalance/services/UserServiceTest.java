package ru.stockbalance.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.stockbalance.model.User;

class UserServiceTest {

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

//	@Test
//	void testSaveUser() {
//		UserService userService = new UserService();
//		User user = new User("Jim", "qwerty");
//		userService.saveUser(user);
//		User user2 = userService.getUserById(user.getId());
//		assertEquals(user.getId(), user2.getId()); 
//		
//	}

	@Test
	void testGetUserById() {
		UserService userService = new UserService();
		assertInstanceOf(User.class, userService.getUserById(17));
	}

	@Test
	void testGetAllUsers() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateUser() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteUser() {
		fail("Not yet implemented");
	}

	@Test
	void testCheckUser() {
		fail("Not yet implemented");
	}

}
