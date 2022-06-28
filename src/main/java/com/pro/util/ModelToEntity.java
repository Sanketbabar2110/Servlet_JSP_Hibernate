package com.pro.util;

import com.pro.entities.StudentEntity;
import com.pro.model.StudentModel;

public class ModelToEntity {
	
	public static StudentEntity convertToStudentEntity(StudentModel model)
	{
		StudentEntity entity = new StudentEntity();
		
		entity.setRoll(model.getRoll());
		entity.setName(model.getName());
		entity.setAddress(model.getAddress());
		
		return entity;
		
	}
	
	public static StudentModel convertToStudentModel(StudentEntity entity)
	{
		StudentModel model = new StudentModel();
		
		model.setRoll(entity.getRoll());
		model.setName(entity.getName());
		model.setAddress(entity.getAddress());
		
		return model;
		
	}

}