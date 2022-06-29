package com.kms.exam.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kms.exam.demo.repository.ArticleRepository;
import com.kms.exam.demo.vo.Article;

@Component
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	public Article writeArticle(String title, String body) {
		// TODO Auto-generated method stub
		return articleRepository.writeArticle(title, body);
	}

	public List<Article> getArticles() {
		// TODO Auto-generated method stub
		return articleRepository.getArticles();
	}

	public Article getArticle(int id) {
		// TODO Auto-generated method stub
		return articleRepository.getArticle(id);
	}

	public void deleteArticle(int id) {
		// TODO Auto-generated method stub
		articleRepository.deleteArticle(id);
	}

	public void modifyArticle(int id, String title, String body) {
		// TODO Auto-generated method stub
		Article article = getArticle(id);
		article.setTitle(title);
		article.setBody(body);
	}
}
