package model.DAO;

import java.sql.SQLException;

import model.DTO.User;


public interface UserDAO {
	User getUser(String name, String surname) throws SQLException;

	void addUser(String name, String surname, String password) throws SQLException;

	void deleteUser(Integer id) throws SQLException;

	void deleteContactsTable(Integer id) throws SQLException;


}
