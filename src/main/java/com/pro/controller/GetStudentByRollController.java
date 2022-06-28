package com.pro.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.model.StudentModel;
import com.pro.service.StudentServiceImpl;

public class GetStudentByRollController extends HttpServlet {

	StudentServiceImpl service = new StudentServiceImpl();

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		int roll = Integer.parseInt(req.getParameter("roll"));

		StudentModel model = service.getStudentByRoll(roll);

		PrintWriter out = resp.getWriter();
		if (model != null)
			out.println(model);
		else
			out.println("failed to get student from database!!!");
	}

}
