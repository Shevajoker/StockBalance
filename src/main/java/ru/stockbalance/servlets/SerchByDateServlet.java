package ru.stockbalance.servlets;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ru.stockbalance.model.Article;
import ru.stockbalance.services.ArticleService;

/**
 * Servlet implementation class SerchByDateServlet
 */
public class SerchByDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerchByDateServlet() {
        super();
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
		request.setCharacterEncoding("utf-8");
		List<Article> allArticles;
		
		String dateIn = request.getParameter("dateIn");
		String dateOut = request.getParameter("dateOut");
		
		String error = null;
		String articleNumber = request.getParameter("articleNumber").toString();
		ArticleService articleService = new ArticleService();
		allArticles = articleService.getArticlesByDate(articleNumber, dateIn, dateOut);
		
		HttpSession session = request.getSession();
		session.setAttribute("dateIn", dateIn);
		session.setAttribute("dateOut", dateOut);
		session.setAttribute("arror", error);
		session.setAttribute("allArticles", allArticles);
		getServletContext().getRequestDispatcher("/stocktable.jsp").forward(request, response);
	}

}
