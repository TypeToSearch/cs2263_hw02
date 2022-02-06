package edu.isu.cs2263.hw01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Implements functionality for reading equations from a batch file
 * @author Benjamin Thomas
 */
public class BatchInput implements Input {
    private Scanner in;
    private boolean reading = true;

    /**
     * Constructs an object with a batch file path to read data from
     * @param path File path of a batch file containing mathematical expressions
     * @throws FileNotFoundException Thrown if file path is not a valid file path
     */
    public BatchInput(String path) throws FileNotFoundException {
        File file = new File(path);
        in = new Scanner(file);
    }

    /**
     * Reads in expressions from the batch file at the path given on construction of this class
     * @return A string array of the contents of the batch file
     */
    public String[] read() {
        String[] contents = new String[0];
        while (in.hasNext()) {
            contents = Arrays.copyOf(contents, contents.length+1);
            contents[contents.length-1] = in.nextLine();
        }
        reading = false;
        return contents;
    }

    /**
     * Represents if the Input object is currently reading in input
     * @return True if object is reading user input, otherwise false
     */
    public boolean isReading() {
        return reading;
    }
}
