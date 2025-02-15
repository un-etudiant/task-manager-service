package com.pradeep.task_manager_service.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Slf4j
@Entity
@RequiredArgsConstructor
@Data
@Table(name = "task")
public class Task {
 @Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_seq")
@SequenceGenerator(name = "task_seq", sequenceName = "task_seq", allocationSize = 1)
private Long id;
@NotBlank(message = "Task Name is mandatory")
private String name;    
@NotBlank(message = "Task Description is mandatory")
private String description;

@NotBlank(message = "Task Start Date is mandatory")
private LocalDate startDate;

@NotBlank(message = "Task End Date is mandatory")
private LocalDate endDate;

@Enumerated(EnumType.STRING)
@NotNull(message = "Task Status is mandatory")
private TaskStatus status;


}
