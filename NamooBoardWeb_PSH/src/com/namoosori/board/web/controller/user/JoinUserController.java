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

@WebServlet("/user/join.do")
public class JoinUserController extends HttpServlet {

	private static final long serialVersionUID = 3797265047298248476L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		String paramId = req.getParameter("userId");
		String parampassword = req.getParameter("password");
		String paramname = req.getParameter("userName");
		String paramEmail = req.getParameter("userEmail");
		
		UserService service = NamooBoardServiceFactory.getInstance().getUserService();
		service.registUser(paramId, parampassword, paramname, paramEmail);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("./list.do");
		dispatcher.forward(req, resp);
	}
	
	

}
