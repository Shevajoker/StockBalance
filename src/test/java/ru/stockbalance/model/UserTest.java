package ru.stockbalance.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class UserTest {

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
	void testUser() {
	 	User user = new User(); 
	 	assertInstanceOf(User.class, user);
	}

	@Test
	void testUserStringString() {
		User user = new User("Bob", "pass");
		assertInstanceOf(User.class, user);
	}

	@Test
	void testGetId() {
		User user = new User("Bob", "pass");
		assertNotNull(user.getId());
		
	}

	@Test
	void testGetLogin() {
		User user = new User("Bob", "pass");
		assertNotNull(user.getLogin());
	}

	@Test
	void testSetLogin() {
		User user = new User("Bob", "pass");
		user.setLogin("Bob2");
		assertEquals("Bob2", user.getLogin());
	}

	@Test
	void testGetPassword() {
		User user = new User("Bob", "pass");
		assertEquals("pass", user.getPassword());
	}

	@Test
	void testSetPassword() {
		User user = new User("Bob", "pass");
		user.setPassword("pass2");
		assertEquals("pass2", user.getPassword());
	}

	@Test
	void testToString() {
		User user = new User("Bob", "pass");
		assertNotNull(user.toString());
	}

}
