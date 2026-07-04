package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.dao.EmployeeDao;
import com.cognizant.spring_learn.exception.EmployeeNotFoundException;
import com.cognizant.spring_learn.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Transactional
    public Employee getEmployee(int id) {

        Employee employee = employeeDao.getEmployee(id);

        if (employee == null) {
            throw new EmployeeNotFoundException("Employee not found");
        }

        return employee;
    }

    @Transactional
    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    @Transactional
    public void deleteEmployee(int id) {

        Employee employee = employeeDao.getEmployee(id);

        if (employee == null) {
            throw new EmployeeNotFoundException("Employee not found");
        }

        employeeDao.deleteEmployee(id);
    }
}