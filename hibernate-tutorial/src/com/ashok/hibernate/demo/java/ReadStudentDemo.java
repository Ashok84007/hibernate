package com.ashok.hibernate.demo.java;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ashok.hibernate.demo.entity.Student;

public class ReadStudentDemo {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			Student student = new Student("Sachit", "Jha", "sachit@gmail.com");
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();

		

			// now get a new session and start transactionsession =
			session = factory.getCurrentSession();
			session.beginTransaction();
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + student.getId());

			Student myStudent = session.get(Student.class, student.getId());

			System.out.println("Get complete: " + myStudent);

			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

}
