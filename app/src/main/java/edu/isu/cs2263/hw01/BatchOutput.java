package edu.isu.cs2263.hw01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Simple class for outputting equations to a file
 * @author Benjamin Thomas
 */
public class BatchOutput implements Output {
    private String filePath;

    /**
     * Constructs an object for outputting to the file at the provided path
     * @param path The file path of the file to write to
     */
    public BatchOutput(String path) {
        try {
            File file = new File(path);
            if (!file.createNewFile()) new FileWriter(path, false).close();
            filePath = path;
        }
        catch (IOException e) {
            System.err.println("Error locating or creating file");
        }
    }

    /**
     * Writes an equation and an answer to the file at filePath
     * @param equation The equation to write
     * @param answer The int to write
     */
    public void output(String equation, int answer) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            fileWriter.append(equation + "\n\t-> " + answer + "\n");
            fileWriter.close();
        }
        catch (IOException e) {
            System.err.println("Error writing to file");
        }
    }

    /**
     * Writes a message to the file at filePath stating that a provided expression was invalid
     */
    public void invalid() {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            fileWriter.append("(Invalid mathematical expression)\n");
            fileWriter.close();
        }
        catch (IOException e) {
            System.err.println("Error writing to file");
        }
    }
}
