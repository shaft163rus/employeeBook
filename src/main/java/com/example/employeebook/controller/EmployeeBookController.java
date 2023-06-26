package com.example.employeebook.controller;

import com.example.employeebook.model.Employee;
import com.example.employeebook.services.EmployeeBookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeBookController {
    private final EmployeeBookService employeeBookService;

    public EmployeeBookController(EmployeeBookService employeeBookService) {
        this.employeeBookService = employeeBookService;
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("lastName") String lastName,
                              @RequestParam("firstName") String firstName,
                              @RequestParam("salary") int salary,
                              @RequestParam("department") String department) {
        return employeeBookService.addEmployee(lastName, firstName, salary, department);
    }

    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam("lastName") String lastName,
                                 @RequestParam("firstName") String firstName
                                 ) {
        return employeeBookService.deleteEmployee(lastName, firstName);
    }

    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam("lastName") String lastName,
                               @RequestParam("firstName") String firstName){
        return employeeBookService.findEmployee(lastName, firstName);
    }

    @GetMapping(path = "/print")
    public String printEmployees() {
        return employeeBookService.printEmployees();
    }

    @GetMapping(path = "/departments/max-salary")
    public Employee findMaxSalaryByDepartment(@RequestParam("department") String department) {
        return employeeBookService.findMaxSalaryByDepartment(department);
    }

    @GetMapping(path = "/departments/min-salary")
    public Employee findMinSalaryByDepartment(@RequestParam("department") String department) {
        return employeeBookService.findMinSalaryByDepartment(department);
    }

    @GetMapping(path = "/departments/by-department")
    public List<Employee> getEmployeesByDepartment(@RequestParam("department") String department) {
        return employeeBookService.getEmployeesByDepartment(department);
    }

    @GetMapping(path = "/departments/all")
    public String getEmployeesDepartmentsAll() {
        return employeeBookService.getEmployeesDepartmentsAll();
    }


}