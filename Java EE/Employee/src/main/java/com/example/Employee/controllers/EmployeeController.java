package com.example.Employee.controllers;

import com.example.Employee.entities.Employee;
import com.example.Employee.repository.EmployeeRepository;
import com.example.Employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // GET /api/employees - Requires ROLE_EMPLOYEE (Read)
    @GetMapping("/{id}")
    public Employee findEmployeeById(@PathVariable int id) {
        return employeeService.findEmployeeById(id);
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAllEmployees();
    }

    // POST /api/employees - Requires ROLE_MANAGER (Create)
    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        employee.setId(0);
        return employeeService.saveEmployee(employee);
    }

    // PUT /api/employees - Requires ROLE_MANAGER (Update)
    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    // DELETE /api/employees/{id} - Requires ROLE_ADMIN (Delete)
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployeeById(id);
        return "Deleted employee id - " + id;
    }
}
