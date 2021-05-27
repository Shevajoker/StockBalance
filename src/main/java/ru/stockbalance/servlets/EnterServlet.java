package ru.stockbalance.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ru.stockbalance.model.Article;
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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Article> allArticles;
		
		ArticleService articleService = new ArticleService();
		allArticles = articleService.getAllArticles();
		
		HttpSession session = request.getSession();
		session.setAttribute("login", "UserLogin");
		session.setAttribute("allArticles", allArticles);
		
		getServletContext().getRequestDispatcher("/stocktable.jsp").forward(request, response);
		
//		doGet(request, response);
	}

}
