package com.shardul.springdatarest.employee.repos;

import org.springframework.data.repository.CrudRepository;

import com.shardul.springdatarest.employee.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
