package ru.stockbalance.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.stockbalance.model.User;
import ru.stockbalance.services.UserService;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String passwordRep = request.getParameter("passwordRep");
		String message = "";

		if (login.equals("") || password.equals("") || passwordRep.equals("")) {
			request.setAttribute("login", login);
			request.setAttribute("password", password);
			message = "Enter Login and Password!";
			request.setAttribute("message",
					"<div class=\"alert alert-danger\" role=\"alert\">\r\n" + message + "</div>");
			getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
		} else {
			request.setAttribute("login", login);
			request.setAttribute("password", password);
			if (password.equals(passwordRep)) {
				UserService userService = new UserService();
				userService.saveUser(new User(login, password));
				request.setAttribute("login", login);
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			} else {
				request.setAttribute("login", login);
				request.setAttribute("password", password);
				message = "Wrong password!";
				request.setAttribute("message",
						"<div class=\"alert alert-danger\" role=\"alert\">\r\n" + message + "</div>");
				getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
			}
		}

	}

}
