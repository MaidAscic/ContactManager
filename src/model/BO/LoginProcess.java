package model.BO;

import java.sql.SQLException;

import model.DAO.UserDAOImplementation;
import model.DTO.User;
import model.UI.InitialMenu;
import model.UI.MainMenu;
import model.main.Main;

public class LoginProcess {
	/**
	 * Asks user to input data, calls a method to check the DB for user with inputted data.
	 * If the data is valid, asks for password. If password is incorrect responds with a message
	 * @throws SQLException
	 */
	public static void loginProcess() throws SQLException {

		System.out.println("Enter your name: ");
		String name = Main.input.next();

		System.out.println("Enter your surname: ");
		String surname = Main.input.next();

		User currentUser = findUser(name, surname);

		if (currentUser == null) {
			System.out.println("There is not an existing user with entered name and surname!");
			InitialMenu.initialMenu();
		}
			
		System.out.println("Enter password: ");
		String password = Main.input.next();

		if (isPasswordValid(currentUser, password)) {
			MainMenu mainMenu = new MainMenu(currentUser);
			mainMenu.mainMenu();
		} else
			System.out.println("Entered password is not valid!");

		InitialMenu.initialMenu();
	}

	/**
	 * Passes the inputted data as parameters to query in a DB search method
	 * @param name User name
	 * @param surname User surname
	 * @return User Object
	 * @throws SQLException
	 */
	public static User findUser(String name, String surname) throws SQLException {

		UserDAOImplementation accessUsers = new UserDAOImplementation();
		return accessUsers.getUser(name, surname);

	}

	/**
	 * Checks if the entered password corresponds with the entered username
	 * @param user User-inputted name and surname
	 * @param enteredPassword Entered password to be checked
	 * @return true if password corresponds with user data, false if password doesn't correspond
	 */
	public static boolean isPasswordValid(User user, String enteredPassword) {

		return user.getPassword().equals(enteredPassword);
	}

}
