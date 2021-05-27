package ru.stockbalance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ru.stockbalance.model.Article;
import ru.stockbalance.util.HibernateSessionFactoryUtil;

public class ArticleDaoImpl implements ArticleDAO<Article>{

	@Override
	public void saveArticle(Article article) {
		
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(article);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("EXCEPTION !---- ARTICLE save error ----!");
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		
		
	}

	@Override
	public void updateArticle(Article article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Article getArticleByArticleNumber(String articleNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article getCountByArticleNumber(String articleNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteArticle(Article article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Article> getAllArticles() {
		List<Article> allArticles = null;
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			allArticles = session.createQuery("FROM Article").list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println("EXCEPTION !---- getAllArticles error ----!");
			System.out.println(e.getMessage());
		} finally {
			
			session.close();
		}
		
		
		return allArticles;
	}
	
	

}
