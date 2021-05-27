package ru.stockbalance.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * http://77.74.28.4:22181/brw/ostatki.xls
 * @author Designer
 *
 */
@Entity
@Table(name = "articles")
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String article;
	private String name;
	private int stock;
	private Date date;
	
	public Article() {}
	
	public Article(String article, String name, int stock) {
		this.article = article;
		this.name = name;
		this.date = new Date();
		this.stock = stock;
		
	}
	
	public Article(String article, String name, Date date, int stock) {
		this.article = article;
		this.name = name;
		this.date = date;
		this.stock = stock;
		
	}

	public int getId() {
		return id;
	}


	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	

	public Date getDate() {
		return (Date) date.clone();
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", article=" + article + ", name=" + name + ", stock=" + stock + ", date=" + date
				+ "]";
	}

	

	
	
	
}
