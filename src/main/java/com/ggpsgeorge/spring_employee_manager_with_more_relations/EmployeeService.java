package com.ggpsgeorge.spring_employee_manager_with_more_relations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    
    @Autowired EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    
    public Employee findEmployee(Long id) {
        return employeeRepository.findById(id).get();
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

}
