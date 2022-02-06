package edu.isu.cs2263.hw01;

import java.util.Scanner;

/**
 * Implements functionality for reading equations from the terminal
 * @author Benjamin Thomas
 */
public class TerminalInput implements Input {
    /**
     * Reads in expressions from the terminal
     * @return A string array containing a single expression from the terminal
     */
    public String[] read() {
        Scanner in = new Scanner(System.in);
        System.out.print("> ");
        return new String[]{in.nextLine()};
    }

    /**
     * Represents if the Input object is currently reading in input
     * @return Always true. True if object is reading user input
     */
    public boolean isReading() {
        return true; // Since this class implements an indefinite loop, it is always reading
    }
}
