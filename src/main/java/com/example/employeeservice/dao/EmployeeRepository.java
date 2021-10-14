package com.example.employeeservice.dao;

import com.example.employeeservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByDept(String dept);
}
