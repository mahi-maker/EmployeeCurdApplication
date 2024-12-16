package com.example.EmployeeCrud.employeeCrud.Service;

import com.example.EmployeeCrud.employeeCrud.Entity.Employee;
import com.example.EmployeeCrud.employeeCrud.Repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    private EmpRepository empRepository;

    public List<Employee> getAllEmployees(){
    return empRepository.findAll();
    }

    public Employee saveEmployee(Employee employee){
        return empRepository.save(employee);
    }

    public Employee getEmployeeById(Integer id) {
        return empRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found!"));
    }


    public Employee updateEmployee(Integer id, Employee updatedEmployee) {
        // Find the existing employee
        Employee existingEmployee = empRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        // Update the fields of the existing employee
        existingEmployee.setFirst_name(updatedEmployee.getFirst_name());
        existingEmployee.setLast_name(updatedEmployee.getLast_name());
        existingEmployee.setEmail(updatedEmployee.getEmail());
        existingEmployee.setPassword(updatedEmployee.getPassword());

        // Save the updated employee
        return empRepository.save(existingEmployee);
    }

    public void deleteEmployee(Integer id) {
        empRepository.deleteById(id);
    }
}
