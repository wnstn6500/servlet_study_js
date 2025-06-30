package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import com.gn.dto.Book;


@WebServlet("/searchBook")
public class SearchBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SearchBookServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Book> list = new ArrayList<Book>();
		list.add(new Book(1, "자바의 정석", "김철수"));
		list.add(new Book(2, "스프링 입문", "이순신"));
		list.add(new Book(3, "MySQL 실습", "홍길동"));
		list.add(new Book(4, "웹 개발 가이드", "유관순"));
		
		String bookName = request.getParameter("bookName");
		
		JSONObject obj = new JSONObject();
		
		for(Book b : list) {
			if(b.getBookName().equals(bookName)) {
				obj.put("bookNo",b.getBookNo());
				obj.put("bookName",b.getBookName());
				obj.put("author",b.getAuthor());
			}
		}
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(obj);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
