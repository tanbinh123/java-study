package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEx extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//web.xml에 데이터 설정하고 받아오기
		String adminId = getServletConfig().getInitParameter("adminId");
		String adminPw = getServletConfig().getInitParameter("adminPw");
		
		PrintWriter out = response.getWriter();
		
		out.print("<p>adminId : "+adminId+"</p>");
		out.print("<p>adminPw : "+adminPw+"</p>");
		
		String imgDir = getServletContext().getInitParameter("imgDir");
		String testServerIP = getServletContext().getInitParameter("testServerIP");
		
		
		
		//set.get 으로 데이터 설정하고 넘기기
		out.print("<p>imgDir : "+imgDir+"</p>");
		out.print("<p>testServerIP : "+testServerIP+"</p>");
		
		getServletContext().setAttribute("connectedIP", "165.62.58.33");
		getServletContext().setAttribute("connectedUser", "gildong");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
