package com.nickeecoco.employeemanager.repo;

import com.nickeecoco.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao  extends JpaRepository<Employee, Integer> {

}
