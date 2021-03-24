package ru.grigan.spring.mvc_hibernate_aop.dao;

import ru.grigan.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);
}
