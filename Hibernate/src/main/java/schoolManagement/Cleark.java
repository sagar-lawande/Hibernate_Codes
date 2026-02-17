package schoolManagement;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public  class Cleark{
	
	public void insertData(Students std) {
		System.out.println("Method for Insert Data");
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		
		session.save(std);
		
		transaction.commit();
		System.out.println("Data Inserted Successfully");
	}
	
	public void readData() {
		System.out.println("Method for Fetch Data");
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		Students std=session.get(Students.class,1);
		if(std!=null) {
			System.out.println(std.getId());
			System.out.println(std.getName());
			System.out.println(std.getAddress());
			System.out.println(std.getStandard());
			
			System.out.println("Data read successfully");
			
		}else {
			System.out.println("No data Found");
		}
		
		
		session.close();
	}
	
	public void updateData(int id , String address,String name) {
		System.out.println("Method for Update Data");
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction =session.beginTransaction();
		
	Students std1=session.get(Students.class,id);
	if(std1!=null) {
		std1.setAddress(address);
		std1.setName(name);
		
	}
	session.update(std1);
	transaction.commit();
	
	
	System.out.println("-----------------------------AFTER UPDATE-----------------");
	 std1=session.get(Students.class,1);
	if(std1!=null) {
		System.out.println(std1.getId());
		System.out.println(std1.getName());
		System.out.println(std1.getAddress());
		System.out.println(std1.getStandard());
		
		System.out.println("Data read successfully");
		
	}else {
		System.out.println("No data Found");
	}
	
	session.close();
	
		
	}
	
	public void deleteData(Students std) {
		System.out.println("Method for Delete Data");
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction =session.beginTransaction();
		std=session.get(Students.class,1);
		
		if(std!=null) {
			session.delete(std);
			
			System.out.println("Delete Successfully");
		}else {
			System.out.println("Not Deleted .....Data Not exists");
		}
		transaction.commit();
		session.close();
	}
	
}