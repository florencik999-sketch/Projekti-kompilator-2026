package org.example;

import java.util.Scanner;

class ReadStatement implements ExecutableStatement {
    private String variable;
    private static Scanner scanner = new Scanner(System.in);

    public ReadStatement(String variable) {
        this.variable = variable;
    }

    @Override
    public void execute(ExecutionContext context) {
        System.out.print("Jepni " + variable + ": ");
        double value = scanner.nextDouble();
        context.set(variable, value);
    }
}
