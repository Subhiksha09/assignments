package com.capg.dao;

import java.util.HashSet;
import java.util.List;

import com.capg.beans.Employee;

public interface EmployeeDao {
	
	public void createEmployee(Employee employee);
	public List<Employee> getEmployees();

}