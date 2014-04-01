package com.namoosori.board.web.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoosori.board.domain.User;
import com.namoosori.board.service.facade.UserService;
import com.namoosori.board.service.factory.NamooBoardServiceFactory;

@WebServlet("/user/detail.do")
public class ShowUserInfoController extends HttpServlet {

	private static final long serialVersionUID = 102804125060628972L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		String userId = req.getParameter("userId");
		UserService service = NamooBoardServiceFactory.getInstance().getUserService();
		User user = service.getUser(userId);
		req.setAttribute("user", user);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/showUserInfo.jsp");
		dispatcher.forward(req, resp);
	}
}
