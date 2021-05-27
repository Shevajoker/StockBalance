package ru.stockbalance.dao;

import java.util.List;

public interface ArticleDAO<Entity> {

	public void saveArticle(Entity article);
	public void updateArticle(Entity article);
	public Entity getArticleByArticleNumber(String articleNumber);
	public Entity getCountByArticleNumber(String articleNumber);
	public List<Entity> getAllArticles();
	public void deleteArticle (Entity article);
	
	
}
