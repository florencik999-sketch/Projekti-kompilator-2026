package org.example;

import java.util.HashMap;
import java.util.Map;

public class ExecutionContext {
    private Map<String, Double> variables = new HashMap<>();

    public void set(String name, double value) {
        variables.put(name, value);
    }

    public double get(String name) {
        if (!variables.containsKey(name)) {
            throw new RuntimeException("Variabli nuk u gjend" + name);
        }
        return variables.get(name);
    }
}
 
