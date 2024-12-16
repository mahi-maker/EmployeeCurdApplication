package com.example.EmployeeCrud.employeeCrud.Repository;

import com.example.EmployeeCrud.employeeCrud.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {
}
