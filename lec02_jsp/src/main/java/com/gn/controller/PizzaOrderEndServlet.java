package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/pizzaOrderEnd")
public class PizzaOrderEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PizzaOrderEndServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userName = request.getParameter("user_name");
		String userPhone = request.getParameter("user_phone");
		String userEmail = request.getParameter("user_email");
		String size = request.getParameter("size");

		String deliveryTime = request.getParameter("delivery_time");
		
		System.out.println(userName);
		System.out.println(userPhone);
		System.out.println(userEmail);
		System.out.println(size);
		
		System.out.println(deliveryTime);
		
		
		String pizzaSize = "";
		int price = 0;
		
		switch(size) {
		case "1":
			pizzaSize = "Small";
			price = 15900;
			break;
		case "2":
			pizzaSize = "Medium";
			price = 21000;
			break;
		case "3":
			pizzaSize = "Large";
			price = 27900;
			break;	
		}
		
		
		
		String[] toppings = request.getParameterValues("topping");
		
		if(toppings != null) {
			
			String[] toppingsName = new String[toppings.length];
			for (int i = 0; i < toppings.length; i++) {
				switch(toppings[i]) {
				case"1":
					toppingsName[i] = "새우";
					price += 2000;
					break;
				case"2":
					toppingsName[i] = "고구마";
					price += 1000;
					break;
				case"3":
					toppingsName[i] = "감자";
					price += 1000;
					break;
				case"4":
					toppingsName[i] = "파인애플";
					price += 1000;
					break;	
					
				}
			}
			request.setAttribute("toppings", toppingsName);
			
		}
		
		
		
		
		
		
		
		
		request.setAttribute("userName", userName);
		request.setAttribute("userPhone", userPhone);
		request.setAttribute("userEmail", userEmail);
		request.setAttribute("size", pizzaSize);
		request.setAttribute("pizzaPrice", price);
		request.setAttribute("deliveryTime", deliveryTime);
		
		RequestDispatcher view 
		= request.getRequestDispatcher("views/pizza/result.jsp");
	view.forward(request, response);
	}

}
