package com.emeriocorp.parkinglot;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class ParkingLotTest {
    private ParkingLot parkingLot;

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

    @Test
    public void testParkWithRegNo() {
        parkingLot.createParkingLot("2");
        parkingLot.park("KA-01-HH-1234");
        parkingLot.park("KA-01-HH-9999");
        Map<Integer, String> slotMap = parkingLot.getSlotReqNoMap();
        assertThat(slotMap.get(1), equalTo("KA-01-HH-1234"));
        assertThat(slotMap.get(2), equalTo("KA-01-HH-9999"));
        assertThat(parkingLot.getRemainingSlot().size(), equalTo(0));
    }

    @Test
    public void testParkWithRegNoOverCapacity() {
        parkingLot.createParkingLot("1");
        parkingLot.park("KA-01-HH-1234");
        Map<Integer, String> slotMap = parkingLot.getSlotReqNoMap();
        assertThat(slotMap.get(1), equalTo("KA-01-HH-1234"));
        assertThat(parkingLot.getRemainingSlot().size(), equalTo(0));
        parkingLot.park("KA-01-HH-9999");
        assertThat(slotMap.get(2), equalTo(null));
    }

    @Test
    public void testParkWithRegNoZeroCapacity() {
        parkingLot.createParkingLot("0");
        parkingLot.park("KA-01-HH-1234");
        Map<Integer, String> slotMap = parkingLot.getSlotReqNoMap();
        assertThat(slotMap.get(2), equalTo(null));
    }

    @Test
    public void testLeaveParking() {
        parkingLot.createParkingLot("2");
        parkingLot.park("KA-01-HH-1234");
        parkingLot.park("KA-01-HH-9999");
        parkingLot.leave("KA-01-HH-1234", "4");
        assertThat(parkingLot.getRemainingSlot().size(), equalTo(1));
        parkingLot.leave("KA-01-HH-9999", "3");
        assertThat(parkingLot.getRemainingSlot().size(), equalTo(2));
    }

    @Test
    public void testStatusLot(){
        parkingLot.createParkingLot("2");
        parkingLot.park("KA-01-HH-1234");
        parkingLot.park("KA-01-HH-9999");
        parkingLot.status();

    }





    @After
    public void tearDown() {
        parkingLot = null;
    }
}
