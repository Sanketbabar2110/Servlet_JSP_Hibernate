package com.pro.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.model.StudentModel;
import com.pro.service.StudentService;
import com.pro.service.StudentServiceImpl;

public class CreateStudentController extends HttpServlet{
	
	StudentService service = new StudentServiceImpl();
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		StudentModel model = new StudentModel();
		
		model.setName(req.getParameter("name"));
		model.setRoll(Integer.parseInt(req.getParameter("roll")));
		model.setAddress(req.getParameter("address"));
		PrintWriter out = res.getWriter();
		if (service.createStudent(model)) {
			out.println("Student record created successfully ");
		}
		else
			out.println("Unable to store student record!!!");
			
	}

}
