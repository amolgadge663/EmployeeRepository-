package com.example.empmanagment.controllers;

import com.example.empmanagment.entities.Employee;
import com.example.empmanagment.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping()
    ResponseEntity<Employee> createEmp(@RequestBody Employee emp) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.create(emp));
    }

    @GetMapping("/{empId}")
    ResponseEntity<Employee> getEmployeeById(@PathVariable String empId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(empId));
    }

    @GetMapping()
    ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok(employeeService.allEmp());
    }

    @PutMapping()
    ResponseEntity<Employee> updateEmployeeById(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.updateEmp(employee));
    }

    @DeleteMapping("/{empId}")
    Map<String, String> deleteEmployeeById(@PathVariable String empId){
        String status = employeeService.deleteEmp(empId);
        Map<String, String> map = new HashMap<>();
        map.put("Status", status);
        return map;
    }
}
