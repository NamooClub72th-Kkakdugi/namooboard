package com.namoosori.board.web.controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoosori.board.domain.Board;
import com.namoosori.board.service.facade.BoardService;
import com.namoosori.board.service.factory.NamooBoardServiceFactory;

@WebServlet("/board/boardList.do")
public class ListBoardController extends HttpServlet {

	private static final long serialVersionUID = 5949676744244394714L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		BoardService service = NamooBoardServiceFactory.getInstance().getBoardService();
		List<Board> boards = service.getAllBoards();
		req.setAttribute("boards", boards);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/boardList.jsp");
		dispatcher.forward(req, resp);
	}
	
	

}
