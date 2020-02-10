package model.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import model.DTO.Contact;

public interface ContactDAO {

    ArrayList<Contact> getContact(int userId, String name, String surname, String phoneNumber) throws SQLException;

    void addContact(int userId, String name, String surname, String phoneNumber) throws SQLException;

    void editContact(int userId, String newName, String newSurname, String newPhoneNumber, String phoneNumber)
	    throws SQLException;

    void deleteContact(int userId, String phoneNumber) throws SQLException;

    ArrayList<Contact> retrieveAllContacts(int UserId) throws SQLException;

}
