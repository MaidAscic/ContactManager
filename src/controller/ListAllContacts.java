package controller;

import model.DAO.ContactDAOImplementation;
import model.DTO.Contact;
import model.DTO.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListAllContacts extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession();
		RequestDispatcher rd;
		User cu = (User) hs.getAttribute("currentUser");
		ArrayList<Contact> contacts;
		ContactDAOImplementation cdi = new ContactDAOImplementation();
		try {
			contacts = cdi.retrieveAllContacts(cu.getId());
			hs.setAttribute("contactsList", contacts);
			rd = req.getRequestDispatcher("ListAllContacts.jsp");
			rd.forward(req, resp);
		} catch (SQLException e) {
			rd = req.getRequestDispatcher("sqlerror.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
