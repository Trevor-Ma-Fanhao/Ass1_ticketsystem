package org.example;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



public class TicketTest {

    private Ticket ticket;
    private Flight flight;
    private Passenger passenger;

    @BeforeEach
    public void setUp() {
        flight = new Flight();
        passenger = new Passenger();
        ticket = new Ticket(1, 100, flight, false, passenger);
    }


    //1. Values for the ticket status must be ‘True’ or ‘False’ for the booked and available tickets respectively.
    @Test
    @DisplayName("testTicketStatus")
    public void testTicketStatus() {
        Ticket ticket = new Ticket();
        ticket.setTicketStatus(true);
        Assertions.assertTrue(ticket.ticketStatus());

        ticket.setTicketStatus(false);
        Assertions.assertFalse(ticket.ticketStatus());
    }

    //2. Discount is always applied based on the age category of the passenger.
    @Test
    @DisplayName("testSaleByAge")
    public void testTicketCreationWithDiscount() {
        Flight flight = new Flight();
        Passenger passenger = new Passenger("John", "Doe", 25, "Man", "johndoe@example.com", "+61456789012", "ABC123", "1234567890", 123);
        passenger.setAge(25);
        Ticket ticket = new Ticket(1, 100, flight, false, passenger);

        assertEquals(100, ticket.getPrice()); // The initial price should be set correctly

        Passenger passenger2 = new Passenger("Alice", "Smith", 12, "Woman", "alice@example.com", "+61456789012", "DEF456", "0987654321", 456);

        passenger2.setAge(12);
        ticket.setPassenger(passenger2);
        ticket.setPrice(ticket.getPrice()); // Update the ticket price based on passenger age
        assertEquals(56, ticket.getPrice()); // The price should be discounted by 50% for passengers under 15
        assertEquals(12, ticket.getPassenger().getAge());
        // Reset the ticket price to 100


        Passenger passenger3 = new Passenger("Bob", "Johnson", 65, "Man", "bob@example.com", "+61456789012", "GHI789", "5678901234", 789);
        passenger3.setAge(65);
        ticket.setPassenger(passenger3);
        ticket.setPrice(ticket.getPrice());
        assertEquals(0, ticket.getPrice()); // The price should be discounted to 0 for passengers aged 60 or above
    }

  //  Price is always applied to a ticket.
    @Test
    public void testSetPrice() {
        Passenger passenger = new Passenger("John", "Doe", 25, "Man", "johndoe@example.com", "+61456789012", "ABC123", "1234567890", 123);
        passenger.setAge(25);
        Ticket ticket = new Ticket(1, 100, flight, false, passenger);
        ticket.setPrice(ticket.getPrice());
        Assertions.assertEquals(112, ticket.getPrice());

    }

    @Test
    public void testSetNullFlight() {
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            ticket.setFlight(null);
        });
        assertEquals("Ticket flight cannot be null", e.getMessage());
    }

    @Test
    public void testSetNullPassenger() {
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            ticket.setPassenger(null);
        });
        assertEquals("Ticket passenger cannot be null", e.getMessage());
    }
// The price and service tax are valid values
    @Test
    public void testServiceTax_ValidValue() {
        Passenger passenger = new Passenger("John", "Doe", 25, "Man", "johndoe@example.com", "+61456789012", "ABC123", "1234567890", 123);
        passenger.setAge(25);
        Ticket ticket = new Ticket(1, 100, flight, false, passenger);
        ticket.serviceTax();
        Assertions.assertEquals(112, ticket.getPrice()); // Assuming service tax is correctly applied
    }
//Ticker class receives valid information of flight and passenger.
    @Test
    public void testGetSetFlight() {
        Flight flight = new Flight();
        Ticket ticket = new Ticket();
        ticket.setFlight(flight);
        Assertions.assertEquals(flight, ticket.getFlight());
    }

    @Test
    public void testGetSetPassenger() {
        Passenger passenger = new Passenger();
        Ticket ticket = new Ticket();
        ticket.setPassenger(passenger);
        Assertions.assertEquals(passenger, ticket.getPassenger());
    }






}