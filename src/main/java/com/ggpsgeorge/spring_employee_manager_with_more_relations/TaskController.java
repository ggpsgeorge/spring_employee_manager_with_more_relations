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
@RequestMapping("/api/v1/tasks")
public class TaskController {
    
    @Autowired TaskService taskService;

    @PostMapping("/add")
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        return ResponseEntity.ok().body(taskService.saveTask(task));
    }

    @GetMapping("/{task_id}")
    public ResponseEntity<Task> getTask(@PathVariable Long task_id) {
        return ResponseEntity.ok().body(taskService.findTask(task_id));
    }


}
