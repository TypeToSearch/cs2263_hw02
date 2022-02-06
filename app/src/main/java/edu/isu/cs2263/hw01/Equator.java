package edu.isu.cs2263.hw01;

/**
 * Implements functionality for evaluating simple expressions
 * @author Benjamin Thomas
 */
public class Equator {
    private final Input input;
    private final Output output;

    /**
     * Constructs an Equator object with the preferred input and output
     * @param in The preferred input object
     * @param out The preferred output object
     */
    public Equator(Input in, Output out) {
        input = in;
        output = out;
    }

    /**
     * Evaluates a mathematical string expression into an int value. Operands and operators must be
     * seperated by a single space.
     * @param equation The mathematical expression to be evaluated
     * @return The evaluated expression as an int
     */
    private int equate(String equation) {
        if (equation.replaceAll("\\s", "").length() == 0) return 0;
        String[] parts = equation.split(" ");
        float answer = Float.parseFloat(parts[0]);
        for (int i=1; i<parts.length; i+=2) {
            float operand = Float.parseFloat(parts[i+1]);
            answer = switch (parts[i]) {
                case "+" -> answer + operand;
                case "-" -> answer - operand;
                case "*" -> answer * operand;
                case "/" -> answer / operand;
                default -> answer;
            };
        }
        return (int) answer;
    }

    /**
     * Method for running the Equator
     */
    public void solve() {
        while (input.isReading()) {
            for (var equation : input.read()) {
                try {
                    output.output(equation, equate(equation));
                }
                catch (Exception exp) {
                    System.out.println("(Invalid mathematical expression)");
                }
            }
        }
    }
}
