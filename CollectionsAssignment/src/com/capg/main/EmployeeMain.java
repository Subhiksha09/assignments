package com.capg.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.capg.beans.Address;
import com.capg.beans.Department;
import com.capg.beans.Employee;
import com.capg.validation.EmployeeValidation;
import com.capg.validation.EmployeeValidationImpl;

public class EmployeeMain {
	
	public static void main(String[] args) {
		
		
		EmployeeValidation service = new EmployeeValidationImpl();
		Employee employee = null;
		Department department = null;
		Set <Address> address = new HashSet <Address>();
		Scanner sc = new Scanner(System.in); 
		
		while(true) {
			
			System.out.println("1. To create an Employee");
			System.out.println("2. Sort By EmployeeId");
			System.out.println("3. Sort By FirstName");
			System.out.println("4. Sort By LastName");
			System.out.println("5. Sort By Address");
			System.out.println("6. Sort By Department");
			System.out.println("7. Sort By Salary");
			System.out.println("8. Exit");
			
			switch(sc.nextInt()) {
			case 1 :
				System.out.println("Enter employeeId : ");
				
				String employeeId = sc.next();
				
				if(service.validateEmployeeId(employeeId)) {
					employee = new Employee();
					employee.setEmployeeId(employeeId);
				}else {
					System.out.println("Invalid employee Id");
					break;
				}
				
				System.out.println("Enter FirstName : ");
				
				String firstName = sc.next();
				
				if(service.validateEmployeeName(firstName)) {
					employee.setFirstName(firstName);
				}else {
					System.out.println("Invalid FirstName ");
					break;
				}
				
				System.out.println("Enter LastName : ");
				
				String lastName = sc.next();
				
				if(service.validateEmployeeName(lastName)) {
					employee.setLastName(lastName);
				}else {
					System.out.println("Invalid Last Name ");
					break;
				}
				
				System.out.println("Enter salary between 20000 to 500000) : ");
				
				double salary = sc.nextDouble();
				
				if(service.validateSalary(salary)) {
					employee.setSalary(salary);
				}else {
					System.out.println("Invalid range of salary amount");
					break;
				}
				
				System.out.println("Enter the no. of address");
				
				int num = sc.nextInt();
				address = new HashSet<Address>(num);
				
				for(int i=0; i<num; i++) {
					
					Address add = new Address();
					System.out.println("Enter addressId : ");
					add.setAddressId(sc.nextInt());
					System.out.println("Enter address line1 : ");
					add.setAddressLine1(sc.next());
					System.out.println("Enter city : ");
					add.setCity(sc.next());
					System.out.println("Enter state : ");
					add.setState(sc.next());
					address.add(add);
				}
				employee.setAddress(address);
				service.createEmployee(employee);
				break;
				
				department = new Department();
				System.out.println("Enter department Id : ");
				int departmentId = sc.nextInt();
				department.setDepartmentId(departmentId);
				System.out.println("Enter department name : ");
				department.setDepartmentName(sc.next());
				System.out.println("Enter location : ");
				department.setLocation(sc.next());
				
				employee.setDepartment(department);
				
				System.out.println("Enter joining date (must be 'yyyy-MM-dd' format): ");
				
				String joiningDate =  sc.next();
				
				LocalDate joinDate = LocalDate.parse(joiningDate);
				
				if(service.validateJoiningDate(joinDate)) {
					employee.setJoiningDate(joiningDate);
				}else {
					System.out.println("Error invalid joiningDate");
					break;
				}
				
				
				
				
			case 2 : 
					System.out.println("Sort By EmployeeId :");
					Comparator<Employee> sortById = new Comparator<Employee>() {
						
						@Override
						public int compare(Employee emp1, Employee emp2) {
							return emp1.getEmployeeId().compareTo(emp2.getEmployeeId());
						}
					};
					
					Collections.sort(service.getEmployees(),sortById);
					for(Employee emp : service.getEmployees())
						System.out.println(emp);
					break;
					
			case 3 :
					System.out.println("Sort By FirstName :");
					
					Comparator<Employee> sortByName = new Comparator<Employee>() {
						
						@Override
						public int compare(Employee emp1, Employee emp2) {
							return emp1.getFirstName().compareToIgnoreCase(emp2.getFirstName());
						}
					};
					Collections.sort(service.getEmployees(),sortByName);
					for(Employee emp : service.getEmployees())
						System.out.println(emp);
					break;
					
					
			case 4 : 
					System.out.println("Sort By LastName :");
					Comparator<Employee> sortByLastName = new Comparator<Employee>() {
					
						@Override
						public int compare(Employee emp1, Employee emp2) {
							return emp1.getLastName().compareToIgnoreCase(emp2.getLastName());
						}
					};
					Collections.sort(service.getEmployees(),sortByLastName);
					for(Employee emp : service.getEmployees())
						System.out.println(emp);
					break;
			
			
			case 5 : 
					System.out.println("Sort By Address : ");
					for(Employee emp : service.getEmployees()) {
						List <Address> address = new ArrayList <Address>(address);
						Collections.sort(  emp.getAddress(), new Comparator<Address>() {
							public int compare(Address a1,Address a2) {
								return a1.getAddressId()-a2.getAddressId();
							}
						} 
						);
					}
					for(Employee emp : service.getEmployees())
						System.out.println(emp);
					break;
			
			case 6 :
					System.out.println("Sort By DepartmentId :");
					
					Comparator<Employee> sortByDeptId = new Comparator<Employee>() {
						@Override
						public int compare(Employee emp1, Employee emp2) {
							return emp1.getDepartment().getDepartmentId() - emp2.getDepartment().getDepartmentId();
						}
					};
					
					Collections.sort(service.getEmployees(), sortByDeptId);
					
					for(Employee emp : service.getEmployees())
						System.out.println(emp);
					
					System.out.println("Sort By Department Name in ascnding order :");
					Comparator<Employee> sortByDeptName = new Comparator<Employee>() {
						
						@Override
						public int compare(Employee emp1, Employee emp2) {
							return emp1.getDepartment().getDepartmentName().compareToIgnoreCase(emp2.getDepartment().getDepartmentName());
						}
					};
					Collections.sort(service.getEmployees(), sortByDeptName);
					for(Employee emp : service.getEmployees())
						System.out.println(emp);
					break;
					
			case 7 : 
				System.out.println("Sort By Salary highest to lowest : ");
				
				Comparator<Employee> sortBySal = new Comparator<Employee>() {
					
					public int compare(Employee emp1, Employee emp2) {
						if(emp1.getSalary() < emp2.getSalary())
							return 1;
						else if(emp1.getSalary() > emp2.getSalary())
							return -1;
						else
							return 0;
					}
				};
				
				Collections.sort(service.getEmployees(), sortBySal);
				
				for(Employee emp : service.getEmployees())
					System.out.println(emp);
				break;
				
			
			case 8 : 
					System.out.println("Thank You");
					break;
			}		
		}
		

	}

}
