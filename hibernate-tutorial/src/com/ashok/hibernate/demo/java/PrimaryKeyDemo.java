package com.ashok.hibernate.demo.java;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ashok.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			Student student = new Student("Akarsh", "Jha", "akarsh@gmail.com");
			Student student1 = new Student("Harsh", "Jha", "harsh@gmail.com");
			Student student2 = new Student("Anjali", "Rani", "anjali@gmail.com");
			Student student3 = new Student("Subbu", "kumar", "subbu@gmail.com");
			session.beginTransaction();
			session.save(student);
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}


}
