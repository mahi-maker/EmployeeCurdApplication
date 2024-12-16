package com.example.EmployeeCrud.employeeCrud.Controller;

import com.example.EmployeeCrud.employeeCrud.Entity.Employee;
import com.example.EmployeeCrud.employeeCrud.Service.EmpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("/employee")
    public List<Employee> getAllEmployees(){
        return empService.getAllEmployees();
    }

    @PostMapping("/save")
    public Employee creatEmployee(@RequestBody Employee employee){
        return empService.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        return empService.getEmployeeById(id);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee updatedEmployee) {
        Employee employee = empService.updateEmployee(id, updatedEmployee);
        return ResponseEntity.ok(employee);
    }


    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        empService.deleteEmployee(id);
        return "Employee with ID " + id + " deleted successfully!";
    }

}
