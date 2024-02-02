package com.ggpsgeorge.spring_employee_manager_with_more_relations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    
    @Autowired TaskRepository taskRepository;

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public Task findTask(Long id) {
        return taskRepository.findById(id).get();
    }

}
