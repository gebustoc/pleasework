package com.example.dogshit.strategy;
import org.springframework.stereotype.Component;

@Component
public class DefaultCaseStrategy implements TextStrategy{
    @Override
    public String apply(String text){
        return text;
    }
    
}