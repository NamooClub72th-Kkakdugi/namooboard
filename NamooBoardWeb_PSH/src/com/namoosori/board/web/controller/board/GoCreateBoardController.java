package com.namoosori.board.web.controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/goCreate.do")
public class GoCreateBoardController extends HttpServlet {

	private static final long serialVersionUID = 3368638746151340544L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/createBoard.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	

}
