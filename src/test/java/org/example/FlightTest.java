package org.example;

import org.junit.jupiter.api.Test;
import java.sql.Timestamp;
import static org.junit.jupiter.api.Assertions.*;

class FlightTest {

    private Airplane airplane = new Airplane(1, "Boeing 747", 10, 200, 5);
    private Timestamp dateFrom = Timestamp.valueOf("2023-07-01 12:00:00");
    private Timestamp dateTo = Timestamp.valueOf("2023-07-01 14:00:00");
    private Flight flight = new Flight(1, "CityA", "CityB", "AB123", "Airline", dateFrom, dateTo, airplane);

    @Test
    void getFlightID() {
        int expectedFlightID = 1;
        int actualFlightID = flight.getFlightID();
        assertEquals(expectedFlightID, actualFlightID);
    }

    @Test
    void setFlightID() {
        int newFlightID = 2;
        flight.setFlightID(newFlightID);
        assertEquals(newFlightID, flight.getFlightID());
    }

    @Test
    void getDepartTo() {
        String expectedDepartTo = "CityA";
        String actualDepartTo = flight.getDepartTo();
        assertEquals(expectedDepartTo, actualDepartTo);
    }

    @Test
    void setDepartTo() {
        String newDepartTo = "CityC";
        flight.setDepartTo(newDepartTo);
        assertEquals(newDepartTo, flight.getDepartTo());
    }

    @Test
    void getDepartFrom() {
        String expectedDepartFrom = "CityB";
        String actualDepartFrom = flight.getDepartFrom();
        assertEquals(expectedDepartFrom, actualDepartFrom);
    }

    @Test
    void setDepartFrom() {
        String newDepartFrom = "CityD";
        flight.setDepartFrom(newDepartFrom);
        assertEquals(newDepartFrom, flight.getDepartFrom());
    }

    @Test
    void getCode() {
        String expectedCode = "AB123";
        String actualCode = flight.getCode();
        assertEquals(expectedCode, actualCode);
    }

    @Test
    void setCode() {
        String newCode = "CD456";
        flight.setCode(newCode);
        assertEquals(newCode, flight.getCode());
    }

    @Test
    void getCompany() {
        String expectedCompany = "Airline";
        String actualCompany = flight.getCompany();
        assertEquals(expectedCompany, actualCompany);
    }

    @Test
    void setCompany() {
        String newCompany = "New Airline";
        flight.setCompany(newCompany);
        assertEquals(newCompany, flight.getCompany());
    }

    @Test
    void getDateFrom() {
        Timestamp expectedDateFrom = Timestamp.valueOf("2023-07-01 12:00:00");
        Timestamp actualDateFrom = flight.getDateFrom();
        assertEquals(expectedDateFrom, actualDateFrom);
    }

    @Test
    void setDateFrom() {
        Timestamp newDateFrom = Timestamp.valueOf("2023-07-02 10:00:00");
        flight.setDateFrom(newDateFrom);
        assertEquals(newDateFrom, flight.getDateFrom());
    }

    @Test
    void getDateTo() {
        Timestamp expectedDateTo = Timestamp.valueOf("2023-07-01 14:00:00");
        Timestamp actualDateTo = flight.getDateTo();
        assertEquals(expectedDateTo, actualDateTo);
    }

    @Test
    void setDateTo() {
        Timestamp newDateTo = Timestamp.valueOf("2023-07-02 12:00:00");
        flight.setDateTo(newDateTo);
        assertEquals(newDateTo, flight.getDateTo());
    }

    @Test
    void setAirplane() {
        Airplane newAirplane = new Airplane(2, "Airbus A380", 20, 300, 10);
        flight.setAirplane(newAirplane);
        assertEquals(newAirplane, flight.getAirplane());
    }

    @Test
    void getAirplane() {
        Airplane actualAirplane = flight.getAirplane();
        assertEquals(airplane, actualAirplane);
    }
}