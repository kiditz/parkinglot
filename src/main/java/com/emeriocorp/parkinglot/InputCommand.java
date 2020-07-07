package com.emeriocorp.parkinglot;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class InputCommand {
    private Map<String, Method> commands = new HashMap<>();

    public InputCommand() {
        try {
            commands.put("create_parking_lot", ParkingLot.class.getMethod("createParkingLot", String.class));
            commands.put("park", ParkingLot.class.getMethod("park", String.class));
            commands.put("leave", ParkingLot.class.getMethod("leave", String.class, String.class));
            commands.put("status", ParkingLot.class.getMethod("status"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public Method get(String key) {
        return commands.get(key);
    }
}