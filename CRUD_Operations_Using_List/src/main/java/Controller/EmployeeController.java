package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import Employee.Employee;
import HibernateUtil.HibernateUtil;
//import schoolManagement.Students;


public class EmployeeController {
	
	public void insertEmp(List<Employee> empList) {
	 
		Session session =HibernateUtil.getSessionFactory().openSession();
		Transaction transaction =session.beginTransaction();
		for (Employee e: empList) {
            session.save(e);
        }

		
		System.out.println("Data Inserted Successfully");
		transaction.commit();
		session.close();
		
		
	}
	
	public void readEmployee() {
		Session session =HibernateUtil.getSessionFactory().openSession();
		Transaction transaction =session.beginTransaction();
		List<Employee> list =
                session.createQuery("from Employee", Employee.class).list();

        for (Employee s : list) {
            System.out.println(
                s.getId() + " | " +
                		
                s.getName() + " | " +
                s.getRole() + " | " +
                s.getAddress() + " | " +
                s.getSalary()
            );
        }
        session.close();
		
		
		
	}
	
	public void updateEmp(int id , String newRole){
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		Employee emp=session.get(Employee.class,1);
		if(emp!=null) {
			emp.setRole(newRole);
			session.update(emp);
			transaction.commit();
			System.out.println("Employee Role Updated Sucessfully");
		}else {
			System.out.println("Employee id not exists Check Database...Not Updated");
		}
		session.close();
		
	}
	
	public  void deleteEmp(int id,String name) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		Employee emp=session.get(Employee.class,id);
		if(emp!=null) {
			session.delete(emp);
			transaction.commit();
			System.out.println("Employee Deleted  Sucessfully");
		}else {
			System.out.println("Employee id not exists Check Database...Not Deleted");
		}
		session.close();
		
		
		
	} 
	

	public void restriction() {
		System.out.println("Method for Restriction ");
		Session session =HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
        Criteria criteria =session.createCriteria(Employee.class);
		criteria.add(Restrictions.gt("salary",10000));
		List<Employee> list=criteria.list();
		for(Employee e:list) {
			System.out.println(e.getId() + " " + e.getName()+" "+e.getSalary());
		}
		session.close();
		
	}

}
