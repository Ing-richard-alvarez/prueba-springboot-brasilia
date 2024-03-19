package com.ralvarez.Task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByIdAndUserId(Long taskId, Long userId);
    Optional<List<Task>> findByUserId(Long userId);
}
