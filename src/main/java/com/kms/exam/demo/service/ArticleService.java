package com.kms.exam.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kms.exam.demo.repository.ArticleRepository;
import com.kms.exam.demo.util.Ut;
import com.kms.exam.demo.vo.Article;
import com.kms.exam.demo.vo.ResultData;

@Component
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}
	
	public void modifyArticle(int id, String title, String body) {
		articleRepository.modifyArticle(id, title, body);
	}

	public ResultData writeArticle(String title, String body) {
		// TODO Auto-generated method stub
		articleRepository.writeArticle(title, body);
		int id = articleRepository.getLastInsertId();
		return ResultData.from("S-1", Ut.f("%d번 게시물이 생성되었습니다.", id),id);
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
}
