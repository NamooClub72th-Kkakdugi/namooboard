package com.namoosori.board.web.controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoosori.board.domain.User;
import com.namoosori.board.service.facade.BoardService;
import com.namoosori.board.service.factory.NamooBoardServiceFactory;

@WebServlet("/board/createBoard.do")
public class CreateBoardController extends HttpServlet {

	private static final long serialVersionUID = -5730375959369444011L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		BoardService service = NamooBoardServiceFactory.getInstance().getBoardService();
		User user = (User) req.getSession().getAttribute("loginUser");
		String boardName = req.getParameter("boardName");
		String userId = user.getUserId();

		service.createBoard(boardName, userId);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("./boardList.do");
		dispatcher.forward(req, resp);
		
	}
	
	

}
