package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleParser {
    public List<ExecutableStatement> parse(List<String> lines) {
        List<ExecutableStatement> program = new ArrayList<>();
        Map<String, String> varOperators = new HashMap<>();

        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty()) continue;

            if (line.startsWith("Lexo")) {
                program.add(new ReadStatement(line.split(" ")[1]));

            } else if (line.startsWith("Afisho")) {
                String varName = line.split(" ")[1];
                String op = varOperators.getOrDefault(varName, null);
                program.add(new OutputStatement(varName, op));

            } else if (line.contains("=")) {
                String[] parts = line.split("=", 2);
                String var = parts[0].trim();
                String expr = parts[1].trim();

                String op = null;
                if (expr.contains("+")) op = "+";
                else if (expr.contains("-")) op = "-";
                else if (expr.contains("*")) op = "*";
                else if (expr.contains("/")) op = "/";

                varOperators.put(var, op);
                program.add(new AssignmentStatement(var, expr));

            } else {
                System.out.println("Nuk u gjend simboli " + line);
            }
        }

        return program;
    }
}

