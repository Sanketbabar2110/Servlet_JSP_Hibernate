package com.pro.service;

import java.util.ArrayList;
import java.util.List;

import com.pro.dao.StudentDao;
import com.pro.dao.StudentDaoImpl;
import com.pro.entities.StudentEntity;
import com.pro.model.StudentModel;
import com.pro.util.ModelToEntity;

public class StudentServiceImpl implements StudentService {

	StudentDao stdDao = new StudentDaoImpl();

	@Override
	public boolean createStudent(StudentModel std) {

		return stdDao.createStudent(ModelToEntity.convertToStudentEntity(std));
	}

	@Override
	public StudentModel getStudentByRoll(int roll) {

		StudentEntity entity = stdDao.getStudentByRoll(roll);

		if (entity != null)
			return ModelToEntity.convertToStudentModel(entity);
		else
			return null;
	}

	@Override
	public List<StudentModel> getAllStudents() {

		List<StudentEntity> listE = stdDao.getAllStudents();
		List<StudentModel> listM = new ArrayList<>();

		if (listE.isEmpty())
			return null;
		else {
			for (StudentEntity entity : listE) {
				listM.add(ModelToEntity.convertToStudentModel(entity));
			}
			return listM;
		}
	}

	@Override
	public boolean updateStudent(int roll, StudentModel model) {
	
		return stdDao.updateStudent(roll, ModelToEntity.convertToStudentEntity(model));
	}

	@Override
	public boolean deleteStudent(int roll) {
	
		return stdDao.deleteStudent(roll);
	}
}
