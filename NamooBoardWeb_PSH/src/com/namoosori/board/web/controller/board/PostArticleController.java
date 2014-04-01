package com.namoosori.board.web.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoosori.board.domain.Article;
import com.namoosori.board.domain.User;
import com.namoosori.board.service.facade.BoardService;
import com.namoosori.board.service.factory.NamooBoardServiceFactory;

@WebServlet("/board/post.do")
public class PostArticleController extends HttpServlet{

	private static final long serialVersionUID = -8813043427758594412L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		User user = (User) req.getSession().getAttribute("loginUser");
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		Article article = new Article(); 
		article.setSubject(req.getParameter("subject"));
		article.setContent(req.getParameter("content"));
		//
		User author = new User(user.getUserId());
		author.setName(user.getName());
		
		article.setAuthor(author);
		
		BoardService service = NamooBoardServiceFactory.getInstance().getBoardService();
		service.saveArticle(boardNo, article);
		
		req.getSession().setAttribute("article", article);
		
		resp.sendRedirect("./detailArticle.do?articleNo="+article.getArticleNo()+"&boardNo="+boardNo);
		
	}
	
	

}
