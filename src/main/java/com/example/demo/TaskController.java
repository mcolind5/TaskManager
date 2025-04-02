package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskRepository repo;

    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task) {
        return repo.save(task);
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return repo.findAll();
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
