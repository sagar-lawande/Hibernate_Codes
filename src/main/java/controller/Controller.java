package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import entity.Students;
import hibernateUtil.HibernateUtil;

public class Controller{
	
	public void addData(List<Students> std ) {
		System.out.println("Data Insert Method");
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		
		for(Students s:std) {
			session.save(s);
			
			
		}
		System.out.println("Data Inserted Sucessfully");
		transaction.commit();
	}
	
	public void getData(List<Students> std) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		session.createQuery("from Students",Students.class).list();//using HQL Query 
		for(Students s:std) {
			     
			System.out.println(
	                s.getId() + " | " +
	                		
	                s.getName() + " | " +
	                s.getCourse() + " | " +
	                s.getAddress() + " | " +
	                s.getRollNo()
	            );	
		}
		}
	
	public void restrictionUsingCriteriaAPI(List<Students>std) {
		System.out.println("<<<<< Use Of RESTRICTION USING CRITERIA API >>>>");
		Session session =HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		Criteria criteria=session.createCriteria(Students.class);//THis API Is Deprecated so use JPA Criteria API
		criteria.add(Restrictions.eq("address","Bhusawal"));
		List<Students>std1=criteria.list();
		for(Students s:std1){
		     
			System.out.println(
	                s.getId() + " | " +
	                		
	                s.getName() + " | " +
	                s.getCourse() + " | " +
	                s.getAddress() + " | " +
	                s.getRollNo()
	            );	
		}
		
	}
	
	public void restrictionUsingJPA() {
		System.out.println("<<<<<<<<<<<  Restriction using JPA Criteria Builder API  >>>>>>>>>>.");
		Session session =HibernateUtil.getSessionFactory().openSession();
		Transaction transaction =session.beginTransaction();
		EntityManager em=session.getEntityManagerFactory().createEntityManager();
		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaQuery<Students> cq = cb.createQuery(Students.class);
		Root<Students> root=cq.from(Students.class);
		cq.select(root).where(cb.equal(root.get("address"),"Nashik"));
		List<Students> std=em.createQuery(cq).getResultList();
		for(Students s:std) {
			System.out.println(
	                s.getId() + " | " +
	                		
	                s.getName() + " | " +
	                s.getCourse() + " | " +
	                s.getAddress() + " | " +
	                s.getRollNo()
	            );	
			
		}
		
		
	}
         public void projectionUsingCriteriaAPI() {
        	 System.out.println("PPROJECTION Using  Criteria API");
        	 Session session=HibernateUtil.getSessionFactory().openSession();
        	 Transaction transaction =session.beginTransaction();
        	 Criteria criteria = session.createCriteria(Students.class);

        	 ProjectionList plist = Projections.projectionList();
        	 plist.add(Projections.property("name"));
        	 plist.add(Projections.property("course"));

        	 criteria.setProjection(plist);

        	 List<Object[]> list = criteria.list();

        	 for (Object[] row : list) {
        	     System.out.println(
        	         "Name: " + row[0] +
        	         " | Course: " + row[1]
        	     );
        	 }

        	 
        	 
     		}
         
         public void projectionUsingJPA() {
        	 System.out.println("Projection using JPA API");
        	 Session session =HibernateUtil.getSessionFactory().openSession();
        	 Transaction transaction =session.beginTransaction();
        	 EntityManager em=session.getEntityManagerFactory().createEntityManager();
        	 CriteriaBuilder cb=em.getCriteriaBuilder();
        	 CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        	 Root<Students> root = cq.from(Students.class);

        	    // PROJECTION (name, course)
        	    cq.multiselect(
        	            root.get("name"),
        	            root.get("address")
        	    );

        	    List<Object[]> result = em.createQuery(cq).getResultList();

        	    for (Object[] row : result) {
        	        System.out.println(
        	                "Name : " + row[0] +
        	                " | Address : " + row[1]
        	        );
        	    }

        	    em.close();
        	}
        	 
        	 
        
         }
     		
     	
        	 
         
		
	
