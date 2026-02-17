package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Data")
public class Students {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private String address;
	@Column
	private int rollNo;
	@Column
	private String course;
	
	
	
	public Students(String name, String address, int rollNo, String course) {
		super();
		this.name = name;
		this.address = address;
		this.rollNo = rollNo;
		this.course = course;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
