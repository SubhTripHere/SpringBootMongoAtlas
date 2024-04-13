package com.example.springbootmongoatlas.Services;


import com.example.springbootmongoatlas.Entities.Employee;
import lombok.Data;

import java.io.File;
import java.util.List;


public interface EmployeeServiceI {
    void saveEmployee(Employee employee);


    Employee getEmployeeById(int id);

    List<Employee> getAllEmployee();

    Employee updateEmployeeById(int id, Employee employee);


    void deleteEmployeeById(int id);

}
