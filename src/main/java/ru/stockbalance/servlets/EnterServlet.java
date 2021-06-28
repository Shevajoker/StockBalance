package ru.stockbalance.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ru.stockbalance.dao.UserDaoImp;
import ru.stockbalance.model.Article;
import ru.stockbalance.model.User;
import ru.stockbalance.services.ArticleService;

/**
 * Servlet implementation class EnterServlet
 */
public class EnterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public EnterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		List<Article> allArticles;
		String login = (String) request.getParameter("login");
		String password = (String) request.getParameter("password");
		String message = "";
		HttpSession session = request.getSession();

		if (login.equals("") || password.equals("")) {

			request.setAttribute("login", login);
			request.setAttribute("password", password);
			message = "Enter Login and Password!";
			request.setAttribute("message",
					"<div class=\"alert alert-danger\" role=\"alert\">\r\n" + message + "</div>");
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		} else {

			User user = new User();
			user.setLogin(login);
			user.setPassword(password);
			
			
			UserDaoImp userDao = new UserDaoImp();
			System.out.println(userDao.checkUser(login, password));
			if (userDao.checkUser(login, password)) {
				ArticleService articleService = new ArticleService();
				allArticles = articleService.getAllArticles();

				session.setAttribute("login", user.getLogin());
				session.setAttribute("allArticles", allArticles);

				getServletContext().getRequestDispatcher("/stocktable.jsp").forward(request, response);
			} else {

				request.setAttribute("login", login);
				request.setAttribute("password", password);
				message = "User does not exist ";
				request.setAttribute("message",
						"<div class=\"alert alert-danger\" role=\"alert\">\r\n" + message + "</div>");
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}

		}
	}

}
