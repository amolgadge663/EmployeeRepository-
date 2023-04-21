package com.example.empmanagment.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "employee_details")
@Entity
public class Employee {

    @Id
    private String empId;
    private String empName;
    private String empDesignation;
    private String empSkills;
    private String empAddress;

}
