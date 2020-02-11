package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DTO.User;

public class UserDAOImplementation implements UserDAO {
	Connection connection = ConnectionManager.getInstance().getConnection();

	/**
	 * Searches for user in DB
	 *
	 * @param name    User name
	 * @param surname User surname
	 * @return User object
	 * @throws SQLException
	 */
	@Override
	public User getUser(String name, String surname) throws SQLException {

		User user = null;

		String query = "SELECT * FROM users WHERE name = ? AND surname = ?";

		ResultSet rs = null;

		try (PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, name);
			statement.setString(2, surname);

			rs = statement.executeQuery();

			if (rs.next()) {

				user = new User(rs.getInt("id"),
						rs.getString("name"),
						rs.getString("surname"),
						rs.getString("password"))
				;

				rs.close();
			}
		}
		return user;
	}

	/**
	 * Adds a user into DB
	 *
	 * @param name     User name
	 * @param surname  User surname
	 * @param password User password
	 * @throws SQLException
	 */
	@Override
	public void addUser(String name, String surname, String password) throws SQLException {

		String query = "INSERT INTO users(name, surname, password) VALUES (?, ?, ?)";

		try (PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, name);
			statement.setString(2, surname);
			statement.setString(3, password);

			statement.executeUpdate();

		}
	}


	@Override
	public void deleteUser(Integer id) throws SQLException {
		String query = "DELETE FROM users WHERE id = ?";

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, id);

			statement.executeUpdate();

		}
		deleteContactsTable(id);
	}

	@Override
	public void deleteContactsTable(Integer id) throws SQLException {
		String query = "DELETE FROM contacts WHERE id=?";

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, id);

			statement.executeUpdate();

		}
	}
}



