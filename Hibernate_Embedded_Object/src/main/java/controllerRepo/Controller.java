package controllerRepo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Courses;
import entity.Students;
import hibernateUtil.HibernateUtil;

public class Controller {
	
	public void addData(Students std) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction =session.beginTransaction();
		session.save(std);
	
		transaction.commit();
		System.out.println("Data Inserted Sucessfully");
		session.close();
		
		
	}}
	
	
			    

		
	


