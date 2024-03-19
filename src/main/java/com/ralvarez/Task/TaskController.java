package com.ralvarez.Task;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("task")
    public List<Task> index()
    {
        return taskService.getAllTask();
    }

    @GetMapping("task/{userId}")
    public List<Task> getAllTaskByUser(@PathVariable Long userId)
    {
        return taskService.getAllTaskByUser(userId);
    }

    @GetMapping("task/{taskId}/{userId}")
    public ResponseEntity<Task> detailTask(@PathVariable Long taskId, @PathVariable Long userId)
    {
        return taskService.getTaskUser(taskId, userId);
    }

    @PostMapping("task")
    public ResponseEntity<String> create(@RequestBody Task task)
    {
        return taskService.createTask(task);
    }

    @PutMapping("task/{taskId}")
    public  ResponseEntity<String> update(@PathVariable Long taskId, @RequestBody Task task)
    {
        return taskService.updateTask(taskId, task);
    }

    @DeleteMapping("task/{taskId}/{userId}")
    public ResponseEntity<String> deleteTaskByUser(@PathVariable Long taskId, @PathVariable Long userId)
    {
        return taskService.deleteTaskUser(taskId, userId);
    }
}
