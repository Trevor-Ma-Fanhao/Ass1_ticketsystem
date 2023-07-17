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
        flight1 = new Flight(1, "CityA", "CityB", "AB123", "Airline", null, null, null);
        flight2 = new Flight(2, "CityB", "CityC", "BC456", "Airline", null, null, null);
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
        Flight newFlight = new Flight(4, "CityC", "CityD", "CD012", "Airline", null, null, null);

        FlightCollection.addFlights(new ArrayList<>(List.of(newFlight)));

        // Retrieve the flights and assert that the new flight is present
        ArrayList<Flight> retrievedFlights = FlightCollection.getFlights();
        assertTrue(retrievedFlights.contains(newFlight));
    }
    @Test
    void testValidCityNames() {
        // Create a new flight with valid city names
        Flight validFlight = new Flight(4, "CityD", "CityE", "DE012", "Airline", null, null, null);

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
        String city = "CityB";
        Flight matchingFlight = FlightCollection.getFlightInfo(city);

        // Assert that a flight departing to the given city is returned
        assertNotNull(matchingFlight);
        assertEquals(city, matchingFlight.getDepartTo());
    }


}