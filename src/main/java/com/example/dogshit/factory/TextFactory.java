package com.example.dogshit.factory;
import org.springframework.stereotype.Component;
import com.example.dogshit.strategy.TextStrategy;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;


@Component
public class TextFactory {

    private final Map<String,TextStrategy> strategies;

    public TextFactory(List<TextStrategy> strategyList){
        this.strategies = strategyList.stream().collect(
            Collectors.toMap(
                s->s.getClass().getSimpleName(), 
                Function.identity()
            ));
    }

    public TextStrategy getStrategy(String type){
        return strategies.getOrDefault(type, strategies.get("DefaultStrategy"));
    }

    public Set<String> getAvalibleStrategies(){
        return strategies.keySet();
    }


    
}
