package com.capg.beans;

import java.time.LocalDate;
import java.util.HashSet;

public class Employee {
	
	private String employeeId;
	private String firstName;
	private String lastName;
	private double salary;
	private LocalDate joiningDate;
	
	private Department department;
	private HashSet<Address> address;
	
	
	public Employee() {
		super();
	}
	
	
	public Employee(String employeeId, String firstName, String lastName, double salary, LocalDate joiningDate,
			HashSet<Address> address, Department department) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.joiningDate = joiningDate;
		this.address = address;
		this.department = department;
	}
	
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public HashSet<Address> getAddress() {
		return address;
	}
	public void setAddress(HashSet <Address> address) {
		this.address = address;
	}
	
	
	@Override
	public String toString() {
		return "Employee [empId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ ", joiningDate+=" + joiningDate + ", address=" + address + ", department=" + department + "]";
	}
	

}
