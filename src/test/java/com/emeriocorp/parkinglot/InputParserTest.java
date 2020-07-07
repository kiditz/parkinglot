package com.emeriocorp.parkinglot;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.startsWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class InputParserTest {
    public InputParser parser;

    @Before
    public void setUp() {
        parser = new InputParser();
    }

    @Test
    public void testParkingLotCommand() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        parser.parse("create_parking_lot 5");
        verify(out).println(eq("Created parking lot with 5 slots"));
        parser.parse("park KA-09-HH-0987");
        verify(out).println(startsWith("Allocated"));
        parser.parse("status");
        verify(out).println(startsWith("Slot"));

    }

}
