package org.example;

class AssignmentStatement implements ExecutableStatement {
    private String variable;
    private String expression;
    private String operator; // ruajmë operatorin këtu

    public AssignmentStatement(String variable, String expression) {
        this.variable = variable;
        this.expression = expression;
    }

    public String getOperator() {
        return operator;
    }

    @Override
    public void execute(ExecutionContext context) {
        if (expression.contains("+")) operator = "+";
        else if (expression.contains("-")) operator = "-";
        else if (expression.contains("*")) operator = "*";
        else if (expression.contains("/")) operator = "/";

        if (operator == null) {
            // single value or variable
            double val;
            try {
                val = Double.parseDouble(expression);
            } catch (NumberFormatException e) {
                val = context.get(expression);
            }
            context.set(variable, val);
            return;
        }

        String[] parts = expression.split("\\" + operator);
        double left = getValue(parts[0].trim(), context);
        double right = getValue(parts[1].trim(), context);

        double result = switch (operator) {
            case "+" -> left + right;
            case "-" -> left - right;
            case "*" -> left * right;
            case "/" -> left / right;
            default -> 0;
        };

        context.set(variable, result);
    }

    private double getValue(String token, ExecutionContext context) {
        try {
            return Double.parseDouble(token);
        } catch (NumberFormatException e) {
            return context.get(token);
        }
    }
}
