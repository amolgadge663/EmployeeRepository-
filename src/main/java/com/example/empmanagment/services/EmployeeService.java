package com.example.empmanagment.services;

import com.example.empmanagment.entities.Employee;

import java.util.List;

public interface EmployeeService {

    //create
    Employee create(Employee emp);

    //Read
    List<Employee> allEmp();

    //GetEmpById
    Employee getEmployeeById(String empId);

    //update
    Employee updateEmp(Employee emp);

    //Delete
    String deleteEmp(String empId);
}
