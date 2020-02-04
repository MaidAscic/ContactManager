package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static ConnectionManager instance = null;

	private static final String USERNAME = "root";
	private static final String PASSWORD = "zmajodbosne12345";
	private static final String CONN_STRING = "jdbc:mysql://localhost/imenikBaza?serverTimezone=UTC";

	private Connection connection = null;

	private ConnectionManager() {

	}

	/**
	 * Creates an instance of object
	 * @return Object for DB management
	 */
	public static ConnectionManager getInstance() {
		if (instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}

	/**
	 * Opens connection to DB
	 * @return true if successfully opened
	 */
	private boolean openConnection() {

		try {
			connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Connection getConnection() {
		if (connection == null) {
			if (openConnection()) {
				return connection;
			} else {
				return null;
			}
		}
		return connection;
	}

	/**
	 * Closes connection to DB
	 */
	public void close() {
		try {
			System.out.println("Connection closed");
			connection.close();
			connection = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}