package com.pradeep.task_manager_service.exception;

public class TaskSaveException extends RuntimeException {
    public TaskSaveException(String message, Throwable cause) {
        super(message, cause);
    }
}