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

public class DeleteContactServlet extends HttpServlet {

	private ContactDAOImplementation cdi = new ContactDAOImplementation();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		String phoneNumber = request.getParameter("phoneNumber");
		HttpSession hs = request.getSession();
		User cu = (User) hs.getAttribute("currentUser");
		try {
			cdi.deleteContact(cu.getId(), phoneNumber);
			rd = request.getRequestDispatcher("MainMenuUI.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			rd = request.getRequestDispatcher("sqlerror.html");
			rd.forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
