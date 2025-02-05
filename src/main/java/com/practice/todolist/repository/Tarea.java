package com.practice.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Tarea extends JpaRepository<com.practice.todolist.models.entities.Tarea, Long> {

}
