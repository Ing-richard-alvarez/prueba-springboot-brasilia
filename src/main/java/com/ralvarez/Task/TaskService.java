package com.ralvarez.Task;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTask()
    {
        return taskRepository.findAll();
    }

    public ResponseEntity<String> createTask(Task task)
    {
        try {
            taskRepository.save(task);
            return new ResponseEntity<>("Task created Successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create task", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public  ResponseEntity<String> updateTask(Long taskId, Task task)
    {
        Task taskExisting = taskRepository.findById(taskId).orElse(null);

        if(taskExisting == null)
        {
            return new ResponseEntity<>("Task not found", HttpStatus.NOT_FOUND);
        }

        try {
            taskExisting.setCode(task.getCode());
            taskExisting.setTitle(task.getTitle());
            taskExisting.setDescription(task.getDescription());
            taskExisting.setEstado(task.getEstado());
            taskExisting.setUser(task.getUser());

            taskRepository.save(taskExisting);
            return new ResponseEntity<>("Task updated successfully", HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update task", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<Task> getAllTaskByUser(Long userId)
    {
        return taskRepository.findByUserId(userId).orElse(null);
    }

    public ResponseEntity<Task> getTaskUser(Long taskId, Long userId)
    {
        try {
           Task task = taskRepository.findByIdAndUserId(taskId, userId).orElse(null);
           return ResponseEntity.ok().body(task);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<String> deleteTaskUser(Long taskId, Long userId)
    {
        try {
            Task task = taskRepository.findByIdAndUserId(taskId, userId).orElse(null);
            if(task == null) {
                return new ResponseEntity<>("Task Not Found", HttpStatus.NOT_FOUND);
            }
            taskRepository.delete(task);
            return new ResponseEntity<>("Task Deleted Successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed delete task", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
