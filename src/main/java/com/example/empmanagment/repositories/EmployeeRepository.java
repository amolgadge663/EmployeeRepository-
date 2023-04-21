package com.example.empmanagment.repositories;

import com.example.empmanagment.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    Employee findEmployeeByEmpId(String empId);



}
