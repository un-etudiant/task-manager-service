package com.pradeep.task_manager_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pradeep.task_manager_service.exception.TaskNotFoundException;
import com.pradeep.task_manager_service.model.Task;
import com.pradeep.task_manager_service.repository.TaskRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        log.info("Fetching all tasks");
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        log.info("Fetching task by id: {}", id);
        return taskRepository.findById(id).orElseThrow(() -> {
            log.error("Task with id {} not found", id);
            return new TaskNotFoundException("Task with id " + id + " not found");
        });
    }

    public Task saveTask(Task task) {
        try {
            log.info("Saving task: {}", task);
            return taskRepository.save(task);
        } catch (Exception e) {
            log.error("Failed to save task: {}", task, e);
            throw new RuntimeException("Failed to save task", e);
        }
    }

    public Task updateTask(Long id, Task task) {
        Task existingTask = getTaskById(id);
        existingTask.setName(task.getName());
        existingTask.setDescription(task.getDescription());
        existingTask.setStartDate(task.getStartDate());
        existingTask.setEndDate(task.getEndDate());
        existingTask.setStatus(task.getStatus());
        log.info("Updating task: {}", existingTask);
        return taskRepository.save(existingTask);
    }

    public void deleteTask(Long id) {
        try {
            log.info("Deleting task by id: {}", id);
            taskRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Failed to delete task by id: {}", id, e);
            throw new RuntimeException("Failed to delete task by id: " + id, e); // You can create a custom exception if needed
        }
    }
}
