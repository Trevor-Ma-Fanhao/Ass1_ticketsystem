package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.sql.Timestamp;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Instant;
import static org.junit.Assert.assertEquals;

public class FlightTest {

    private Flight flight;
    private Airplane airplane;

    @BeforeEach
    public void setUp() {
        // Initialize the Airplane object
        airplane = new Airplane(1, "Boeing 747", 50, 25, 10);

        // Initialize the dateFrom and dateTo Timestamps (1 hour and 2 hours from now)
        Timestamp dateFrom = Timestamp.from(Instant.now().plusSeconds(3600));
        Timestamp dateTo = Timestamp.from(Instant.now().plusSeconds(7200));

        // Initialize the Flight object
        flight = new Flight(1, "Suzhou", "Nanjing", "ABC123", "East", dateFrom, dateTo, airplane);
    }

    @Test
    public void testFlightCreation() {
        // Test case 1: Invalid flightID (negative)
        assertThrows(IllegalArgumentException.class, () -> {
            Airplane airplane = new Airplane(-1, "Boeing 747", 50, 25, 10);
            Timestamp dateFrom = Timestamp.from(Instant.now().plusSeconds(3600)); // 1 hour from now
            Timestamp dateTo = Timestamp.from(Instant.now().plusSeconds(7200)); // 2 hours from now

            Flight flight = new Flight(-1, "Suzhou", "Nanjing", "ABC123", "East", dateFrom, dateTo, airplane);
            assertEquals(-1, flight.getFlightID());
            assertEquals("Suzhou", flight.getDepartTo());
            assertEquals("Nanjing", flight.getDepartFrom());
            assertEquals("ABC123", flight.getCode());
            assertEquals("East", flight.getCompany());
            assertEquals(dateFrom, flight.getDateFrom());
            assertEquals(dateTo, flight.getDateTo());
            assertEquals(airplane, flight.getAirplane());
        });

        // Test case 2: Valid flightID (positive)
        Assertions.assertDoesNotThrow(() -> {
            Airplane airplane = new Airplane(1, "Boeing 747", 50, 25, 10);
            Timestamp dateFrom = Timestamp.from(Instant.now().plusSeconds(3600)); // 1 hour from now
            Timestamp dateTo = Timestamp.from(Instant.now().plusSeconds(7200)); // 2 hours from now

            Flight flight = new Flight(1, "Suzhou", "Nanjing", "ABC123", "East", dateFrom, dateTo, airplane);
            assertEquals(1, flight.getFlightID());
            assertEquals("Suzhou", flight.getDepartTo());
            assertEquals("Nanjing", flight.getDepartFrom());
            assertEquals("ABC123", flight.getCode());
            assertEquals("East", flight.getCompany());
            assertEquals(dateFrom, flight.getDateFrom());
            assertEquals(dateTo, flight.getDateTo());
            assertEquals(airplane, flight.getAirplane());
        });
    }

    // Test case 3: Invalid departFrom (null)
    @Test
    public void testDepartFrom() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Flight(1, null, "Nanjing", "ABC123", "East", Timestamp.from(Instant.now()), Timestamp.from(Instant.now()), airplane);
        });

        // Test case 4: Valid departFrom (non-null)
        Assertions.assertDoesNotThrow(() -> {
            new Flight(1, "Suzhou", "Nanjing", "ABC123", "East", Timestamp.from(Instant.now()), Timestamp.from(Instant.now()), airplane);
        });
    }

    // Test case 5: Invalid code (null)
    @Test
    public void testCode() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Flight(1, "Suzhou", "Nanjing", null, "East", Timestamp.from(Instant.now()), Timestamp.from(Instant.now()), airplane);
        });

        // Test case 6: Valid code (non-null)
        Assertions.assertDoesNotThrow(() -> {
            new Flight(1, "Suzhou", "Nanjing", "ABC123", "East", Timestamp.from(Instant.now()), Timestamp.from(Instant.now()), airplane);
        });
    }

    // Test case 7: Invalid company (null)
    @Test
    public void testCompany() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Flight(1, "Suzhou", "Nanjing", "ABC123", null, Timestamp.from(Instant.now()), Timestamp.from(Instant.now()), airplane);
        });

        // Test case 8: Valid company (non-null)
        Assertions.assertDoesNotThrow(() -> {
            new Flight(1, "Suzhou", "Nanjing", "ABC123", "East", Timestamp.from(Instant.now()), Timestamp.from(Instant.now()), airplane);
        });
    }

    // Test case 9: Invalid dateFrom (in the past)
    @Test
    public void testDateFrom() {
        Timestamp pastDate = Timestamp.from(Instant.now().minusSeconds(3600)); // 1 hour ago

        assertThrows(IllegalArgumentException.class, () -> {
            new Flight(1, "Suzhou", "Nanjing", "ABC123", "East", pastDate, Timestamp.from(Instant.now()), airplane);
        });

        // Test case 10: Valid dateFrom (in the future)
        Assertions.assertDoesNotThrow(() -> {
            new Flight(1, "Suzhou", "Nanjing", "ABC123", "East", Timestamp.from(Instant.now()), Timestamp.from(Instant.now()), airplane);
        });
    }

//     Test case 11: Invalid dateTo (in the past and before dateFrom)
    @Test
    public void testDateTo() {
        Timestamp pastDate = Timestamp.from(Instant.now().minusSeconds(3600)); // 1 hour ago
        Timestamp futureDate = Timestamp.from(Instant.now().plusSeconds(3600)); // 1 hour from now

        assertThrows(IllegalArgumentException.class, () -> {
            new Flight(1, "Suzhou", "Nanjing", "ABC123", "East", Timestamp.from(Instant.now()), pastDate, airplane);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Flight(1, "Suzhou", "Nanjing", "ABC123", "East", pastDate, futureDate, airplane);
        });

        // Test case 12: Valid dateTo (in the future and after dateFrom)
        Assertions.assertDoesNotThrow(() -> {
            new Flight(1, "Suzhou", "Nanjing", "ABC123", "East", Timestamp.from(Instant.now()), futureDate, airplane);
        });
    }

    @Test
    public void testInvalidDateFormat() {
        // Test case 1: valid date format
        Assertions.assertDoesNotThrow(() -> {
                Timestamp invalidDateTimestamp1 = Timestamp.valueOf("2023-07-15 00:00:00");
                flight.isValidDateFormat(invalidDateTimestamp1);
        });

        // Test case 2: Invalid date format (incorrect separator)
        assertThrows(IllegalArgumentException.class, () -> {
            Timestamp invalidDateTimestamp2 = Timestamp.valueOf("2023/07/15 00:00:00");
            flight.isValidDateFormat(invalidDateTimestamp2);
        });

        // Test case 3: Invalid date format (non-numeric characters)
        assertThrows(IllegalArgumentException.class, () -> {
            Timestamp invalidDateTimestamp3 = Timestamp.valueOf("2023-07-XX 00:00:00");
            flight.isValidDateFormat(invalidDateTimestamp3);
        });
    }

    @Test
    public void testInvalidTimeFormat() {
        // Test case 1: valid time format
        Assertions.assertDoesNotThrow(() -> {
            Timestamp invalidTimeTimestamp1 = Timestamp.valueOf("2023-07-15 12:30:00");
            Flight.isValidTimeFormat(invalidTimeTimestamp1);
        });

        // Test case 2: Invalid time format (incorrect separator)
        assertThrows(IllegalArgumentException.class, () -> {
            Timestamp invalidTimeTimestamp2 = Timestamp.valueOf("2023-07-15 12-30-00");
            Flight.isValidTimeFormat(invalidTimeTimestamp2);
        });

        // Test case 3: Invalid time format (non-numeric characters)
        assertThrows(IllegalArgumentException.class, () -> {
            Timestamp invalidTimeTimestamp3 = Timestamp.valueOf("2023-07-15 12:30:XX");
            Flight.isValidTimeFormat(invalidTimeTimestamp3);
        });
    }


    // Test case 13: Invalid airplane (null)
    @Test
    public void testAirplane() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Flight(1, "Suzhou", "Nanjing", "ABC123", "East", Timestamp.from(Instant.now()), Timestamp.from(Instant.now()), null);
        });

        // Test case 14: Valid airplane (non-null)
        Airplane airplane = new Airplane(101, "Boeing 747", 50, 25, 10);
        Assertions.assertDoesNotThrow(() -> {
            new Flight(1, "Suzhou", "Nanjing", "ABC123", "East", Timestamp.from(Instant.now()), Timestamp.from(Instant.now()), airplane);
        });
    }
}