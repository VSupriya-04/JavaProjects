package com.ltts.service;

import java.util.List;

import com.ltts.model.Employee;

public interface EmployeeService {
	public String addEmployee(Employee employee);

	public Employee getEmployee(int id);

	public Employee loginEmployee(String email, String password);

	public List<Employee> getAllEmployees();

	public String updatePassword(String newPassword, String email, String oldPassword);
	
	public String deleteEmployee(int id);
	
	public String updateSalary(double salary,String email);
	
	public List<Employee> findByNameContaining(String name);
	
	public List<Employee> findBySalaryGreaterThanEqual(double salary);
}
