package org.example;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class AirplaneTest {

    private Airplane airplane = new Airplane(1, "Boeing 747", 10, 200, 5);


    @org.junit.jupiter.api.Test
    void getAirplaneID() {
        int expectedID = 1;
        int actualID = airplane.getAirplaneID();
        Assertions.assertEquals(expectedID, actualID);
    }

    @org.junit.jupiter.api.Test
    void setAirplaneID() {
        int newID = 2;
        airplane.setAirplaneID(newID);
        Assertions.assertEquals(newID, airplane.getAirplaneID());
    }


    @org.junit.jupiter.api.Test
    void getBusinessSitsNumber() {
        int expectedBusinessSeats = 10;
        int actualBusinessSeats = airplane.getBusinessSitsNumber();
        Assertions.assertEquals(expectedBusinessSeats, actualBusinessSeats);

    }

    @org.junit.jupiter.api.Test
    void setBusinessSitsNumber() {
        int newBusinessSeats = 8;
        airplane.setBusinessSitsNumber(newBusinessSeats);
        Assertions.assertEquals(newBusinessSeats, airplane.getBusinessSitsNumber());

        // Add an assertion for seat number range

        int businessSeats = airplane.getBusinessSitsNumber();
        int economySeats = airplane.getEconomySitsNumber();
        int totalSeats = businessSeats + economySeats;

        Assertions.assertTrue(businessSeats >= 1 && businessSeats <= 300,
                "Business seat number must be in the range [1, 300]");
        Assertions.assertTrue(economySeats >= 1 && economySeats <= 300,
                "Economy seat number must be in the range [1, 300]");
        Assertions.assertTrue(totalSeats >= 1 && totalSeats <= 300,
                "Economy seat number must be in the range [1, 300]");
    }

    @org.junit.jupiter.api.Test
    void getCrewSitsNumber() {
        int expectedCrewSeats = 5;
        int actualCrewSeats = airplane.getCrewSitsNumber();
        Assertions.assertEquals(expectedCrewSeats, actualCrewSeats);

    }

    @org.junit.jupiter.api.Test
    void setCrewSitsNumber() {
        int newCrewSeats = 6;
        airplane.setCrewSitsNumber(newCrewSeats);
        Assertions.assertEquals(newCrewSeats, airplane.getCrewSitsNumber());

        // Add an assertion for seat number range

        int businessSeats = airplane.getBusinessSitsNumber();
        int economySeats = airplane.getEconomySitsNumber();
        int totalSeats = businessSeats + economySeats;

        Assertions.assertTrue(businessSeats >= 1 && businessSeats <= 300,
                "Business seat number must be in the range [1, 300]");
        Assertions.assertTrue(economySeats >= 1 && economySeats <= 300,
                "Economy seat number must be in the range [1, 300]");
        Assertions.assertTrue(totalSeats >= 1 && totalSeats <= 300,
                "Economy seat number must be in the range [1, 300]");

    }

}