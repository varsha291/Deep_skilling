package com.cognizant.spring_learn.dao;

import com.cognizant.spring_learn.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao {

    private static List<Employee> EMPLOYEE_LIST;

    public EmployeeDao() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("employee.xml");

        EMPLOYEE_LIST = (List<Employee>) context.getBean("employeeList");
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }

    public Employee getEmployee(int id) {

        for (Employee employee : EMPLOYEE_LIST) {
            if (employee.getId() == id) {
                return employee;
            }
        }

        return null;
    }

    public void updateEmployee(Employee employee) {

        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {

            if (EMPLOYEE_LIST.get(i).getId() == employee.getId()) {
                EMPLOYEE_LIST.set(i, employee);
                return;
            }
        }
    }

    public void deleteEmployee(int id) {

        EMPLOYEE_LIST.removeIf(employee -> employee.getId() == id);
    }
}