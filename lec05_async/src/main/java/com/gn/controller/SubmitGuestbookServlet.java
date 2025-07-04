package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

import org.json.simple.JSONObject;


@WebServlet("/submitGuestbook")
public class SubmitGuestbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public SubmitGuestbookServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		
		
		
		response.setContentType("application/json;charset=UTF-8");
		
		
		JSONObject input = new JSONObject();
		input.put("name", name);
		input.put("message", message);
		
		response.getWriter().print(input);
		
		
		
		
		
	}

}
