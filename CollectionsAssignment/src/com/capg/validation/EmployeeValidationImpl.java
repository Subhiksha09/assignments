package com.capg.validation;

import java.time.LocalDate;
import java.util.List;

import com.capg.beans.Employee;
import com.capg.dao.EmployeeDao;
import com.capg.dao.EmployeeDaoImpl;

public class EmployeeValidationImpl implements EmployeeValidation {
	

	EmployeeDao dao;
	
	public EmployeeValidationImpl() {
		dao = new EmployeeDaoImpl();
	}

	

	@Override
	public boolean validateSalary(double salary) {
		
		return (salary >= 20000 && salary <= 500000);
	}
	
	@Override
	public boolean validateEmployeeId(String employeeId) {
		
		String regex = "^[0-9]{5}_[A-Z]{2}$";
		return employeeId.matches(regex);
	}

	@Override
	public boolean validateEmployeeName(String employeeName) {
		return employeeName.matches("^[A-Za-z]{3,}$");
	}

	@Override
	public boolean validateJoiningDate(LocalDate joindate) {
		int flag = joindate.compareTo(LocalDate.now());
		return (flag>=0);
	}

	@Override
	public void createEmployee(Employee emp) {
		dao.createEmployee(emp);
		
	}
	
	public List<Employee> getEmployees(){
		return dao.getEmployees();
	}



	
}
