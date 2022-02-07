package edu.isu.cs2263.hw01;

/**
 * Interface for outputting data to the user
 * @author Benjamin Thomas
 */
public interface Output {
    /**
     * Outputs an int value from the program
     * @param answer The int to output
     * @param equation The expression evaluated
     */
    public void output(String equation, int answer);

    /**
     * Outputs a message that states that an expression was invalid
     */
    public void invalid();
}
