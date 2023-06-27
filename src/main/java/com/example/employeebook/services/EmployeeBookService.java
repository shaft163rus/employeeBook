package com.example.employeebook.services;

import com.example.employeebook.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeBookService {
    String addEmployee(String lastName, String firstName, int salary, String department);

    Map<String, Employee> getEmployees();

    String printEmployees();

    String deleteEmployee(String lastName, String firstName);

    String findEmployee(String lastName, String firstName);

    Employee findMaxSalaryByDepartment(String department);

    Employee findMinSalaryByDepartment(String department);

    List<Employee> getEmployeesByDepartment(String department);

    Map<String, List<String>> getEmployeesDepartmentsAll();
}