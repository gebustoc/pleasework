package com.example.dogshit.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.dogshit.model.Todo;

public interface TodoRepository extends JpaRepository<Todo,Long> {}
