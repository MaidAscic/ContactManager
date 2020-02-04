package controller;

import model.DTO.User;
import model.BO.LoginProcess;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


public class LoginServlet extends HttpServlet {



	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		RequestDispatcher rd;
		String name;
		String surname;
		String password;
		name = request.getParameter("name");
		surname = request.getParameter("surname");
		password = request.getParameter("password");
		User currentUser;
		if (!name.equals("") && !surname.equals("") && !password.equals("")) {
			try {
				currentUser = LoginProcess.findUser(name, surname);

				if (currentUser == null) {
//				rd = request.getRequestDispatcher("Login.jsp");
					//jsp user not found response
				} else if (LoginProcess.isPasswordValid(currentUser, password)) {
					hs.setAttribute("currentUser", currentUser);
					rd = request.getRequestDispatcher("MainMenuUI.jsp");
					rd.forward(request, response);
				}

			} catch (SQLException e) {
				rd = request.getRequestDispatcher("sqlerror.html");
				rd.forward(request, response);
			}
		} else {
			//jsp response for bad input
		}

	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		request.setAttribute("name", name);
//		request.setAttribute("surname", surname);
//		request.setAttribute("password", password);
//		doPost(request, response);
	}

}