package com.emeriocorp.parkinglot;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class ParkingLotTest {
    ParkingLot parkingLot;

    @Before
    public void setUp() {
        parkingLot = new ParkingLot();
    }

    @Test
    public void testCreateParkingLot() {
        parkingLot.createParkingLot("6");
        assertThat(parkingLot.getMaxLot(), equalTo(6));
        assertThat(parkingLot.getRemainingSlot().size(), equalTo(6));
    }

    @Test
    public void testCreateParkingLotWithNonNumberValue() {
        parkingLot.createParkingLot("Hei");
        assertThat(parkingLot.getMaxLot(), equalTo(0));
        assertThat(parkingLot.getRemainingSlot().size(), equalTo(0));
    }
}
