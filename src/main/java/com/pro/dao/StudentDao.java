package com.pro.dao;

import java.util.List;

import com.pro.entities.StudentEntity;


public interface StudentDao {
	
	public boolean createStudent(StudentEntity std);
	
	public StudentEntity getStudentByRoll(int roll);
	
	public List<StudentEntity> getAllStudents();
	
	public boolean updateStudent(int roll, StudentEntity std);
	
	public boolean deleteStudent(int roll);

}