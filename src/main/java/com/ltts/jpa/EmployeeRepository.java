package com.ltts.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ltts.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	public Optional<Employee> findByEmail(String email);

	public List<Employee> findByNameContaining(String name);
	
	public List<Employee> findBySalaryGreaterThanEqual(double salary);

	@Modifying
	@Query("update Employee e set e.password=:password where e.email=:email")
	int updatePassword(@Param("password") String newPassword, @Param("email") String email);

	@Modifying
	@Query("delete Employee e where e.id=:id")
	int deleteEmployee(@Param("id") int id);

	@Modifying
	@Query("update Employee e set e.salary=:salary where e.email=:email")
	int updateSalary(@Param("salary") double salary, @Param("email") String email);

}
