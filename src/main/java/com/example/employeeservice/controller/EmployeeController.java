package com.example.employeeservice.controller;

import com.example.employeeservice.dao.EmployeeRepository;
import com.example.employeeservice.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    public EmployeeRepository repository;
    @PostMapping("/saveEmployee")
    public String saveEmployee(@RequestBody Employee employee){
        repository.save(employee);
        return "Employee saved successfully...";
    }
    @GetMapping("/getAllEmployee")
    public List<Employee>getAll(){

        return repository.findAll();
    }
    @GetMapping("/getEmployee/{dept}")
    public List<Employee>getEmployeeDept(@PathVariable String dept){
        return repository.findAllByDept(dept);
    }
}
