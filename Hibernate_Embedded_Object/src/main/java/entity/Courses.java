package entity;


import javax.persistence.Column;
import javax.persistence.Embeddable;



@Embeddable
public class Courses {
	
	
	@Column
	private String courseName;
	@Column
	private String certificateNo;
	@Column
	private String duration;
	public Courses(String courseName, String certificateNo, String duration) {
		super();
		this.courseName = courseName;
		this.certificateNo = certificateNo;
		this.duration = duration;
	}
	

	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
 