package com.ggpsgeorge.spring_employee_manager_with_more_relations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    
    @Autowired DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department findDepartment(Long department_id) {
        return departmentRepository.findById(department_id).get();
    }

}
