package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginCon")
public class loginCon extends HttpServlet {

       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String mId = request.getParameter("mID");
		String mPw = request.getParameter("mPW");
		
		out.print("mId : "+ mId);
		out.print("mPw : "+ mPw);
		
		Cookie[] cookies = request.getCookies();
		Cookie cookie = null;
		
		for (Cookie c : cookies) {
			out.print("getName() : "+ c.getName() +"getValue() : "+ c.getValue());
			
			if(c.getName().equals("memberId")) {
				cookie = c;
			}
		}
		if(cookie == null) {
			System.out.println("cookie is null");
			cookie = new Cookie("memberId", mId);
		}
		
		response.addCookie(cookie);
		cookie.setMaxAge(60*60);
		
		response.sendRedirect("loginOK.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
