package com.emeriocorp.parkinglot;

import java.util.*;

public class ParkingLot {
    // Max lot to handle the maximum value of slot
    private int maxLot = 0;
    // Remaining slot to handle sequential number generated in created parking slot
    private final List<Integer> remainingSlot = new ArrayList<>();

    private final Map<Integer, String> slotReqNoMap = new HashMap<>();

    /**
     * Handle command create_parking_lot with input numOfLot by parsing string into integer
     *
     * @param numOfLot is the value of create_parking_lot a.k.a 6
     */
    public void createParkingLot(String numOfLot) {
        try {
            setMaxLot(Integer.parseInt(numOfLot));
            remainingSlot.clear();
            for (int i = 1; i <= getMaxLot(); i++) {
                remainingSlot.add(i);
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid lot number");
            System.err.println();
        }
    }


    /**
     * Handle command for parking register with input regNo
     * the output is number of allocation slot
     *
     * @param regNo as the registration number
     */
    public void park(String regNo) {
        if (maxLot == 0) {
            System.out.println("Sorry, parking lot isn't created");
            return;
        }
        if (slotReqNoMap.size() == maxLot) {
            System.out.println("Sorry, parking lot is full");
            return;
        }

        // Sorting slot ascending order, so when this method is called, the value is sorted
        Collections.sort(remainingSlot);
        String slotNo = remainingSlot.get(0).toString();
        slotReqNoMap.put(Integer.parseInt(slotNo), regNo);
        System.out.println(String.format("Allocated slot number: %s", slotNo));
        remainingSlot.remove(0);
    }


    public int getMaxLot() {
        return maxLot;
    }

    public void setMaxLot(int maxLot) {
        this.maxLot = maxLot;
    }

    public List<Integer> getRemainingSlot() {
        return remainingSlot;
    }

    public Map<Integer, String> getSlotReqNoMap() {
        return slotReqNoMap;
    }
}
