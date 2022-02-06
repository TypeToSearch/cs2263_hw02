package edu.isu.cs2263.hw01;

/**
 * Interfacing for reading in data from the user
 * @author Benjamin Thomas
 */
public interface Input {
    /**
     * Reads in an equation to the program
     * @return A string array of expressions
     */
    public String[] read();

    /**
     * Represents if the Input object is currently reading in input
     * @return True if object is reading user input, otherwise false
     */
    public boolean isReading();
}
