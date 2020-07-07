package com.emeriocorp.parkinglot;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InputParser {
    private InputCommand command;
    private ParkingLot parkingLot;

    public InputParser() {
        command = new InputCommand();
        parkingLot = new ParkingLot();
    }

    /**
     * This function used to convert input line by line and then call method by invoking input command.
     *
     * @param inputLine
     */
    public void parse(String inputLine) {
        String[] inputs = inputLine.split(" ");
        String keyCommand = inputs[0].trim();
        Method method = command.get(keyCommand);
        switch (inputs.length) {
            case 1:
                invokeMethod(method);
                break;
            case 2:
                invokeMethod(method, inputs[1]);
                break;
            case 3:
                invokeMethod(method, inputs[1], inputs[2]);
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }

    }

    public void parseFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (true){
            String line = reader.readLine();
            if(line == null)
                break;
            parse(line);
        }
    }

    private void invokeMethod(Method method, Object... inputs) {
        if (method != null) {
            try {
                method.invoke(parkingLot, inputs);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid Input");
        }
    }
}
