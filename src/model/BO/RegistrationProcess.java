package model.BO;

import java.sql.SQLException;

import model.DAO.UserDAOImplementation;
import model.UI.InitialMenu;
import model.main.Main;

public class RegistrationProcess {
	static UserDAOImplementation accessUsers = new UserDAOImplementation();

	/**
	 * Asks user to input data, calls a method to check the data.
	 * If the data is valid calls a method to create a new User
	 *
	 * @throws SQLException
	 */
	public static void registerProcess() throws SQLException {

		System.out.println("Enter your name: ");
		String name = Main.input.next();

		System.out.println("Enter your surname: ");
		String surname = Main.input.next();

		if (doesUserExists(name, surname)) {
			System.out.println("That user already exists!");
			InitialMenu.initialMenu();
		}

		System.out.println("Enter your password: ");
		String password = Main.input.next();

		createUser(name, surname, password);
		System.out.println("The user has been successfully created!");

		InitialMenu.initialMenu();
	}

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
