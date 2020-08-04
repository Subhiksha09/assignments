package com.capg.validation;

import java.time.LocalDate;
import java.util.List;

import com.capg.beans.Employee;

public interface EmployeeValidation {
	
	public boolean validateEmployeeId(String employeeId);
	public boolean validateSalary(double salary);
	public boolean validateEmployeeName(String employeeName);
	public boolean validateJoiningDate(LocalDate joinDate);
	
	public void createEmployee(Employee emp);
	public List<Employee> getEmployees(); 

}
