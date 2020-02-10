package model.BO;

import java.sql.SQLException;

import model.DAO.UserDAOImplementation;

public class RegistrationProcess {
	static UserDAOImplementation accessUsers = new UserDAOImplementation();

	/**
	 * Checks if the user with passed data already exists
	 *
	 * @param name    First name of the user
	 * @param surname Surname of the user
	 * @return true if user exist, false if user doesn't exist
	 * @throws SQLException
	 */
	public static boolean doesUserExists(String name, String surname) throws SQLException {
		return accessUsers.getUser(name, surname) != null;
	}

	/**
	 * Creates a new user with passed data
	 *
	 * @param name
	 * @param surname
	 * @param password
	 * @throws SQLException
	 */
	public static void createUser(String name, String surname, String password) throws SQLException {
		accessUsers.addUser(name, surname, password);
	}

}
