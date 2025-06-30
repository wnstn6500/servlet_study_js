package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/removeNick")
public class RemoveNickServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RemoveNickServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 삭제하고 싶은 쿠키와 같은 key로 쿠키 생성
				
				// 2. 유효시간 0으로 설정
		
				Cookie c = new Cookie("user_name","");
				c.setMaxAge(0);
				// 3. 응답에 추가
				response.addCookie(c);
				// 4. 새로운 요청 발생
				response.sendRedirect("/practiceCookie");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
