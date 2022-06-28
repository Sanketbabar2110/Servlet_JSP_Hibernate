 package com.pro.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.model.StudentModel;
import com.pro.service.StudentServiceImpl;

public class GetAllStudentController extends HttpServlet{
	
	StudentServiceImpl service = new StudentServiceImpl();
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		List<StudentModel> list = service.getAllStudents(); 
		
		PrintWriter out = resp.getWriter();
		
		if(list.isEmpty())
			out.println("No Records in table");
		else {
			out.println(list);
		}
	}
}
