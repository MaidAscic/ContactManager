package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO.ContactDAOImplementation;
import model.DTO.Contact;
import model.DTO.User;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String name = request.getParameter("name");
	String surname = request.getParameter("surname");
	String phoneNumber = request.getParameter("phonenumber");
	HttpSession hs = request.getSession();
	RequestDispatcher rd;
	User cu = (User) hs.getAttribute("currentUser");
	ArrayList<Contact> contacts;
	ContactDAOImplementation cdi = new ContactDAOImplementation();
	try {
	    contacts = cdi.getContact(cu.getId(), name, surname, phoneNumber);
	    hs.setAttribute("searchContactsList", contacts);
	    rd = request.getRequestDispatcher("Search.jsp");
	    rd.forward(request, response);
	} catch (SQLException e) {
	    e.printStackTrace();
	    rd = request.getRequestDispatcher("sqlerror.jsp");
	    rd.forward(request, response);
	}

    }

}
