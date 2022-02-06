package edu.isu.cs2263.hw01;

/**
 * Simple class for outputting a number to the terminal
 * @author Benjamin Thomas
 */
public class TerminalOutput implements Output {
    private final boolean batch;

    /**
     * Constructs an object for terminal output
     * @param batchMode If true, expressions will be shown with answers
     */
    public TerminalOutput(boolean batchMode) {
        batch = batchMode;
    }

    /**
     * Prints an int to the terminal
     * @param answer The int to be printed to the terminal
     */
    public void output(String expression, int answer) {
        if (batch) System.out.println(expression);
        System.out.println("\t-> " + answer);
    }
}
