package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.gn.dto.Account;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String correctId = "admin";
		String correctPw = "admin1234";
		String name = "관리자";
		
		Account account = new Account(correctId,name);
		
		String Id = request.getParameter("id");
		String Pw = request.getParameter("pw");
		
		if(Id.equals(correctId) && Pw.equals(correctPw)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("account",account);
			session.setMaxInactiveInterval(60*60);
		} else {
		}
		response.sendRedirect("/");
		
	}

}
