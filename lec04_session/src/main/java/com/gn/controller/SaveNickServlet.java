package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/saveNick")
public class SaveNickServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SaveNickServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("nickName");
		Cookie c = new Cookie("user_name",userName);
		// 2. 쿠키 유지 시간 설정(초 단위)
		c.setMaxAge(60 * 60); // 1시간 유지
		
		// 3. 응답에 쿠키 추가하여 브라우저에 전달
		response.addCookie(c);
		
		response.sendRedirect("/practiceCookie");
	}

}
