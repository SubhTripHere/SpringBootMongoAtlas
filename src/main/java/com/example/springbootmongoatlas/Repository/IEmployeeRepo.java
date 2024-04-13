package com.example.springbootmongoatlas.Repository;

import com.example.springbootmongoatlas.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee,Integer> {
}
