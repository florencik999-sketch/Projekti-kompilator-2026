package org.example;

import java.util.*;

public class SimpleParser {

    private Map<String, String> simbolet = new HashMap<>();

    public List<ExecutableStatement> parse(List<String> lines) {
        List<ExecutableStatement> program = new ArrayList<>();

        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty()) continue;

            if (line.startsWith("Lexo")) {
                String varName = line.split(" ")[1];
                simbolet.putIfAbsent(varName, null);
                program.add(new ReadStatement(varName));

            } else if (line.startsWith("Afisho")) {
                String varName = line.split(" ")[1];
                String lastOp = simbolet.getOrDefault(varName, null);
                program.add(new OutputStatement(varName, lastOp));

            } else if (line.contains("=")) {
                String[] parts = line.split("=", 2);
                String var = parts[0].trim();
                String expr = parts[1].trim();

                String op = null;
                if (expr.contains("+")) op = "+";
                else if (expr.contains("-")) op = "-";
                else if (expr.contains("*")) op = "*";
                else if (expr.contains("/")) op = "/";

                simbolet.put(var, op);
                program.add(new AssignmentStatement(var, expr));

            } else {
                System.out.println("Nuk u gjend simboli " + line);
            }
        }
        return program;
    }
}
