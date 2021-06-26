package com.ashok.hibernate.demo.java;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ashok.hibernate.demo.entity.Student;

public class QueryStudentDemo {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			//List<Student> theStudents = session.createQuery("from Student").list();
			//List<Student> theStudents = session.createQuery("from Student where firstName='Sachit'").list();
			List<Student> theStudents = session.createQuery("from Student s where"+" s.firstName='Sachit' OR s.lastName='Jha' ").list();
			for (Student tempStudent : theStudents) {
				System.out.println(tempStudent);
			}
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

}
