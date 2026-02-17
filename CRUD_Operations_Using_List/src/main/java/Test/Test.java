package Test;

import java.util.ArrayList;
import java.util.List;

import Controller.EmployeeController;
import Employee.Employee;

public class Test {
	
	public  static void main(String[]args) {
		System.out.println("Program for the HIBERNATE CRUD Operations Using LIST and ArrayList ");
		EmployeeController ec=new EmployeeController();
		
		List<Employee> empList = new ArrayList<>();

		empList.add(new Employee("Sakshi", "Developer", 21324, "Pune"));
		empList.add(new Employee("Rahul", "Tester", 19800, "Mumbai"));
		empList.add(new Employee("Amit", "Backend Developer", 35000, "Bangalore"));
		empList.add(new Employee("Neha", "HR", 28000, "Delhi"));
		empList.add(new Employee("Priya", "UI Developer", 30000, "Pune"));
		empList.add(new Employee("Rohit", "DevOps Engineer", 45000, "Hyderabad"));
		empList.add(new Employee("Anjali", "Business Analyst", 40000, "Noida"));
		empList.add(new Employee("Kunal", "Full Stack Developer", 50000, "Indore"));
		empList.add(new Employee("Sneha", "QA Engineer", 27000, "Nagpur"));
		empList.add(new Employee("Vikas", "Team Lead", 60000, "Chennai"));

		
		ec.insertEmp(empList);
		
		ec.readEmployee();
		
		
		ec.updateEmp(1,"FRONT-END-DEVELOPER");
		
		System.out.println("--------------------AFTER ROLE UPDATE-------------------------------");
		
		ec.readEmployee();
		System.out.println("------------------------------------------------------------------------");
		ec.deleteEmp(4, "Neha");
		System.out.println("------------------------------After Deleted----------------------------------");
	    ec.readEmployee();
	    System.out.println("************************************************************");
	    ec.restriction();
	    System.out.println("restriction done");
	}

}
