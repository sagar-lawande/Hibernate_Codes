package app;

import controllerRepo.Controller;
import entity.Courses;
import entity.Students;

public class Test {

	public static void main(String[]args) {
		System.out.println("Program for the Embeddable Object");
		
		Students std=new Students();
		Courses cs=new Courses();
		std.setName("sagar");
		std.setAddress("bhusawal");
		std.setRollNo(233);
		
		cs.setCourseName("Java");
		cs.setDuration("2_Months");
		cs.setCertificateNo("124234235");
		std.setCs(cs);
		
		
		Controller c=new Controller();
		c.addData(std);
		System.out.println("----------------------------------------------------");
		
	}
}
