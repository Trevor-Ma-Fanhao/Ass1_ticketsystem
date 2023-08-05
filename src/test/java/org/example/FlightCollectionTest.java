package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

public class FlightCollectionTest {

    @BeforeEach
    public void setUp() {
        // Clear the flights list before each test to start with an empty list
        FlightCollection.flights = new ArrayList<>();
    }

    @Test
    public void testAddFlights_ValidFlights_Successful() {
        // Test case 1: Valid flights
        // Create a list of valid flights
        ArrayList<Flight> validFlights = new ArrayList<>();
        Airplane airplane1 = new Airplane(1, "Boeing 747", 50, 25, 10);

        // Initialize the dateFrom and dateTo Timestamps (1 hour and 2 hours from now)
        Timestamp dateFrom = Timestamp.from(Instant.now().plusSeconds(3600));
        Timestamp dateTo = Timestamp.from(Instant.now().plusSeconds(7200));


        Flight flight1 = new Flight(1, "Suzhou", "Nanjing", "ABC123", "East", dateFrom, dateTo, airplane1);
        validFlights.add(flight1);

        Airplane airplane2 = new Airplane(2, "Airbus A320", 40, 20, 8);
        Flight flight2 = new Flight(2, "Nanjing", "Suzhou", "XYZ789", "East", dateFrom, dateTo, airplane2);
        validFlights.add(flight2);

        // Call the addFlights method with the valid flight list
        Assertions.assertDoesNotThrow(() -> {
            FlightCollection.addFlights(validFlights);
        });

        // Assert that the flights have been added successfully to the FlightCollection.flights list
        Assertions.assertEquals(2, FlightCollection.flights.size());
    }

    @Test
    public void testAddFlights_NullFlightCollection_ThrowsIllegalArgumentException() {
        // Test case 2: Null flight collection
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            FlightCollection.addFlights(null);
        });
    }

    @Test
    public void testAddFlights_NullFlightInCollection_ThrowsIllegalArgumentException() {
        // Test case 3: Flight collection containing a null flight
        ArrayList<Flight> flightCollectionWithNull = new ArrayList<>();
        flightCollectionWithNull.add(null);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            FlightCollection.addFlights(flightCollectionWithNull);
        });
    }

}
