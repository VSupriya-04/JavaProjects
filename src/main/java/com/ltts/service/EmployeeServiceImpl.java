package com.ltts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltts.dao.EmployeeDao;
import com.ltts.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public String addEmployee(Employee employee) {
		return employeeDao.addEmployee(employee);
	}

	@Override
	public Employee getEmployee(int id) {
		return employeeDao.getEmployee(id);
	}

	@Override
	public Employee loginEmployee(String email, String password) {
		return employeeDao.loginEmployee(email, password);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public String updatePassword(String newPassword, String email, String oldPassword) {
		return employeeDao.updatePassword(newPassword, email, oldPassword);
	}

	@Override
	public String deleteEmployee(int id) {
		return employeeDao.deleteEmployee(id);
	}

	@Override
	public String updateSalary(double salary, String email) {
		return employeeDao.updateSalary(salary, email);
	}

	@Override
	public List<Employee> findByNameContaining(String name) {
		return employeeDao.findByNameContaining(name);
	}

	@Override
	public List<Employee> findBySalaryGreaterThanEqual(double salary) {
		return employeeDao.findBySalaryGreaterThanEqual(salary);
	}

}
