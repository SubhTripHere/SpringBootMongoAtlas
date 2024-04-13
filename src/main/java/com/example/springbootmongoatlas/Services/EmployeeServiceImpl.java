package com.example.springbootmongoatlas.Services;

import com.example.springbootmongoatlas.Entities.Employee;
import com.example.springbootmongoatlas.Repository.IEmployeeRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class EmployeeServiceImpl implements EmployeeServiceI{

    @Autowired
    public IEmployeeRepo employeeRepo;

    public EmployeeServiceImpl(IEmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public void saveEmployee(Employee employee) {
        System.out.println("Saving employee"+employee.toString());

        employeeRepo.save(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> employee=employeeRepo.findById(id);
        return employee.orElse(null);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee updateEmployeeById(int id, Employee employee) {
        Optional<Employee> emp=employeeRepo.findById(id);
        Employee employee1=new Employee();
        if(emp.isPresent()){
            employee1=emp.get();
            employee1.setAge(employee.getAge());
            employee1.setAddress(employee.getAddress());
            employee1.setAge(employee.getAge());
        }
        employeeRepo.save(employee1);
        return employee1;
    }

    @Override
    public void deleteEmployeeById(int id){
        Optional<Employee> employee=employeeRepo.findById(id);
        System.out.println("Deleting resource");
        if(employee.isPresent())
               employeeRepo.delete(employee.get());

    }



}
