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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		List<Article> allArticles;
		String name = (String) request.getParameter("login");
		
		ArticleService articleService = new ArticleService();
		allArticles = articleService.getAllArticles();
		
		HttpSession session = request.getSession();
		session.setAttribute("login", name);
		session.setAttribute("allArticles", allArticles);
		
		getServletContext().getRequestDispatcher("/stocktable.jsp").forward(request, response);
		
//		doGet(request, response);
	}

}
