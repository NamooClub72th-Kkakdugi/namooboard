package com.namoosori.board.web.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoosori.board.service.dto.LoginResult;
import com.namoosori.board.service.facade.UserService;
import com.namoosori.board.service.factory.NamooBoardServiceFactory;

@WebServlet("/user/login.do")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 571709368286178055L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		String userId = req.getParameter("loginId");
		String password = req.getParameter("password");
		
		UserService service = NamooBoardServiceFactory.getInstance().getUserService();
		LoginResult login = service.login(userId, password);
		
		if (login.isSuccess()) {
			req.getSession().setAttribute("loginUser", service.getUser(userId));
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/menu.jsp");
			dispatcher.forward(req, resp);
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/login.jsp");
			dispatcher.forward(req, resp);
		}
	}

	
}
