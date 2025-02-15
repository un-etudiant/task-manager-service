package com.pradeep.task_manager_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pradeep.task_manager_service.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
