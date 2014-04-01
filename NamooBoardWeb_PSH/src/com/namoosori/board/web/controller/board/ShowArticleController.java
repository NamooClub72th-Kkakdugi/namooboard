package com.namoosori.board.web.controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoosori.board.service.facade.BoardService;
import com.namoosori.board.service.factory.NamooBoardServiceFactory;

@WebServlet("/board/detailArticle.do")
public class ShowArticleController extends HttpServlet{

	private static final long serialVersionUID = 5034056839775470930L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		req.setAttribute("boardNo", boardNo);
		int articleNo = Integer.parseInt(req.getParameter("articleNo"));
		
		BoardService service = NamooBoardServiceFactory.getInstance().getBoardService();
		req.setAttribute("article", service.getArticle(articleNo));
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/confirmArticle.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	

}
