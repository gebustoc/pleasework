package com.example.dogshit.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dogshit.dto.CreateTodoDto;
import com.example.dogshit.model.Todo;
import com.example.dogshit.service.TodoService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService service;

    @PostMapping
    public Todo create(
        @RequestBody CreateTodoDto dto,
        @RequestParam(defaultValue = "DefaultStrategy") String strategy
    ) {
        
        return service.create(dto.getText(), strategy);
    }
    
    @GetMapping("/{id}")
    public Todo getById(@PathVariable Long id) {
        return service.findById(id);
    }


    @PutMapping("{id}")
    public Todo update(
        @PathVariable Long id,
        @RequestBody CreateTodoDto dto,
        @RequestParam(defaultValue = "DefaultStrategy") String strategy
    ) {
        return service.update(id, dto.getText(), strategy);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
    
    


    
}