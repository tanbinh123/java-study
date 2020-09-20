package com.servletform.www;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mSignUp")
public class MemSignUp extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		System.out.println(" -- doGet() -- ");
		
		String m_name = request.getParameter("m_name");
		String m_pass = request.getParameter("m_pass");
		String m_gender = request.getParameter("m_gender");
		String[] m_hobbys = request.getParameterValues("m_hobby");
		String m_residence = request.getParameter("m_residence");
		
		
		//브라우저
		out.println("m_name : " + m_name);
		out.println("m_pass : " + m_pass);
		out.println("m_gender : " + m_gender);
		out.println("m_hobbys : " + Arrays.toString(m_hobbys));
		out.println("m_residence : " + m_residence);
		
		//콘솔
		System.out.println("m_name : " + m_name);
		System.out.println("m_pass : " + m_pass);
		System.out.println("m_gender : " + m_gender);
		System.out.println("m_hobbys : " + Arrays.toString(m_hobbys));
		System.out.println("m_residence : " + m_residence);
		
		response.sendRedirect("resultPage.jsp");
		
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			System.out.println("name : " + name);
		}
		
	}
		
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(" -- doPost() -- ");
		
		doGet(request, response);
	}

}
