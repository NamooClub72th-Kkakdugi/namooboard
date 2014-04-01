package com.namoosori.board.web.controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/goPost.do")
public class GoPostArticleController extends HttpServlet{

	private static final long serialVersionUID = -1119522119846999998L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		String boardNo = req.getParameter("boardNo");
		req.setAttribute("boardNo", boardNo);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/postArticle.jsp");
		dispatcher.forward(req, resp);
	}

	
}
