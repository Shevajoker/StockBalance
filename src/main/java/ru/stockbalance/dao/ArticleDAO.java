package ru.stockbalance.dao;

import java.util.Date;
import java.util.List;

public interface ArticleDAO<Entity> {

	public void saveArticle(Entity article);
	public void updateArticle(Entity article);
	public Entity getArticleByArticleNumber(String articleNumber);
	public List<Entity> getAllArticles();
	public void deleteArticle (Entity article);
	public List<Entity> getArticlesByArticleNumber(String article);
	public List<Entity> getArticlesByDate(String article, Date dateIn, Date dateOut);
}
