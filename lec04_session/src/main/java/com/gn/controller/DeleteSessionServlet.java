package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/deleteSession")
public class DeleteSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DeleteSessionServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session != null) {
			// (1) 특정 값만 삭제
			session.removeAttribute("account");
			
			// (2) 전체 세션 종료
			session.invalidate();
		}
		
		response.sendRedirect("/");
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
