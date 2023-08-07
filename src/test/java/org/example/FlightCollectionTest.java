package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class FlightCollectionTest {
    private FlightCollection flightCollection;
    @BeforeEach
    public void setUp() {
        // Clear the flights list before each test to start with an empty list
        flightCollection = new FlightCollection();
    }

    @Test
    public void testGetFlights() {
        // Create and add flights to the flights list
        ArrayList<Flight> flights = new ArrayList<>();
        Airplane airplane1 = new Airplane(1, "Boeing 747", 50, 25, 10);
        String dateFrom = "10/08/23 14:25:30";
        String dateTo = "10/08/23 15:25:30";
        Flight flight1 = new Flight(1, "Suzhou", "Nanjing", "ABC123", "East", dateFrom, dateTo, airplane1);
        flights.add(flight1);
        Airplane airplane2 = new Airplane(2, "Airbus A320", 40, 20, 8);
        Flight flight2 = new Flight(2, "Nanjing", "Suzhou", "XYZ789", "East", dateFrom, dateTo, airplane2);
        flights.add(flight2);


        // Call the getFlights method and assert the result
        flightCollection.addFlights(flights);
        ArrayList<Flight> returnedFlights = flightCollection.getFlights();
        assertEquals(flights, returnedFlights);
    }

    @Test
    public void testAddFlights() {
        // Test case 1: Valid flights
        // Create a list of valid flights
        ArrayList<Flight> validFlights = new ArrayList<>();
        Airplane airplane1 = new Airplane(1, "Boeing 747", 50, 25, 10);

        // Initialize the dateFrom and dateTo Timestamps (1 hour and 2 hours from now)
        String dateFrom = "10/08/23 14:25:30";
        String dateTo = "10/08/23 15:25:30";


        Flight flight1 = new Flight(1, "Suzhou", "Nanjing", "ABC123", "East", dateFrom, dateTo, airplane1);
        validFlights.add(flight1);

        Airplane airplane2 = new Airplane(2, "Airbus A320", 40, 20, 8);
        Flight flight2 = new Flight(2, "Nanjing", "Suzhou", "XYZ789", "East", dateFrom, dateTo, airplane2);
        validFlights.add(flight2);

        // Call the addFlights method with the valid flight list
        Assertions.assertDoesNotThrow(() -> {
            flightCollection.addFlights(validFlights);
        });
        // Test case 2: Null flight collection
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            flightCollection.addFlights(null);
        });

        // Test case 3: Flight collection containing a null flight
        ArrayList<Flight> flightCollectionWithNull = new ArrayList<>();
        flightCollectionWithNull.add(null);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            flightCollection.addFlights(flightCollectionWithNull);
        });

    }


    @Test
    public void testValidateCity() {



        // Test case 1: Valid city name
        Assertions.assertTrue(flightCollection.validateCity("New York"));
        Assertions.assertTrue(flightCollection.validateCity("Los Angeles"));

        // Test case 2: Empty city name
        Assertions.assertFalse(flightCollection.validateCity(null));

    }


    @Test
    public void testGetFlightInfo_ByFlightID() {
        Airplane airplane1 = new Airplane(1, "Boeing 747", 50, 25, 10);
        Airplane airplane2 = new Airplane(2, "Airbus A320", 40, 20, 8);

        Flight flight1 = new Flight(1, "CityA", "CityB", "ABC123", "Airline1", "10/08/23 14:25:30", "10/08/23 15:25:30", airplane1);
        Flight flight2 = new Flight(2, "CityB", "CityC", "XYZ789", "Airline2", "10/08/23 16:00:00", "10/08/23 17:00:00", airplane2);
        flightCollection.flights.add(flight1);
        flightCollection.flights.add(flight2);

        // Test case 1: Valid flight_id
        Flight result1 = flightCollection.getFlightInfo(1);
        Assertions.assertNotNull(result1);
        Assertions.assertEquals(1, result1.getFlightID());

        // Test case 2: Invalid flight_id
        Flight result2 = flightCollection.getFlightInfo(3);
        Assertions.assertNull(result2);

    }

    @Test
    public void testGetFlightInfo_ByCity() {
        Airplane airplane1 = new Airplane(1, "Boeing 747", 50, 25, 10);
        Airplane airplane2 = new Airplane(2, "Airbus A320", 40, 20, 8);

        Flight flight1 = new Flight(1, "CityA", "CityB", "ABC123", "Airline1", "10/08/23 14:25:30", "10/08/23 15:25:30", airplane1);
        Flight flight2 = new Flight(2, "CityB", "CityC", "XYZ789", "Airline2", "10/08/23 16:00:00", "10/08/23 17:00:00", airplane2);
        flightCollection.flights.add(flight1);
        flightCollection.flights.add(flight2);

        // Test case: Valid city name
        Flight resultValidCity = flightCollection.getFlightInfo("CityB");
        Assertions.assertNotNull(resultValidCity);
        Assertions.assertEquals("CityB", resultValidCity.getDepartTo());

        // Test case: Invalid city name
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            flightCollection.getFlightInfo(null);
        });

        // Test case: No matching flight
        Flight result = flightCollection.getFlightInfo("CityD");
        Assertions.assertNull(result);
    }

    @Test
    public void testGetFlightInfo_ByCities() {
        Airplane airplane1 = new Airplane(1, "Boeing 747", 50, 25, 10);
        Airplane airplane2 = new Airplane(2, "Airbus A320", 40, 20, 8);

        Flight flight1 = new Flight(1, "CityA", "CityB", "ABC123", "Airline1", "10/08/23 14:25:30", "10/08/23 15:25:30", airplane1);
        Flight flight2 = new Flight(2, "CityB", "CityC", "XYZ789", "Airline2", "10/08/23 16:00:00", "10/08/23 17:00:00", airplane2);
        flightCollection.flights.add(flight1);
        flightCollection.flights.add(flight2);

        // Test case: Matching direct flight
        Flight result = flightCollection.getFlightInfo("CityB", "CityA");
        Assertions.assertEquals(flight1, result);

        // Test case: No matching direct flight
        result = flightCollection.getFlightInfo("CityA", "CityC");
        Assertions.assertNull(result);

        // Test case: Invalid cities
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            flightCollection.getFlightInfo(null, null);
        });

    }

}