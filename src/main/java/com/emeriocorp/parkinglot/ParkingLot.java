package com.emeriocorp.parkinglot;

import java.util.*;

public class ParkingLot {
    // Config FIRST HOUR by call ParkingLot.FIRST_HOUR = ? if you wanted to change
    public static int FIRST_HOUR = 2;
    // Max lot to handle the maximum value of slot
    private int maxLot = 0;
    // Config PRICE by call ParkingLot.PRICE = ? if you wanted to change
    public static int PRICE = 10;
    // Remaining slot to handle sequential number generated in created parking slot
    private final List<Integer> remainingSlot = new ArrayList<>();
    // In memory database to save temporary data slot and reqNo request with kv pair
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

    /**
     * Handle car who's leave park with regNo and hour as a parameter and the
     * print the result regNo, slotNO, and charge
     *
     * @param regNo     the regNo input by user
     * @param numOfHour the total hour input by user
     */
    public void leave(String regNo, String numOfHour) {
        int hour;
        int slotNo;
        try {
            hour = Integer.parseInt(numOfHour);
        } catch (NumberFormatException e) {
            System.err.println("Invalid number for hour");
            return;
        }
        slotNo = Optional.ofNullable(getKey(slotReqNoMap, regNo)).orElse(0);
        if (slotNo == 0) {
            System.err.println(String.format("Not found reg no with value %s", regNo));
            return;
        }
        int charge = calculateCharge(hour);
        String message = "Registration number %s with Slot Number %d is free with Charge %d";
        System.out.println(String.format(message, regNo, slotNo, charge));
        slotReqNoMap.remove(slotNo);
        remainingSlot.add(slotNo);
    }

    private int calculateCharge(int totalHour) {
        return ((totalHour - FIRST_HOUR) * PRICE) + PRICE;
    }

    public void status(){

    }

    /**
     * Map get key from value map
     *
     * @param map   is the input map
     * @param value is the value you search
     * @return the ke from value map
     */
    private <K, V> K getKey(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
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
