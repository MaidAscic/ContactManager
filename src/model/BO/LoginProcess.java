package model.BO;

import java.sql.SQLException;

import model.DAO.UserDAOImplementation;
import model.DTO.User;

public class LoginProcess {


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
