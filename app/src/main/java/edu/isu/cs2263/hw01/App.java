package edu.isu.cs2263.hw01;

import org.apache.commons.cli.*;

import java.io.FileNotFoundException;

public class App {
    /**
     * Main class for handling execution of the application with command line arguments
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        // Make Options
        Option help = new Option("h", "help", false, "print usage message");
        Option batch = Option.builder("b")
                .longOpt("batch")
                .hasArg(true).argName("file")
                .desc("batch file containing expressions to evaluate")
                .build();
        Option output = Option.builder("o")
                .longOpt("output")
                .hasArg(true).argName("file")
                .desc("output file")
                .build();
        Options options = new Options();
        options.addOption(help);
        options.addOption(batch);
        options.addOption(output);

        // Command line parsing
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("h")) {
                HelpFormatter formatter = new HelpFormatter();
                String header = "Evaluation of simple mathematical expressions\n\n";
                String footer = "\nAuthor: Ben Thomas";
                formatter.printHelp("eval [options]", header, options, footer);
            }
            else {
                Input in = null;
                Output[] out = null;
                boolean batchMode = false;
                if (cmd.hasOption("b")) {
                    in = new BatchInput(cmd.getOptionValue("b"));
                    out = new Output[]{new TerminalOutput(true)};
                    batchMode = true;
                }
                if (cmd.hasOption("o")) {
                    out = new Output[]{new BatchOutput(cmd.getOptionValue("o")), new TerminalOutput(batchMode)};
                }
                // In the case of no options
                if (in == null) in = new TerminalInput();
                if (out == null) out = new Output[]{new TerminalOutput(false)};
                Equator equator = new Equator(in, out);
                equator.solve();
            }
        }
        catch (FileNotFoundException exp) {
            System.err.println(exp.getMessage() + " Please provide an existing file");
        }
        catch (ParseException exp) {
            System.err.println(exp.getMessage());
        }
    }
}
