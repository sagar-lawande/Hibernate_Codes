package app;

import java.util.ArrayList;
import java.util.List;

import controller.Controller;
import entity.Students;

public class Test {
	
	public static void main(String[]args) {
	
	List<Students> std=new ArrayList<>();
	std.add(new Students("sagar","Bhusawal",101,"Java"));
	std.add(new Students("rahul","Nashik",102,"Java"));
	std.add(new Students("jay","Bhusawal",103,"Python"));
	std.add(new Students("kiran","Thane",104,"Java"));
	std.add(new Students("sahil","Yaval",105,"Java"));
	std.add(new Students("nikhil","Bhusawal",312,"Java"));
	std.add(new Students("atul","Nashik",132,"C++"));
	std.add(new Students("rushi","Bhusawal",342,"C++"));
	std.add(new Students("pavan","Bhusawal",322,"Java"));
	std.add(new Students("gaurav","Pune",232,"Java"));
	std.add(new Students("lalit","Nashik",320,"Java"));
	std.add(new Students("Pratap","Thane",312,"Python"));
	
	
	Controller c=new Controller();
	c.addData(std);
	
	System.out.println("----------------------------------------------------");
	c.getData(std);
	
	System.out.println("----------------------------------------------------");
	c.restrictionUsingCriteriaAPI(std);
	

	System.out.println("----------------------------------------------------");
	c.restrictionUsingJPA();
	
	System.out.println("--------*******---------*********--------*******---------");
	
	
	System.out.println("--------@@@@@@@@@@--------@@@@@@@@--------@@@@@@@@---------");

	c.projectionUsingCriteriaAPI();
	
	System.out.println("--------@@@@@@@@@@--------@@@@@@@@--------@@@@@@@@---------");
	c.projectionUsingJPA();
	
	
	
	
	}
}
	

