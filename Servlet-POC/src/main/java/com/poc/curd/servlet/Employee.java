package com.poc.curd.servlet;

public class Employee {
	private int employee_Id;
	private String firstName;	
	private String lastName;	
	private String email;
	
	
	
	public Employee(int employee_Id, String firstName, String lastName, String email) {
		super();
		this.employee_Id = employee_Id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public int getEmployee_Id() {
		return employee_Id;
	}
	public void setEmployee_Id(int employee_Id) {
		this.employee_Id = employee_Id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	

}
