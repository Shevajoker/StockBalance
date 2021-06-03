package ru.stockbalance.services;


import java.util.List;

import ru.stockbalance.dao.ArticleDaoImpl;
import ru.stockbalance.model.Article;

public class ArticleService {

	ArticleDaoImpl articleDAO = new ArticleDaoImpl();
	
	public ArticleService() {}
	
	
	public void saveArticle (Article article) {
		articleDAO.saveArticle(article);
	}
	
	
	public List<Article> getAllArticles (){
		return articleDAO.getAllArticles();
	}
	
	public List<Article> getArticlesByArticleNumber (String article){
		return articleDAO.getArticlesByArticleNumber(article);
	}
	
	public List<Article> getArticlesByDate (String article, String dateIn, String dateOut){
		return articleDAO.getArticlesByDate(article, dateIn, dateOut);
	}
	
	
	
}
