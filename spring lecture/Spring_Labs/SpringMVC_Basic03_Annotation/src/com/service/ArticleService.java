package com.service;

import com.model.NewArticleCommand;

public class ArticleService {
	public ArticleService() {
	System.out.println("ArticleService default constructor");	
	}
	public void writeArticle(NewArticleCommand command) {
		//DAO 객체 생성 ArticleDao dao = new ArticleDao();
		//DAO 객체 함수 호출 dao.insertArticle(command);
		System.out.println("글쓰기 작업 완료" + command.toString());
	}
}
