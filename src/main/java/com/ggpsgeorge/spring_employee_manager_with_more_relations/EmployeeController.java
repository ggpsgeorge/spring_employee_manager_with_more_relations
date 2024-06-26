package com.ggpsgeorge.spring_employee_manager_with_more_relations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired EmployeeService employeeService;
    @Autowired AddressService addressService;
    @Autowired DepartmentService departmentService;
    @Autowired TaskService taskService;

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok().body(employeeService.saveEmployee(employee));
    }

    @GetMapping("/{employee_id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long employee_id) {
        return ResponseEntity.ok().body(employeeService.findEmployee(employee_id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok().body(employeeService.findAllEmployees());
    }

    @PutMapping("/{employee_id}/register_address/{address_id}")
    public ResponseEntity<Employee> registerAddress(
        @PathVariable Long employee_id,
        @PathVariable Long address_id
    ) {
        Employee persistedEmployee = employeeService.findEmployee(employee_id);
        Address persistedAddress = addressService.finAddress(address_id);
        
        persistedEmployee.setAddress(persistedAddress);
        employeeService.saveEmployee(persistedEmployee);

        return ResponseEntity.ok().body(employeeService.findEmployee(employee_id));
    }

    @PutMapping("/{employee_id}/register_department/{department_id}")
    public ResponseEntity<Employee> registerDepartment(
        @PathVariable Long employee_id,
        @PathVariable Long department_id
    ) {
        Employee persistedEmployee = employeeService.findEmployee(employee_id);
        Department persistedDepartment = departmentService.findDepartment(department_id);

        persistedEmployee.setDepartment(persistedDepartment);

        employeeService.saveEmployee(persistedEmployee);
        
        return ResponseEntity.ok().body(employeeService.findEmployee(employee_id));

    }

    @PutMapping("/{employee_id}/give_task/{task_id}")
    public ResponseEntity<Employee> giveTask(
        @PathVariable Long employee_id,
        @PathVariable Long task_id
    ) {
        Employee persistedEmployee = employeeService.findEmployee(employee_id);
        Task persistedTask = taskService.findTask(task_id);

        persistedEmployee.tasks.add(persistedTask);
        employeeService.saveEmployee(persistedEmployee);

        return ResponseEntity.ok().body(employeeService.findEmployee(employee_id));
    }

}
