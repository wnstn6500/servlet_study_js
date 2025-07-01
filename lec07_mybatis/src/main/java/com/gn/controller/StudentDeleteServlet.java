package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.gn.dto.Student;
import com.gn.service.StudentService;


@WebServlet("/student/delete")
public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService service = new StudentService();
       
   
    public StudentDeleteServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int studentNo = Integer.parseInt(request.getParameter("no"));
		
		int result = service.deleteStudent(studentNo);
		
		if(result>0) {
			response.sendRedirect("/student/list");
		} else {
			response.sendRedirect("/student/delete");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
