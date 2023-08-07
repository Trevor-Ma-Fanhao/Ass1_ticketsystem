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
        Assertions.assertDoesNotThrow(() -> {
            Airplane airplane1 = new Airplane(101, "Boeing 747", 50, 25, 10);
            assertEquals(101, airplane1.getAirplaneID());
            assertEquals("Boeing 747", airplane1.getAirplaneModel());
            assertEquals(50, airplane1.getBusinessSitsNumber());
            assertEquals(25, airplane1.getEconomySitsNumber());
            assertEquals(10, airplane1.getCrewSitsNumber());
        });

        // Test case 2: Negative airplaneID
        assertThrows(IllegalArgumentException.class, () -> {
            new Airplane(-1, "Airbus A380", 60, 30, 15);
        });

        // Test case 3: Zero airplaneID
        assertThrows(IllegalArgumentException.class, () -> {
            new Airplane(0, "Boeing 787", 40, 20, 8);
        });

        // Test case 4: airplaneModel is null
        assertThrows(IllegalArgumentException.class, () -> {
            new Airplane(102, null, 5, 20, 8);
        });

        // Test case 5: Valid airplane data with a small business seat number
        Assertions.assertDoesNotThrow(() -> {
            Airplane airplane4 = new Airplane(102, "Airbus A320", 5, 20, 8);
            assertEquals(102, airplane4.getAirplaneID());
            assertEquals("Airbus A320", airplane4.getAirplaneModel());
            assertEquals(5, airplane4.getBusinessSitsNumber());
            assertEquals(20, airplane4.getEconomySitsNumber());
            assertEquals(8, airplane4.getCrewSitsNumber());
        });

        // Test case: businessSitsNumber is less than 1 (out of range)
        assertThrows(IllegalArgumentException.class, () -> {
            new Airplane(101, "Boeing 747", 0, 25, 10);
        });

        // Test case: businessSitsNumber is greater than 298 (out of range)
        assertThrows(IllegalArgumentException.class, () -> {
            new Airplane(101, "Boeing 747", 300, 25, 10);
        });

        // Test case: businessSitsNumber is  100
        Assertions.assertDoesNotThrow(() -> {
            new Airplane(101, "Boeing 747", 100, 25, 10);
        });

        // Test case: businessSitsNumber is  1 (out of range)
        Assertions.assertDoesNotThrow(() -> {
            new Airplane(101, "Boeing 747", 1, 25, 10);
        });

        // Test case: businessSitsNumber is  298 (out of range)
        Assertions.assertDoesNotThrow(() -> {
            new Airplane(101, "Boeing 747", 298, 1, 1);
        });



        // Test case: economySitsNumber is less than 1 (out of range)
        assertThrows(IllegalArgumentException.class, () -> {
            new Airplane(101, "Boeing 747", 1, 0, 10);
        });

        // Test case: economySitsNumber is greater than 298 (out of range)
        assertThrows(IllegalArgumentException.class, () -> {
            new Airplane(101, "Boeing 747", 1, 300, 10);
        });

        // Test case: economySitsNumber is  100
        Assertions.assertDoesNotThrow(() -> {
            new Airplane(101, "Boeing 747", 100, 100, 10);
        });

        // Test case: economySitsNumber is  1 (out of range)
        Assertions.assertDoesNotThrow(() -> {
            new Airplane(101, "Boeing 747", 1, 1, 10);
        });

        // Test case: economySitsNumber is  298 (out of range)
        Assertions.assertDoesNotThrow(() -> {
            new Airplane(101, "Boeing 747", 1, 298, 1);
        });




        // Test case: crewSitsNumber is less than 1 (out of range)
        assertThrows(IllegalArgumentException.class, () -> {
            new Airplane(101, "Boeing 747", 1, 1, 0);
        });

        // Test case: crewSitsNumber is greater than 298 (out of range)
        assertThrows(IllegalArgumentException.class, () -> {
            new Airplane(101, "Boeing 747", 1, 1, 300);
        });

        // Test case: crewSitsNumber is  100
        Assertions.assertDoesNotThrow(() -> {
            new Airplane(101, "Boeing 747", 100, 1, 100);
        });

        // Test case: crewSitsNumber is  1 (out of range)
        Assertions.assertDoesNotThrow(() -> {
            new Airplane(101, "Boeing 747", 1, 1, 1);
        });

        // Test case: crewSitsNumber is  298 (out of range)
        Assertions.assertDoesNotThrow(() -> {
            new Airplane(101, "Boeing 747", 1, 1, 298);
        });






    }

    // Test case 2: Invalid airplaneID (negative)
    @Test
    public void testAirplaneID() {
        // Test case 1: Negative airplaneID
        Airplane airplane = new Airplane(1, "Airbus A380", 80, 30, 15);
        assertThrows(IllegalArgumentException.class, () -> {
            airplane.setAirplaneID(-1);
        });

        // Test case 2: Zero airplaneID
        assertThrows(IllegalArgumentException.class, () -> {
            airplane.setAirplaneID(0);
        });

        // Test case 3: Positive airplaneID
        Assertions.assertDoesNotThrow(() -> {
            airplane.setAirplaneID(1);
        });


    }


    // Test case 3: Invalid airplaneModel (null)
    @Test
    public void testAirplaneModel() {
        Airplane airplane = new Airplane(102, "Airbus A380", 80, 30, 15);

        // Test case 1: setAirplaneModel with null
        assertThrows(IllegalArgumentException.class, () -> {
            airplane.setAirplaneModel(null);
        });

        // Test case 2: setAirplaneModel with empty string
        assertThrows(IllegalArgumentException.class, () -> {
            airplane.setAirplaneModel("");
        });


        // Test case 3: airplaneModel is not null or an empty string
        Assertions.assertDoesNotThrow(() -> {
            airplane.setAirplaneModel("Boeing 747");
            assertEquals("Boeing 747", airplane.getAirplaneModel());
        });
    }


    // Test case 4: Invalid businessSitsNumber (out of range)

    @Test
    public void testbusinessSitsNumber() {
        Airplane airplane = new Airplane(102, "Airbus A380", 80, 30, 15);

        // Test case: businessSitsNumber is less than 1 (out of range)
        assertThrows(IllegalArgumentException.class, () -> {
            airplane.setBusinessSitsNumber(0);
        });

        // Test case: businessSitsNumber is greater than 298 (out of range)
        assertThrows(IllegalArgumentException.class, () -> {
            airplane.setBusinessSitsNumber(300);
        });

        // Test case: businessSitsNumber is in the range [1, 298]
        Assertions.assertDoesNotThrow(() -> {
            airplane.setBusinessSitsNumber(100);
            assertEquals(100, airplane.getBusinessSitsNumber());
        });

        // Test case: businessSitsNumber is  1 (out of range)
        Assertions.assertDoesNotThrow(() -> {
            airplane.setBusinessSitsNumber(1);
        });

        // Test case: businessSitsNumber is 298 (out of range)
        Assertions.assertDoesNotThrow(() -> {
            airplane.setBusinessSitsNumber(298);
        });

    }


    // Test case 5: Invalid economySitsNumber (out of range)
    @Test
    public void testeconomySitsNumber() {
        Airplane airplane = new Airplane(102, "Airbus A380", 80, 30, 15);

        // Test case: businessSitsNumber is less than 1 (out of range)
        assertThrows(IllegalArgumentException.class, () -> {
            airplane.setEconomySitsNumber(0);
        });

        // Test case: businessSitsNumber is greater than 298 (out of range)
        assertThrows(IllegalArgumentException.class, () -> {
            airplane.setEconomySitsNumber(300);
        });

        // Test case: businessSitsNumber is in the range [1, 298]
        Assertions.assertDoesNotThrow(() -> {
            airplane.setEconomySitsNumber(100);
            assertEquals(100, airplane.getEconomySitsNumber());
        });

        // Test case: businessSitsNumber is  1 (out of range)
        Assertions.assertDoesNotThrow(() -> {
            airplane.setEconomySitsNumber(1);
        });

        // Test case: businessSitsNumber is 298 (out of range)
        Assertions.assertDoesNotThrow(() -> {
            airplane.setEconomySitsNumber(298);
        });

    }


    // Test case 6: Invalid crewSitsNumber (out of range)
    @Test
    public void testcrewSitsNumber() {

        Airplane airplane = new Airplane(102, "Airbus A380", 80, 30, 15);

        // Test case: businessSitsNumber is less than 1 (out of range)
        assertThrows(IllegalArgumentException.class, () -> {
            airplane.setCrewSitsNumber(0);
        });

        // Test case: businessSitsNumber is greater than 298 (out of range)
        assertThrows(IllegalArgumentException.class, () -> {
            airplane.setCrewSitsNumber(300);
        });

        // Test case: businessSitsNumber is in the range [1, 298]
        Assertions.assertDoesNotThrow(() -> {
            airplane.setCrewSitsNumber(100);
            assertEquals(100, airplane.getCrewSitsNumber());
        });

        // Test case: businessSitsNumber is  1 (out of range)
        Assertions.assertDoesNotThrow(() -> {
            airplane.setCrewSitsNumber(1);
        });

        // Test case: businessSitsNumber is 298 (out of range)
        Assertions.assertDoesNotThrow(() -> {
            airplane.setCrewSitsNumber(298);
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

    // Test case 8: toString

    @Test
    public void testToString() {
        // Create an instance of the Airplane class with some sample data
        Airplane airplane = new Airplane(106, "Boeing 787", 30, 200, 10);

        // Define the expected output based on the sample data
        String expectedOutput = "Airplane{" +
                "model=Boeing 787'" +
                ", business sits=30'" +
                ", economy sits=200'" +
                ", crew sits=10'" +
                '}';

        // Call the toString() method and compare the result with the expected output
        assertEquals(expectedOutput, airplane.toString());
    }

    // Test case 9: GetAirPlaneInfo

    @Test
    public void testGetAirPlaneInfo() {
        // Test with a valid airplane_id
        int validAirplaneId = 123;
        Airplane airplane = Airplane.getAirPlaneInfo(validAirplaneId);
        if(airplane.getAirplaneID() != 888)
        {
            assertNull(airplane);
        }
        // The function returns null, so the test should pass

        // Test with an invalid airplane_id (non-existent ID or out of range)
        int invalidAirplaneId = -1; // Assuming -1 is an invalid airplane_id
        airplane = Airplane.getAirPlaneInfo(invalidAirplaneId);
        if(airplane.getAirplaneID() != 888)
        {
            assertNull(airplane);
        }
         // The function should still return null for invalid IDs
    }

}



