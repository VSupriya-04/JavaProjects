package com.ltts.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltts.exception.ResourceNotFoundException;
import com.ltts.model.Employee;
import com.ltts.service.EmployeeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("")
	public ResponseEntity<Object> welcome() {
		return new ResponseEntity<Object>("Welcome", HttpStatus.FOUND);
	}

	@PostMapping("/add")
	public ResponseEntity<Object> addemployee(@RequestBody Employee employee) throws ResourceNotFoundException {
//		System.out.println(employee);
		LocalDate d = LocalDate.now();
//		System.out.println(d);
		employee.setJoinedOn(d);
		if (employeeService.addEmployee(employee).equals("Done")) {
			return new ResponseEntity<Object>("Employee created", HttpStatus.OK);
		} else if (employeeService.addEmployee(employee).equals("Exist")) {
			return new ResponseEntity<Object>("Employee with " + employee.getEmail() + " already exists",
					HttpStatus.OK);
		}
		throw new ResourceNotFoundException("Employee already exists");
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getemployee(@PathVariable("id") int id) throws ResourceNotFoundException {
		Employee u = employeeService.getEmployee(id);

		if (u != null) {
			u.setPassword("");
			return new ResponseEntity<Object>(u, HttpStatus.OK);
		}
		throw new ResourceNotFoundException("Employee Not found");
	}

	@PostMapping("/login")
	public ResponseEntity<Object> loginemployee(@RequestBody Employee employee) throws ResourceNotFoundException {

		Employee u = employeeService.loginEmployee(employee.getEmail(), employee.getPassword());

		if (u != null) {
			u.setPassword("************");
			return new ResponseEntity<Object>(u, HttpStatus.OK);
		}
		throw new ResourceNotFoundException("Employee Not found with these credentials");
	}

	@GetMapping("/get")
	public ResponseEntity<Object> getemployees() throws ResourceNotFoundException {
		List<Employee> employees = employeeService.getAllEmployees();

		if (!employees.isEmpty()) {

			for (Employee e : employees) {
				e.setPassword("**************");
			}

			return new ResponseEntity<Object>(employees, HttpStatus.OK);
		}
		throw new ResourceNotFoundException("Employees Not found");
	}

	@PatchMapping("/update/password")
	public ResponseEntity<Object> updatePassword(@RequestBody Map<String, String> m) throws ResourceNotFoundException {

		String res = employeeService.updatePassword(m.get("newPassword"), m.get("email"), m.get("oldPassword"));

		if (!res.equals("")) {
			return new ResponseEntity<Object>(res, HttpStatus.OK);
		}
		throw new ResourceNotFoundException("Employee Not found");
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable("id") int id) throws ResourceNotFoundException {
		String res = employeeService.deleteEmployee(id);
		if (res.equals("Employee Deleted")) {
			return new ResponseEntity<Object>(res, HttpStatus.OK);
		}
		throw new ResourceNotFoundException("Employee Not found");
	}

	@PatchMapping("/update/salary")
	public ResponseEntity<Object> updateSalary(@RequestBody Employee e) throws ResourceNotFoundException {

		String res = employeeService.updateSalary(e.getSalary(), e.getEmail());

		if (res.equals("Salary Updated")) {
			return new ResponseEntity<Object>(res, HttpStatus.OK);
		}
		throw new ResourceNotFoundException(res);
	}

	@GetMapping("/get/name/{name}")
	public ResponseEntity<Object> findByNameContaining(@PathVariable("name") String name)
			throws ResourceNotFoundException {
		List<Employee> employees = employeeService.findByNameContaining(name);

		if (!employees.isEmpty()) {

			for (Employee e : employees) {
				e.setPassword("**************");
			}

			return new ResponseEntity<Object>(employees, HttpStatus.OK);
		}

		throw new ResourceNotFoundException("No Employees found with name containing " + name);
	}

	@GetMapping("/get/salary/{salary}")
	public ResponseEntity<Object> findBySalaryGreaterThanEqual(@PathVariable("salary") double salary)
			throws ResourceNotFoundException {
		List<Employee> employees = employeeService.findBySalaryGreaterThanEqual(salary);

		if (!employees.isEmpty()) {

			for (Employee e : employees) {
				e.setPassword("**************");
			}

			return new ResponseEntity<Object>(employees, HttpStatus.OK);
		}

		throw new ResourceNotFoundException("No Employees found with salry greater than or equal to " + salary);
	}

}
