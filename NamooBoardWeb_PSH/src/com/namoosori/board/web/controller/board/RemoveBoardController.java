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

@WebServlet("/board/removeBoard.do")
public class RemoveBoardController extends HttpServlet {

	private static final long serialVersionUID = 7813454416954465951L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		BoardService service = NamooBoardServiceFactory.getInstance().getBoardService();
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		
		service.removeBoard(boardNo);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/boardList.do");
		dispatcher.forward(req, resp);
	}
	
	

}
