package com.student.project.infotech;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "student1")
public class Student {
	
	@Id 
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rollno " )
	private  Integer rollno;
	@Column(name = "firstname")
	private String firstname;
	@Column(name = "lastname")
	private String lastname;
	@Column(name = "math")
	private Float math;
	@Column(name = "science")
	private Float science;
	@Column(name = "chem" )
	private Float chem;
	@Column(name = "marks")
	private double marks;
	@Column(name = "contno")
	private String contno;
	@Column(name = "age")
	private int age;
	@Column(name = "percent")
	private double percent;
	
	
	
	
	
	public Student(Integer rollno, String firstname, String lastname, float math, float science, float chem,
			double marks, String contno, int age, double percent) {
		super();
		this.rollno = rollno;
		this.firstname = firstname;
		this.lastname = lastname;
		this.math = math;
		this.science = science;
		this.chem = chem;
		this.marks = marks;
		this.contno = contno;
		this.age = age;
		this.percent = percent;
	}



	public Integer getRollno() {
		return rollno;
	}



	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public Float getMath() {
		return math;
	}



	public void setMath(Float math) {
		this.math = math;
	}



	public Float getScience() {
		return science;
	}



	public void setScience(Float science) {
		this.science = science;
	}



	public Float getChem() {
		return chem;
	}



	public void setChem(Float chem) {
		this.chem = chem;
	}



	public double getMarks() {
		return marks;
	}



	public void setMarks(double marks) {
		this.marks = marks;
	}



	public String getContno() {
		return contno;
	}



	public void setContno(String contno) {
		this.contno = contno;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public double getPercent() {
		return percent;
	}



	public void setPercent(double percent) {
		this.percent = percent;
	}



	public Student() {}

}
