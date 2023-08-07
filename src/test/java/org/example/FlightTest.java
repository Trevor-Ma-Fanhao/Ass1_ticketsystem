package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.sql.Timestamp;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

import static org.junit.Assert.assertEquals;


public class FlightTest {

    private Flight flight;
    private Airplane airplane;

    @BeforeEach
    public void setUp() {
        // Initialize the Airplane object
        airplane = new Airplane(1, "Boeing 747", 50, 25, 10);

        // Initialize the dateFrom and dateTo Timestamps (1 hour and 2 hours from now)
        String dateFrom = "10/08/23 14:25:30";
        String dateTo = "10/08/23 15:25:30";

        // Initialize the Flight object
        flight = new Flight(1, "Suzhou", "Nanjing", "ABC123", "East", dateFrom, dateTo, airplane);
    }

    @Test
    public void testEmptyConstructor() {
        // Test case: Create Flight object using empty constructor
        Assertions.assertDoesNotThrow(() -> {
            Flight flight = new Flight();
            assertNotNull(flight); // Ensure the object is not null
            // You can add more specific assertions if needed
        });
    }

    @Test
    public void testFlightCreation() {

        String dateFrom = "10/08/23 14:25:30";
        String dateTo = "10/08/23 15:25:30";

        // Test case 1: Valid flightID (positive)
        Assertions.assertDoesNotThrow(() -> {
            flight = new Flight(1, "Suzhou", "Nanjing", "ABC123", "East", dateFrom, dateTo, airplane);
            assertEquals(1,flight.getFlightID());
            assertEquals("Suzhou",flight.getDepartTo());
            assertEquals("Nanjing",flight.getDepartFrom());
            assertEquals("ABC123",flight.getCode());
            assertEquals("East",flight.getCompany());
            assertEquals("10/08/23 14:25:30",flight.getDateFrom());
            assertEquals("10/08/23 15:25:30",flight.getDateTo());
            assertEquals(airplane,flight.getAirplane());

        });


        // Test case 2: Invalid flightID (negative)
        assertThrows(IllegalArgumentException.class, () -> {
            new Flight(-1, "Suzhou", "Nanjing", "ABC123", "East", dateFrom, dateTo, airplane);

        });


        // Test case 3: Invalid flightID (zero)
        assertThrows(IllegalArgumentException.class, () -> {
            new Flight(0, "Suzhou", "Nanjing", "ABC123", "East", dateFrom, dateTo, airplane);

        });

        // Test case 4: Invalid dateFrom
        assertThrows(IllegalArgumentException.class, () -> {
            flight.setDateFrom("10/13/23 14:25:30");
        });

        // Test case 5: Invalid dateTo
        assertThrows(IllegalArgumentException.class, () -> {
            flight.setDateTo("10/13/23 14:25:30");
        });
    }


    @Test
    public void testSetFlightID() {

        // Test case 1: Valid flightID (positive)
        Assertions.assertDoesNotThrow(() -> {
            flight.setFlightID(1);
        });


        // Test case 2: Invalid flightID (non-positive)
        assertThrows(IllegalArgumentException.class, () -> {
            flight.setFlightID(0);
        });

        // Test case 3: Invalid flightID (non-positive)
        assertThrows(IllegalArgumentException.class, () -> {
            flight.setFlightID(-1);
        });

    }



    // Test case 3: Invalid departFrom (null)
    @Test
    public void testDepartFrom() {
        String dateFrom = "10/08/23 14:25:30";
        String dateTo = "10/08/23 15:25:30";

        // Test case : Valid departFrom (non-null)
        Assertions.assertDoesNotThrow(() -> {
            new Flight(1, "Suzhou", "Nanjing", "ABC123", "East", dateFrom, dateTo, airplane);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Flight(1, "Suzhou", "", "ABC123", "East", dateFrom, dateTo, airplane);

        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Flight(1, "Suzhou", null, "ABC123", "East", dateFrom, dateTo, airplane);

        });


        Assertions.assertDoesNotThrow(() -> {
            flight.setDepartFrom("Nanjing");
        });


        assertThrows(IllegalArgumentException.class, () -> {
            flight.setDepartFrom(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            flight.setDepartFrom("");
        });


    }

    @Test
    public void testDepartTo() {
        String dateFrom = "10/08/23 14:25:30";
        String dateTo = "10/08/23 15:25:30";

        // Test case : Valid departFrom (non-null)
        Assertions.assertDoesNotThrow(() -> {
            new Flight(1, "Suzhou", "Nanjing", "ABC123", "East", dateFrom, dateTo, airplane);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Flight(1, "", "Nanjing", "ABC123", "East", dateFrom, dateTo, airplane);

        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Flight(1, null, "Nanjing", "ABC123", "East", dateFrom, dateTo, airplane);

        });

        Assertions.assertDoesNotThrow(() -> {
            flight.setDepartTo("Suzhou");
        });


        assertThrows(IllegalArgumentException.class, () -> {
            flight.setDepartTo(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            flight.setDepartTo("");
        });


    }
    // Test case 5: Invalid code (null)
    @Test
    public void testCode() {
        // Assert that setting code to null throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            flight.setCode(null);
        });

        Assertions.assertDoesNotThrow(() -> {
            flight.setCode("ABC123");
        });

        String dateFrom = "10/08/23 14:25:30";
        String dateTo = "10/08/23 15:25:30";
        assertThrows(IllegalArgumentException.class, () -> {
            new Flight(1, "Suzhou", "Nanjing", null, "East", dateFrom, dateTo, airplane);

        });


    }

    // Test case 7: Invalid company (null)
    @Test
    public void testCompany() {

        // Assert that setting company to null throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            flight.setCompany(null);
        });


        Assertions.assertDoesNotThrow(() -> {
            flight.setCompany("East");
        });


        String dateFrom = "10/08/23 14:25:30";
        String dateTo = "10/08/23 15:25:30";
        assertThrows(IllegalArgumentException.class, () -> {
            new Flight(1, "Suzhou", "Nanjing", "ABC123", null, dateFrom, dateTo, airplane);

        });

    }

    // Test case 9: Invalid dateFrom (in the past)
    @Test
    public void testDateFrom() {

        String dateFrom = "10/08/23 14:25:30";
        String dateTo = "10/08/23 15:25:30";
        Flight flight = new Flight(1, "Suzhou", "Nanjing", "ABC123", "East", dateFrom, dateTo, airplane);

        // Test case 1: Valid dateFrom (in the future)
        Assertions.assertDoesNotThrow(() -> {
            new Flight(1, "Suzhou", "Nanjing", "ABC123", "East", dateFrom, dateTo, airplane);
        });

        // Test case 2: Valid dateFrom (current date)
        Assertions.assertDoesNotThrow(() -> {
            String currentDate = "10/08/23 14:00:00";
            new Flight(2, "Suzhou", "Nanjing", "XYZ789", "West", currentDate, dateTo, airplane);
        });



        Assertions.assertDoesNotThrow(() -> {
            flight.setDateFrom(dateFrom);
        });
        // Test case 3: Invalid dateFrom (null)
        assertThrows(IllegalArgumentException.class, () -> {
            flight.setDateFrom(null);
        });

        // Test case 4: Invalid dateFrom (invalid format)
        assertThrows(IllegalArgumentException.class, () -> {
            flight.setDateFrom("2023-08-10");
        });

        // Test case 5: Invalid dateFrom (invalid time format)
        assertThrows(IllegalArgumentException.class, () -> {
            flight.setDateFrom("10/08/23 14:25");
        });

    }

    @Test
    public void testSetDateTo() {
        String dateFrom = "10/08/23 14:25:30";
        String dateTo = "10/08/23 15:25:30";
        Flight flight = new Flight(1, "Suzhou", "Nanjing", "ABC123", "East", dateFrom, dateTo, airplane);

        // Test case 1: Valid dateTo (in the future)
        Assertions.assertDoesNotThrow(() -> {
            flight.setDateTo("10/08/23 16:00:00");
        });

        // Test case 2: Valid dateTo (current date)
        Assertions.assertDoesNotThrow(() -> {
            String currentDate = "10/08/23 14:00:00";
            flight.setDateTo(currentDate);
        });

        // Test case 3: Invalid dateTo (null)
        assertThrows(IllegalArgumentException.class, () -> {
            flight.setDateTo(null);
        });

        // Test case 4: Invalid dateTo (invalid format)
        assertThrows(IllegalArgumentException.class, () -> {
            flight.setDateTo("2023-08-10");
        });

        // Test case 5: Invalid dateTo (invalid time format)
        assertThrows(IllegalArgumentException.class, () -> {
            flight.setDateTo("10/08/23 15:25");
        });
    }

    @Test
    public void testInvalidDateFormat() {
        // Test case 1: Valid date format
        assertTrue(flight.isValidDateFormat("10/08/23 14:25:30"));

        // Test case 2: Invalid date format (incorrect separator)
        assertFalse(flight.isValidDateFormat("10-08-23 14:25:30"));

        // Test case 3: Invalid date format (non-numeric characters)
        assertFalse(flight.isValidDateFormat("10/08/XX 14:25:30"));

        // Test case 4: Invalid date format (invalid day)
        assertFalse(flight.isValidDateFormat("32/08/23 14:25:30"));
        assertFalse(flight.isValidDateFormat("00/08/23 14:25:30"));
        assertTrue(flight.isValidDateFormat("01/08/23 14:25:30"));
        assertTrue(flight.isValidDateFormat("31/08/23 14:25:30"));

        // Test case 5: Invalid date format (invalid month)
        assertFalse(flight.isValidDateFormat("10/00/23 14:25:30"));
        assertFalse(flight.isValidDateFormat("10/13/23 14:25:30"));
        assertTrue(flight.isValidDateFormat("10/01/23 14:25:30"));
        assertTrue(flight.isValidDateFormat("10/12/23 14:25:30"));

        // Test case 6: Invalid date format (invalid year)
        assertFalse(flight.isValidDateFormat("10/12/-1 14:25:30"));
        assertFalse(flight.isValidDateFormat("10/12/100 14:25:30"));
    }




    @Test
    public void testInvalidTimeFormat() throws DateTimeParseException {
        // Test case 1: Valid time format
        assertTrue(flight.isValidTimeFormat("10/08/23 14:25:30"));

        // Test case 2: Invalid time format (incorrect separator)
        assertFalse(flight.isValidTimeFormat("10-08-23 14:25:30"));

        // Test case 3: Invalid time format (non-numeric characters)
        assertFalse(flight.isValidTimeFormat("10/08/23 14:25:XX"));

        // Test case 4: Invalid time format (invalid hour)
        assertFalse(flight.isValidTimeFormat("10/08/23 -1:25:30"));
        assertFalse(flight.isValidTimeFormat("10/08/23 24:25:30"));
        assertTrue(flight.isValidTimeFormat("10/08/23 00:25:30"));
        assertTrue(flight.isValidTimeFormat("10/08/23 23:25:30"));

        // Test case 5: Invalid time format (invalid minute)
        assertTrue(flight.isValidTimeFormat("10/08/23 14:59:30"));
        assertTrue(flight.isValidTimeFormat("10/08/23 14:00:30"));
        assertFalse(flight.isValidTimeFormat("10/08/23 14:60:30"));
        assertFalse(flight.isValidTimeFormat("10/08/23 14:-1:30"));

        // Test case 6: Invalid time format (invalid second)
        assertTrue(flight.isValidTimeFormat("10/08/23 14:59:59"));
        assertTrue(flight.isValidTimeFormat("10/08/23 14:00:00"));
        assertFalse(flight.isValidTimeFormat("10/08/23 14:00:-1"));
        assertFalse(flight.isValidTimeFormat("10/08/23 14:00:60"));
    }




    // Test case 13: Invalid airplane (null)
    @Test
    public void testAirplane() {
        String dateFrom = "10/08/23 14:25:30";
        String dateTo = "10/08/23 15:25:30";

        assertThrows(IllegalArgumentException.class, () -> {
            new Flight(1, "Suzhou", "Nanjing", "ABC123", "East", dateFrom, dateTo, null);
        });

        // Test case 14: Valid airplane (non-null)
        Airplane airplane = new Airplane(101, "Boeing 747", 50, 25, 10);
        Assertions.assertDoesNotThrow(() -> {
            new Flight(1, "Suzhou", "Nanjing", "ABC123", "East", dateFrom, dateTo, airplane);
        });

        Assertions.assertDoesNotThrow(() -> {
            flight.setAirplane(airplane);
        });

        // Assert that setting airplane to null throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            flight.setAirplane(null);
        });


    }


    @Test
    public void testToString() throws ParseException {

        String dateFrom = "10/08/23 14:25:30";
        String dateTo = "10/08/23 15:25:30";

        Flight flight = new Flight(1, "Suzhou", "Nanjing", "ABC123", "East", dateFrom, dateTo, airplane);


        // Define the expected output based on the sample data
        String expectedOutput = "Flight{" + "Airplane{model=Boeing 747', business sits=50', economy sits=25', crew sits=10'}" +
                ", date to=" + "10/08/23 15:25:30" + ", " + '\'' +
                ", date from='" +   "10/08/23 14:25:30" + '\'' +
                ", depart from='" + "Nanjing" + '\'' +
                ", depart to='" + "Suzhou" + '\'' +
                ", code=" + "ABC123" + '\'' +
                ", company=" + "East'" +
                '}';

        // Call the toString() method and compare the result with the expected output
        Assertions.assertEquals(expectedOutput, flight.toString());
    }










}