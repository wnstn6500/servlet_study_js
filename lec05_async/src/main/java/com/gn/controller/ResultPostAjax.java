package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/resultPostAjax")
public class ResultPostAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ResultPostAjax() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math = Integer.parseInt(request.getParameter("math"));
		
		int sum = (kor+eng+math);
		double avg = sum / 3.0;
		String avgStr = String.format("%.2f", avg);
		
		String passMassege;
		
		if(kor >= 40 && eng >= 40 && math >= 40 && avg >= 60) {
			passMassege = "합격";
		} else {
			passMassege = "불합격";
		}
		
		// 응답 설정
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("총점 : " +sum+"평균 : " +avgStr + "합격 여부 : "+passMassege);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
