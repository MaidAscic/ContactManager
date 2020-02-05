package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import model.BO.RegistrationProcess;

public class RegistrationServlet extends HttpServlet {


	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name;
		String surname;
		String password;
		RequestDispatcher rd;
		name = request.getParameter("name");
		surname = request.getParameter("surname");
		password = request.getParameter("password");
		try {
			if (RegistrationProcess.doesUserExists(name, surname)) {
				//jsp user already exist response

			} else {
				RegistrationProcess.createUser(name, surname, password);
				rd = request.getRequestDispatcher("/Login.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			rd = request.getRequestDispatcher("sqlerror.html");
			rd.forward(request, response);
		}

	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
