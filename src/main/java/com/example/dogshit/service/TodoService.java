package com.example.dogshit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dogshit.factory.TextFactory;
import com.example.dogshit.model.Todo;
import com.example.dogshit.repository.TodoRepository;
import com.example.dogshit.strategy.TextStrategy;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService{
    private final TodoRepository repository;
    private final TextFactory factory;
    
    public Todo create(String text, String strategyName){
        TextStrategy strat = factory.getStrategy(strategyName);
        String processed = strat.apply(text);

        return repository.save(new Todo(null,processed));
    }

    public List<Todo> findAll(){
        return repository.findAll();
    }


    public Todo findById(Long id){
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Todo not found"));
    }

    public Todo update(Long id,String text, String stratName){
        Todo todo = findById(id);
        TextStrategy strat = factory.getStrategy(stratName);
        todo.setText(strat.apply(text));
        return repository.save(todo);
    }


    public void delete(Long id){
        repository.deleteById(id);
    }
}