package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DTO.Contact;

public class ContactDAOImplementation implements ContactDAO {
	//full crud rebuild
	final Connection connection = ConnectionManager.getInstance().getConnection();

	/**
	 * Searches the DB for a specific contact
	 *
	 * @param userId      user id
	 * @param phoneNumber Contact phone number
	 * @return Contact Object
	 * @throws SQLException
	 */
	@Override
	public ArrayList<Contact> getContact(int userId, String name, String surname, String phoneNumber) throws SQLException {
	    ArrayList<Contact> contactsList = new ArrayList<>();
	    name = "%"+ name + "%";
	    surname = "%"+ surname + "%";
	    phoneNumber = "%" + phoneNumber + "%";
		String query = "SELECT * FROM contacts WHERE id = ? AND (name LIKE ? OR surname LIKE ? OR phonenumber LIKE ?)";

		ResultSet rs;

		try (PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setInt(1, userId);
			statement.setString(2, name);
			statement.setString(3, surname);
			statement.setString(4, phoneNumber);
			rs = statement.executeQuery();

			while (rs.next()) {
				contactsList.add(new Contact(rs.getInt("id"), rs.getString("name"),
						rs.getString("surname"), rs.getString("phonenumber")));
			}


		}

		return contactsList;


	}

	/**
	 * Adds a contact to the DB with passed values
	 *
	 * @param userId      User Id
	 * @param name        Contact name
	 * @param surname     Contact surname
	 * @param phoneNumber Contact phone number
	 * @throws SQLException
	 */
	@Override
	public void addContact(int userId, String name, String surname, String phoneNumber) throws SQLException {
		String query = "INSERT INTO contacts VALUES (?,?, ?, ?)";

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, userId);
			statement.setString(2, name);
			statement.setString(3, surname);
			statement.setString(4, phoneNumber);

			statement.executeUpdate();

		}

	}

	/**
	 * Edits existing contact data
	 *
	 * @param userId         Contact userId
	 * @param newName        New name for the contact
	 * @param newSurname     New Surname for the contact
	 * @param newPhoneNumber New phone number for the contact
	 * @param phoneNumber    Searched phone number
	 * @throws SQLException
	 */
	@Override
	public void editContact(int userId, String newName, String newSurname, String newPhoneNumber, String phoneNumber)
			throws SQLException {
		String query = "UPDATE contacts SET name = ?, surname = ?, phonenumber = ?  WHERE phonenumber = ? AND id = ?";

		try (PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, newName);
			statement.setString(2, newSurname);
			statement.setString(3, newPhoneNumber);
			statement.setString(4, phoneNumber);
			statement.setInt(5, userId);

			statement.executeUpdate();

		}

	}

	/**
	 * Deletes contact from DB
	 *
	 * @param userId      user id
	 * @param phoneNumber Contact phone number
	 * @throws SQLException
	 */
	@Override
	public void deleteContact(int userId, String phoneNumber) throws SQLException {

		String query = "DELETE FROM contacts WHERE  phonenumber = ? AND id = ?";

		try (PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, phoneNumber);
			statement.setInt(2, userId);

			statement.executeUpdate();

		}

	}


	/**
	 * Returns contacts from DB
	 *
	 * @param userId userId
	 * @return List with Contacts
	 * @throws SQLException
	 */
	@Override
	public ArrayList<Contact> retrieveAllContacts(int userId) throws SQLException {
		ArrayList<Contact> contactsList = new ArrayList<>();
		String query = "SELECT * FROM contacts WHERE id = ?";

		ResultSet rs;

		try (PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setInt(1, userId);
			rs = statement.executeQuery();

			while (rs.next()) {
				contactsList.add(new Contact(rs.getInt("id"), rs.getString("name"),
						rs.getString("surname"), rs.getString("phonenumber")));
			}


		}

		return contactsList;

	}
}
