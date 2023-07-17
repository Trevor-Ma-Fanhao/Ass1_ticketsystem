package org.example;

import org.junit.jupiter.api.Test;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {

    private Airplane airplane = new Airplane(1, "Boeing 747", 10, 200, 5);
    private Timestamp dateFrom = Timestamp.valueOf("01/07/23 12:00:00");
    private Timestamp dateTo = Timestamp.valueOf("01/07/23 14:00:00");

    private Flight flight = new Flight(1, "Suzhou", "Shanghai", "AB123", "Airline", dateFrom, dateTo, airplane);

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
        String expectedDepartTo = "Suzhou";
        String actualDepartTo = flight.getDepartTo();
        assertEquals(expectedDepartTo, actualDepartTo);
    }

    @Test
    void setDepartTo() {
        String newDepartTo = "Nanjing";
        flight.setDepartTo(newDepartTo);
        assertEquals(newDepartTo, flight.getDepartTo());
    }

    @Test
    void getDepartFrom() {
        String expectedDepartFrom = "Shanghai";
        String actualDepartFrom = flight.getDepartFrom();
        assertEquals(expectedDepartFrom, actualDepartFrom);
    }

    @Test
    void setDepartFrom() {
        String newDepartFrom = "Beijing";
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
        String expectedDateFrom = "01/07/23 12:00:00";
        Timestamp actualDateFrom = flight.getDateFrom();
        String formattedActualDateFrom = new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(actualDateFrom);

        assertEquals(expectedDateFrom, formattedActualDateFrom);
    }

    @Test
    void setDateFrom() {
        String expectedDateFrom = "02/07/23 10:00:00";
        Timestamp newDateFrom = Timestamp.valueOf("2023-07-02 10:00:00");
        flight.setDateFrom(newDateFrom);

        String formattedActualDateFrom = new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(flight.getDateFrom());

        assertEquals(expectedDateFrom, formattedActualDateFrom);
    }


    @Test
    void getDateTo() {
        String expectedDateTo = "01/07/23 14:00:00";
        Timestamp actualDateTo = flight.getDateTo();
        String formattedActualDateTo = new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(actualDateTo);
        assertEquals(expectedDateTo, formattedActualDateTo);
    }


    @Test
    void setDateTo() {
        String expectedDateTo = "02/07/23 12:00:00";
        Timestamp newDateTo = Timestamp.valueOf("02/07/23 12:00:00");
        flight.setDateTo(newDateTo);
        String formattedActualDateTo = new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(flight.getDateTo());
        assertEquals(expectedDateTo, formattedActualDateTo);
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