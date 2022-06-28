package com.pro.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.service.StudentServiceImpl;

public class DeleteStudentByRollController extends HttpServlet {

	StudentServiceImpl service = new StudentServiceImpl();

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		int roll = Integer.parseInt(req.getParameter("roll"));
		PrintWriter out = resp.getWriter();
		
		if (service.deleteStudent(roll))
			out.print("Student information deleted successfully!!!");
		else
			out.print("failed to delete Student information!!!");
	}
}
