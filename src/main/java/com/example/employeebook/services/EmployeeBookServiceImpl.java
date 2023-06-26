package com.example.employeebook.services;

import com.example.employeebook.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeBookServiceImpl implements EmployeeBookService {
    Map<String, Employee> employees = new HashMap<>();

    @Override
    public String addEmployee(String lastName, String firstName, int salary, String department) {
        return null;
    }

    public Map<String, Employee> getEmployees() {
        return employees;
    }

    public String addEmployee(String lastName, String firstName, String patronymicName, int salary, String department){
        Employee employee = new Employee(lastName, firstName, salary, department);
        if (employees.containsKey(employee.getFullName())){
            throw new RuntimeException("This employee is already in database");
        }
        employees.put(employee.getFullName(), employee);
        return employee.toString();
    }

    public String deleteEmployee(String lastName, String firstName){
        String fullName = lastName + " " + firstName;
        if (!employees.containsKey(fullName)){
            throw new RuntimeException("This employee is not in database");
        }
        employees.remove(fullName);
        return fullName;
    }

    public String findEmployee(String lastName, String firstName){
        String fullName = lastName + " " + firstName;
        if (!employees.containsKey(fullName)){
            throw new RuntimeException("This employee is not in database");
        }
        return employees.get(fullName).toString();
    }

    public Employee findMaxSalaryByDepartment(String department){
        return employees.values().stream()
                .filter(e -> e.getDepartment().contains(department))
                .max(Comparator.comparing(e -> e.getSalary()))
                .orElseThrow(() -> new RuntimeException("Employee with max salary is not found"));
    }

    public Employee findMinSalaryByDepartment(String department){
        return employees.values().stream()
                .filter(e -> e.getDepartment().contains(department))
                .min(Comparator.comparing(e -> e.getSalary()))
                .orElseThrow(() -> new RuntimeException("Employee with min salary is not found"));
    }

    public List<Employee> getEmployeesByDepartment(String department){
        return employees.values().stream()
                .filter(employee -> employee.getDepartment().contains(department))
                .collect(Collectors.toList());
    }

    public String getEmployeesDepartmentsAll(){
        List<String> departments = employees.values().stream()
                .map(employee -> employee.getDepartment())
                .distinct()
                .collect(Collectors.toList());

        String employeesAll = "";
        for (String department : departments) {
            employeesAll += "Department of " + department + ": ";
            String employeesByDepartment = employees.values().stream()
                    .filter(employee -> employee.getDepartment().contains(department))
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
            employeesAll += employeesByDepartment + " \n";

        }
        return employeesAll;

    }



    public String printEmployees(){
        String empls = "";
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            empls+= entry.getKey() + " " + entry.getValue() + "\n";
        }
        return empls;
    }

}