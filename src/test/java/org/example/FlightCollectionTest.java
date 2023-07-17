package org.example;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightCollectionTest {
    private Flight flight1;
    private Flight flight2;

    @BeforeEach
    void setUp() {
        flight1 = new Flight(1, "Suzhou", "Shanghai", "AB123", "Airline", null, null, null);
        flight2 = new Flight(2, "Shanghai", "Beijing", "BC456", "Airline", null, null, null);
    }
    @Test
    void getFlights() {
        // Add flights to the collection
        ArrayList<Flight> flights = new ArrayList<>();
        flights.add(flight1);

        FlightCollection.addFlights(flights);

        // Retrieve the flights and assert the collection matches
        ArrayList<Flight> retrievedFlights = FlightCollection.getFlights();
        assertEquals(flights, retrievedFlights);
    }

    @Test
    void addFlights() {
        // Create a new flight and add it to the collection
        Flight newFlight = new Flight(4, "Beijing", "Shenzhen", "CD012", "Airline", null, null, null);

        ArrayList<Flight> retrievedFlights = FlightCollection.getFlights();

        if (!retrievedFlights.contains(newFlight)) {
            FlightCollection.addFlights(new ArrayList<>(List.of(newFlight)));
        } else {
            fail("Flight with the same ID already exists in the system: " + newFlight.getFlightID());
        }

        // Retrieve the flights again and assert that the new flight is present
        retrievedFlights = FlightCollection.getFlights();
        assertTrue(retrievedFlights.contains(newFlight));
    }


    @Test
    void testValidCityNames() {
        // Create a new flight with valid city names
        Flight validFlight = new Flight(4, "Nanjing", "Shenzhen", "DE012", "Airline", null, null, null);

        // Add the new flight to the FlightCollection
        FlightCollection.addFlights(new ArrayList<>(List.of(validFlight)));

        // Retrieve the flights from FlightCollection
        ArrayList<Flight> retrievedFlights = FlightCollection.getFlights();

        // Assert that the new flight is present in the collection
        assertTrue(retrievedFlights.contains(validFlight));
    }

    @Test
    void getFlightInfo() {
        // Add flights to the FlightCollection
        FlightCollection.addFlights(new ArrayList<>(List.of(flight1, flight2)));

        // Test getting flight information by city
        String city = "Shanghai";
        Flight matchingFlight = FlightCollection.getFlightInfo(city);

        // Assert that a flight departing to the given city is returned
        assertNotNull(matchingFlight);
        assertEquals(city, matchingFlight.getDepartTo());
    }


}