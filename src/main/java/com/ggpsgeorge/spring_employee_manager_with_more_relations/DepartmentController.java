package com.ggpsgeorge.spring_employee_manager_with_more_relations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    
    @Autowired DepartmentService departmentService;

    @PostMapping("/add")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        return ResponseEntity.ok().body(departmentService.saveDepartment(department));
    }

    @GetMapping("/{department_id}")
    public ResponseEntity<Department> getDepartment(@PathVariable Long department_id) {
        return ResponseEntity.ok().body(departmentService.findDepartment(department_id));
    }

}
