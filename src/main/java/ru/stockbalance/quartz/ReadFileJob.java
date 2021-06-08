package ru.stockbalance.quartz;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import ru.stockbalance.model.Article;
import ru.stockbalance.model.FileStock;
import ru.stockbalance.services.ArticleService;



public class ReadFileJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		List<Article> articles = null;
		ArticleService articleService = new ArticleService();
		articles = articleService.getArticlesByDate("", new SimpleDateFormat("yyyy-MM-dd").format(new Date()), new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		
		if (articles != null) {
			System.out.println("Job - Update Articles");
			for(Article art : articles) {
				articleService.updateArticle(art);
			}
		} else {
			System.out.println("Job - Save Articles");
			FileStock file = new FileStock();
			String fileDir =  "http://77.74.28.4:22181/brw/ostatki.xls";
			try {
				file.readFromExcel(fileDir);
			} catch (IOException e) {
				System.out.println("---- EXCEPTION ----" + e.getMessage());
				
			}
		}
		
//		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//		System.out.println("Job - " + articles);
		
	}

}
