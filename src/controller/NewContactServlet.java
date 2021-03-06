package controller;

import model.DAO.ContactDAOImplementation;
import model.DTO.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class NewContactServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		doPost(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactDAOImplementation cdi = new ContactDAOImplementation();
		User cu;

		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String phoneNumber = request.getParameter("phoneNumber");
		HttpSession hs = request.getSession();
		RequestDispatcher rd;
		try {
			cu = (User) hs.getAttribute("currentUser");
			cdi.addContact(cu.getId(), name, surname, phoneNumber);
			rd = request.getRequestDispatcher("MainMenuUI.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			rd = request.getRequestDispatcher("WEB-INF/sqlerror.jsp");
			rd.forward(request, response);
		}
	}
}
