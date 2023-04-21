package com.example.empmanagment.services.impl;

import com.example.empmanagment.entities.Employee;
import com.example.empmanagment.repositories.EmployeeRepository;
import com.example.empmanagment.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    Employee newEmp = new Employee();

    @Override
    public Employee create(Employee emp) {
        String empId = UUID.randomUUID().toString();
        emp.setEmpId(empId);
        return employeeRepository.save(emp);
    }

    @Override
    public List<Employee> allEmp() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(String empId) {
        return employeeRepository.findEmployeeByEmpId(empId);
    }

    @Override
    public Employee updateEmp(Employee emp) {

        if (employeeRepository.findById(emp.getEmpId()).isPresent()){
            newEmp.setEmpId(emp.getEmpId());
            newEmp.setEmpName(emp.getEmpName());
            newEmp.setEmpDesignation(emp.getEmpDesignation());
            newEmp.setEmpAddress(emp.getEmpAddress());
            newEmp.setEmpSkills(emp.getEmpSkills());
        }
        return employeeRepository.save(newEmp);
    }

    @Override
    public String deleteEmp(String empId) {

        if (employeeRepository.findById(empId).isPresent()){
            employeeRepository.deleteById(empId);
            return "Delete Successfully!!!";
        }

        return "Id is not found.";
    }
}
