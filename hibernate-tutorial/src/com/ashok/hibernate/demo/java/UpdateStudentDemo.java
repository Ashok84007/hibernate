package com.ashok.hibernate.demo.java;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ashok.hibernate.demo.entity.Student;

public class UpdateStudentDemo {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			int studentId = 1;
			session.beginTransaction();
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("updating student ...");
			myStudent.setEmail("harsh@gmail.com");

			session.getTransaction().commit();

			// NEW CODE

			session = factory.getCurrentSession();
			session.beginTransaction();

			// update email for all students
			System.out.println("Update email for all students");

			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();

			// commit the transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

}
