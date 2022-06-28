package com.pro.service;

import java.util.List;

import com.pro.model.StudentModel;

public interface StudentService {
	
	public boolean createStudent(StudentModel std);
	
	public StudentModel getStudentByRoll(int roll);
	
	public List<StudentModel> getAllStudents();
	
	public boolean updateStudent(int roll, StudentModel std);
	
	public boolean deleteStudent(int roll);

}