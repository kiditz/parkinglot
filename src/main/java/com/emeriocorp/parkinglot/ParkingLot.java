package com.emeriocorp.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    // Max lot to handle the maximum value of slot
    private int maxLot = 0;
    // Remaining slot to handle sequential number generated in created parking slot
    private final List<Integer> remainingSlot = new ArrayList<>();

    public void createParkingLot(String numOfLot) {
        try {
            setMaxLot(Integer.parseInt(numOfLot));
            for (int i = 1; i <= getMaxLot(); i++) {
                remainingSlot.add(i);
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid lot number");
            System.err.println();
        }
    }


    public int getMaxLot() {
        return maxLot;
    }

    public void setMaxLot(int maxLot) {
        this.maxLot = maxLot;
    }
}
