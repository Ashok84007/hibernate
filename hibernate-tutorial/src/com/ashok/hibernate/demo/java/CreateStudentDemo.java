package com.ashok.hibernate.demo.java;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ashok.hibernate.demo.entity.Student;

public class CreateStudentDemo {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			Student student = new Student("Sachit", "Jha", "sachit@gmail.com");
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

}
