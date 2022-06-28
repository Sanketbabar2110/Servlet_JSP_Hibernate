package com.pro.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.pro.entities.StudentEntity;

public class StudentDaoImpl implements StudentDao {

	SessionFactory factory = HibernateUtil.getSessionFactory();

	@Override
	public boolean createStudent(StudentEntity std) {
		Session session = null;
		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();

			session.save(std);

			session.flush();
			tx.commit();
			System.out.println("Student record saved to DB successfully!!!");

			return true;

		} catch (Exception e) {
			System.out.println("Unable to store Student record to DB!!! ");
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}

	}

	@Override
	public StudentEntity getStudentByRoll(int roll) {

		StudentEntity entity = new StudentEntity();
		Session session = null;

		String hql = "from StudentEntity student where student.roll=:roll";
		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();

			Query<StudentEntity> query = session.createQuery(hql);
			query.setParameter("roll", roll);
			entity = query.uniqueResult();
			
			tx.commit();
			System.out.println("Student record fatched from DB Successfully!!!");
			return entity;

		} catch (Exception e) {
			System.out.println("Unable to fach Student record from DB!!!");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<StudentEntity> getAllStudents() {

		List<StudentEntity> list = new ArrayList<>();
		Session session = null;

		String hql = "from StudentEntity";

		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();

			Query<StudentEntity> query = session.createQuery(hql);
			list = query.list();

			tx.commit();
			System.out.println("Record fached from database successfully!!!");
			return list;

		} catch (Exception e) {
			System.out.println("Unable to fach Student records from DB!!!");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean updateStudent(int roll, StudentEntity entity) {
		
		Session session = null;
		String hql = "UPDATE StudentEntity  SET name=:name, address=:address where roll=:roll";
				
		try{
			session = factory.openSession();
			Transaction tx = session.beginTransaction();
			
			Query<StudentEntity> query = session.createQuery(hql);
			
			query.setParameter("name", entity.getName());
			query.setParameter("address", entity.getAddress());
			query.setParameter("roll", roll);
			
			query.executeUpdate();
			
			return true;
		}catch(Exception e) {
			
			System.out.println("unable to update student in database!!!");
			e.printStackTrace();
			return false;
			
		}finally {
			session.close();
		}
	}

	@Override
	public boolean deleteStudent(int roll) {

		Session session = null;
		String sql = "DELETE FROM student WHERE roll=" + roll;

		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();

			SQLQuery query = session.createSQLQuery(sql);

			query.executeUpdate();

			tx.commit();

			return true;

		} catch (Exception e) {
			System.out.println("Unable to delete student records from DB!!!");
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}
}
