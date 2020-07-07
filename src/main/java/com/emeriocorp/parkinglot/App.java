package com.emeriocorp.parkinglot;

import java.io.*;


public class App {
    public static void main(String[] args) {
        InputParser parser = new InputParser();
        switch (args.length) {
            case 0:
                handleTextInput(parser);
                break;
            case 1:
                handleFileInput(parser, args[0]);
                break;
            case 2:
                handleFileInputWithOutStream(parser, args[0], args[1]);
        }
    }

    private static void handleFileInputWithOutStream(InputParser parser, String inputPath, String outputPath) {
        try {
            File file = new File(inputPath);
            PrintStream stream = new PrintStream(new File(outputPath));
            System.setOut(stream);
            parser.parseFile(file);
        } catch (IOException e) {
            System.err.println("Invalid input file");
            e.printStackTrace();
        }
    }

    private static void handleFileInput(InputParser parser, String inputPath) {
        File file = new File(inputPath);
        try {
            parser.parseFile(file);
        } catch (IOException e) {
            System.err.println("Invalid input file");
            e.printStackTrace();
        }
    }

    private static void handleTextInput(InputParser parser) {
        System.out.println("Please enter 'exit' to close the program");
        System.out.println("Waiting for input");
        System.out.println("Availebla command is [create_parking_lot, park, status, leave]");
        while (true) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String inputString = reader.readLine();
                if (inputString.equalsIgnoreCase("exit")) {
                    System.exit(0);
                    return;
                }
                if (inputString.isEmpty()) {
                    return;
                }
                parser.parse(inputString);
            } catch (IOException e) {
                System.err.println("Ops, Error to parse input");
                e.printStackTrace();
            }
        }
    }
}
