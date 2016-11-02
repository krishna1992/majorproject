package com.cybage.resourcemanagement.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@Table(name="student")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int rollno;

	@Column(name="city")
	private String city;

	@Column(name="firstname")
	private String firstname;

	@Column(name="lastname")
	private String lastname;

	@Column(name="marks")
	private double marks;

	public Student() {
	}

	public int getRollno() {
		return this.rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public double getMarks() {
		return this.marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

}