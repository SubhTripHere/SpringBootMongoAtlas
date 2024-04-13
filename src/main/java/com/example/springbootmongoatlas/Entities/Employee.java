package com.example.springbootmongoatlas.Entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee implements Serializable {
    @Id
    private int id;

    @Column(name="fname")
    private String fName;
    private int age;
    @Column(name="lname")
    private String lName;
    private int salary;
    private String address;



}
