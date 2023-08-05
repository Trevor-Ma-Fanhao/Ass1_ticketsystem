package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.function.Executable;



public class AirplaneTest {

    @Test
    public void testAirplaneCreation() {
        // Test case 1: Valid airplane data
        assertThrows(IllegalArgumentException.class, (Executable) () -> {
            Airplane airplane1 = new Airplane(101, "Boeing 747", 50, 250, 10);
            assertEquals(101, airplane1.getAirplaneID());
            assertEquals("Boeing 747", airplane1.getAirplaneModel());
            assertEquals(50, airplane1.getBusinessSitsNumber());
            assertEquals(250, airplane1.getEconomySitsNumber());
            assertEquals(10, airplane1.getCrewSitsNumber());
        });
        Assertions.assertDoesNotThrow(() -> {
            Airplane airplane1 = new Airplane(101, "Boeing 747", 5, 250, 10);
            assertEquals(101, airplane1.getAirplaneID());
            assertEquals("Boeing 747", airplane1.getAirplaneModel());
            assertEquals(5, airplane1.getBusinessSitsNumber());
            assertEquals(250, airplane1.getEconomySitsNumber());
            assertEquals(10, airplane1.getCrewSitsNumber());
        });
    }

    // Test case 2: Invalid airplaneID (negative)
    @Test
    public void testAirplaneID() {
        assertThrows(IllegalArgumentException.class, (Executable) () -> {
            new Airplane(-1, "Airbus A380", 80, 300, 15);
        });
        Assertions.assertDoesNotThrow(() -> {
            new Airplane(1, "Airbus A380", 80, 30, 15);

        });
    }
    // Test case 3: Invalid airplaneModel (null)
    @Test
    public void testAirplaneModel() {
        assertThrows(IllegalArgumentException.class, (Executable) () -> {
            new Airplane(102, null, 80, 300, 15);
        });
        Assertions.assertDoesNotThrow(() -> {
            new Airplane(102, "Airbus A380", 80, 30, 15);

        });
    }

    // Test case 4: Invalid businessSitsNumber (out of range)
    @Test
    public void testbusinessSitsNumber() {
        assertThrows(IllegalArgumentException.class, (Executable) () -> {
            new Airplane(103, "Boeing 777", 0, 300, 15);
        });
        Assertions.assertDoesNotThrow(() -> {
            new Airplane(103, "Boeing 777", 10, 30, 15);

        });
    }

    // Test case 5: Invalid economySitsNumber (out of range)
    @Test
    public void testeconomySitsNumber() {
        assertThrows(IllegalArgumentException.class, (Executable) () -> {
            new Airplane(104, "Boeing 737", 80, 350, 15);
        });
        Assertions.assertDoesNotThrow(() -> {
            new Airplane(104, "Boeing 737", 80, 35, 15);

        });
    }

    // Test case 6: Invalid crewSitsNumber (out of range)
    @Test
    public void testcrewSitsNumber() {
        assertThrows(IllegalArgumentException.class, (Executable) () -> {
            new Airplane(105, "Airbus A320", 80, 300, 0);
        });
        Assertions.assertDoesNotThrow(() -> {
            new Airplane(105, "Airbus A320", 80, 30, 10);

        });
    }

    // Test case 7: Invalid totalSitsNumber (out of range)
    @Test
    public void testctotalSitsNumber() {
        assertThrows(IllegalArgumentException.class, (Executable) () -> {
            new Airplane(106, "Boeing 787", 200, 150, 50);
        });
        Assertions.assertDoesNotThrow(() -> {
            new Airplane(106, "Boeing 787", 200, 15, 50);

        });
    }

}



