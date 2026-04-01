package org.example;

class OutputStatement implements ExecutableStatement {
    private String variable;
    private String operator; // marrim operatorin nga assignment

    public OutputStatement(String variable, String operator) {
        this.variable = variable;
        this.operator = operator;
    }

    private String getOperationWord(String op) {
        if (op == null) return "Vlera";
        return switch (op) {
            case "+" -> "Shuma";
            case "-" -> "Diferenca";
            case "*" -> "Prodhimi";
            case "/" -> "Heresi";
            default -> "Vlera";
        };
    }

    @Override
    public void execute(ExecutionContext context) {
        double value = context.get(variable);
        String word = getOperationWord(operator);
        System.out.println(word + " eshte: " + value);
    }
}

