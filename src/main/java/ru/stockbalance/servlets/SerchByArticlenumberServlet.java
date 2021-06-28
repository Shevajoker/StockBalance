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
 * Servlet implementation class SerchByArticlenumberServlet
 */
public class SerchByArticlenumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerchByArticlenumberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List<Article> allArticles;
		String articleNumber = request.getParameter("articleNumber").toString();
		
		ArticleService articleService = new ArticleService();
		allArticles = articleService.getArticlesByArticleNumber(articleNumber);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("allArticles", allArticles);
		
		getServletContext().getRequestDispatcher("/stocktable.jsp").forward(request, response);
	}

}
