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

@WebServlet("/board/removeArticle.do")
public class RemoveArticleController extends HttpServlet {

	private static final long serialVersionUID = 6577447176048053827L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		BoardService service = NamooBoardServiceFactory.getInstance().getBoardService();
		String boardNo = req.getParameter("boardNo");
		req.setAttribute("boardNo", boardNo);
		
		int articleNo = Integer.parseInt(req.getParameter("articleNo"));
		service.removeArticle(articleNo);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/articleList.do");
		dispatcher.forward(req, resp);
	}
	
	

}
