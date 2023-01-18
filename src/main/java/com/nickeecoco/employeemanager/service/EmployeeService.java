package com.nickeecoco.employeemanager.service;

import com.nickeecoco.employeemanager.exception.EmployeeNotFoundException;
import com.nickeecoco.employeemanager.model.Employee;
import com.nickeecoco.employeemanager.repo.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeDao.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeDao.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeDao.save(employee);
    }

    public Employee findEmployeeById(int id) {
        return employeeDao.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("User by id " + id + " was not found."));
    }

    public void deleteEmployee(int id) {
        employeeDao.deleteById(id);
    }
}
