package com.ltts.dao;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ltts.jpa.EmployeeRepository;
import com.ltts.model.Employee;

import jakarta.transaction.Transactional;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public String addEmployee(Employee employee) {
		Optional<Employee> u = employeeRepository.findById(employee.getId());
		if (u.isEmpty()) {
			Optional<Employee> u1 = employeeRepository.findByEmail(employee.getEmail());
			if (u1.isEmpty()) {
				String encrptedPassword = hashPassword(employee.getPassword());
				employee.setPassword(encrptedPassword);
				employeeRepository.save(employee);
				return "Done";
			}
			return "Exist";
		}
		return "Exist";
	}

	@Override
	public Employee getEmployee(int id) {
		Optional<Employee> u = employeeRepository.findById(id);
		if (u.isPresent()) {
			return u.get();
		}
		return null;
	}

	@Override
	public Employee loginEmployee(String email, String password) {
		Optional<Employee> u = employeeRepository.findByEmail(email);
		if (u.isPresent()) {
			if (checkPass(password, u.get().getPassword()))
				return u.get();
		}
		return null;
	}

	@Override
	public String hashPassword(String plainTextPassword) {
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}

	@Override
	public boolean checkPass(String plainPassword, String hashedPassword) {
		return BCrypt.checkpw(plainPassword, hashedPassword);

	}

	@Override
	public List<Employee> getAllEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}

	@Transactional
	@Override
	public String updatePassword(String newPassword, String email, String oldPassword) {
		Optional<Employee> u = employeeRepository.findByEmail(email);
		if (u.isPresent()) {
			if (checkPass(oldPassword, u.get().getPassword())) {
				String encrptedPassword = hashPassword(newPassword);
				int nor = employeeRepository.updatePassword(encrptedPassword, email);
				if (nor > 0) {
					return "Password Changed";
				} else {
					return "Unable to change Password!";
				}
			} else {
				return "Old Password not matched!";
			}
		}
		return "Something went wrong!";
	}

	@Transactional
	@Override
	public String deleteEmployee(int id) {
		Optional<Employee> u = employeeRepository.findById(id);
		if (u.isPresent()) {
			int nor = employeeRepository.deleteEmployee(id);
			if (nor > 0) {
				return "Employee Deleted";
			}
			return "Employee Cannot be deleted";
		}
		return "Something went wrong";
	}

	@Override
	@Transactional
	public String updateSalary(double salary, String email) {
		Optional<Employee> u = employeeRepository.findByEmail(email);
		if (u.isPresent()) {
			int nor = employeeRepository.updateSalary(salary, email);
			if (nor > 0) {
				return "Salary Updated";
			}
			return "Not updated";
		}
		return "Something went wrong!";
	}

	@Override
	public List<Employee> findByNameContaining(String name) {
		return employeeRepository.findByNameContaining(name);
	}

	@Override
	public List<Employee> findBySalaryGreaterThanEqual(double salary) {
		return employeeRepository.findBySalaryGreaterThanEqual(salary);
	}

}
