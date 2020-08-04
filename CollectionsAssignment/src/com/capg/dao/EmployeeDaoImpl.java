package com.capg.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.capg.beans.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	
	List<Employee> employees = new ArrayList<Employee>();

	@Override
	public void createEmployee(Employee employee) {
		employees.add(employee);
		System.out.println("Employee details are created");
		
	}

	public List<Employee> getEmployees() {
		return employees;
	}

}