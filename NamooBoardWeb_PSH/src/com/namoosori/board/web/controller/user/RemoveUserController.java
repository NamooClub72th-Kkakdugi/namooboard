package com.namoosori.board.web.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoosori.board.service.facade.UserService;
import com.namoosori.board.service.factory.NamooBoardServiceFactory;

@WebServlet("/user/remove.do")
public class RemoveUserController extends HttpServlet {

	private static final long serialVersionUID = -2283788692088479458L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		UserService service = NamooBoardServiceFactory.getInstance().getUserService();
		
		String userId = req.getParameter("userId");
		service.removeUser(userId);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("./list.do");
		dispatcher.forward(req, resp);
	}
	
	

}
