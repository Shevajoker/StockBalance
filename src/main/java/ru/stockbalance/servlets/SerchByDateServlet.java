package ru.stockbalance.servlets;

import java.io.IOException;
import java.text.ParseException;
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
		Date dateIn = null;
		Date dateOut = null;
		String error = null;
		String articleNumber = request.getParameter("articleNumber").toString();
		SimpleDateFormat availDate = new SimpleDateFormat("dd-MM-yyyy");
		try {
			
			dateIn = availDate.parse(request.getParameter("dateIn"));
			dateOut = availDate.parse(request.getParameter("dateOut"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			error = e.getMessage();
			e.printStackTrace();
		}
		
		
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
