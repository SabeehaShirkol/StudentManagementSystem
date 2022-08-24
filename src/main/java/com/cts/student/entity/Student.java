package com.cts.student.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sId;
	
	private String firstName;
	
	private String lastName;
	
	private String studentClass;
	
	private String subject;
	
	private Date dob;

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Student() {
		super();
	}

	public Student(Integer sId, String firstName, String lastName, String studentClass, String subject, Date dob) {
		super();
		this.sId = sId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentClass = studentClass;
		this.subject = subject;
		this.dob = dob;
	}
	
	
	
	
	
	
	
}
