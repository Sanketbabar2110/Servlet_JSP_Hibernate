package com.pro.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.model.StudentModel;
import com.pro.service.StudentServiceImpl;

public class UpdateStudentController extends HttpServlet {

	StudentServiceImpl service = new StudentServiceImpl();
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		StudentModel model = new StudentModel();
		
		int roll = Integer.parseInt(req.getParameter("roll"));
		
		model.setRoll(roll);
		model.setName(req.getParameter("name"));
		model.setAddress(req.getParameter("address"));
		
		PrintWriter out = resp.getWriter();
		
		if(service.updateStudent(roll, model))
			out.print("Student record updated to database successfully!!!");
		else
			out.print("Student record update failed!!!");
	}
}
