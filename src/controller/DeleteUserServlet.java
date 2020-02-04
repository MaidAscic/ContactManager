package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO.UserDAOImplementation;
import model.DTO.User;

public class DeleteUserServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd;
		User cu;
		HttpSession hs = req.getSession();
		UserDAOImplementation udi = new UserDAOImplementation();
		try {

			cu = (User) hs.getAttribute("currentUser");

			udi.deleteUser(cu.getId());
			hs.setAttribute("currentUser", null);
			rd = req.getRequestDispatcher("index.html");
			rd.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
			rd = req.getRequestDispatcher("sqlerror.html");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
