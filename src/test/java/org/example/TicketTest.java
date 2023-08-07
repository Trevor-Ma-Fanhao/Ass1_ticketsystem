package org.example;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class TicketTest {

    private Ticket ticket;
    private Flight flight;
    private Passenger passenger;

    //Ticket ticket;
    static Flight mockFlight;
    static FlightCollection mockFlightCollection;
    static Passenger mockPassenger;
    static Airplane mockAirplane;

    @BeforeAll
    static void initAll() {
        mockFlight = mock(Flight.class);
        mockPassenger = mock(Passenger.class);
        mockFlightCollection = mock(FlightCollection.class);
        mockAirplane = mock(Airplane.class);
        mockStatic(FlightCollection.class);
    }

    @BeforeEach
    void init() {
        ticket = new Ticket(2345, 123, mockFlight, false, mockPassenger);
    }


//    @BeforeEach
//    public void setUp() {
//        flight = new Flight();
//        passenger = new Passenger();
//        ticket = new Ticket(1, 100, flight, false, passenger);
//    }

    @Test
    public void testGetTicketId() {
        Ticket ticket = new Ticket();

        ticket.setTicket_id(5);

        assertNotEquals(0, ticket.getTicket_id());
    }

    @Test
    public void testSetPriceWithNegativeValue() {
        // 创建一个 Ticket 对象
        Ticket ticket = new Ticket();

        // 将价格设置为负数
        int price = -50;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {ticket.setPrice(price);
        });
    }

    @Test
    public void testSetPriceWithZeroValue() {
        // 创建一个 Ticket 对象
        Ticket ticket = new Ticket();

        // 将价格设置为负数
        int price = 0;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {ticket.setPrice(price);
        });
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

    @Test
    void testTicketPriceForUnder15() {
        when(mockPassenger.getAge()).thenReturn(14);
        ticket.setPrice(1000);
        ticket.setTicketStatus(true);
        assertEquals(1000 * 0.5 * 1.12, ticket.getPrice());
        assertTrue(ticket.ticketStatus());
    }

    @Test
    void testTicketPriceForBetween15And60() {
        when(mockPassenger.getAge()).thenReturn(15);
        ticket.setPrice(1000);
        ticket.setTicketStatus(true);
        assertEquals(1000 * 1.12, ticket.getPrice());
        assertTrue(ticket.ticketStatus());

        when(mockPassenger.getAge()).thenReturn(59);
        ticket.setPrice(1000);
        ticket.setTicketStatus(true);
        assertEquals(1000 * 1.12, ticket.getPrice());
        assertTrue(ticket.ticketStatus());
    }

    @Test
    void testTicketPriceForOver60() {
        when(mockPassenger.getAge()).thenReturn(60);
        ticket.setPrice(1000);
        ticket.setTicketStatus(true);
        assertEquals(0, ticket.getPrice());
        assertTrue(ticket.ticketStatus());
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



        Passenger passenger5 = new Passenger("Bob", "Johnson", 99, "Man", "bob@example.com", "+61456789012", "GHI789", "5678901234", 789);
        passenger5.setAge(99);
        ticket.setPassenger(passenger5);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {ticket.setPrice(ticket.getPrice());;
        });


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

    @Test
    @DisplayName("testGetClassVip")
    public void testGetClassVip() {
        // Create a ticket with classVip set to false
        Ticket ticket1 = new Ticket(1, 100, flight, false, passenger);
        assertFalse(ticket1.getClassVip()); // Should return false

        // Create another ticket with classVip set to true
        Ticket ticket2 = new Ticket(2, 200, flight, true, passenger);
        assertTrue(ticket2.getClassVip()); // Should still return false
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
    @Test
    @DisplayName("testSetClassVip")
    public void testSetClassVip() {
        // Create a Ticket object
        Ticket ticket = new Ticket(1, 100, flight, false, passenger);

        // Verify the initial value of classVip
        assertFalse(ticket.getClassVip()); // Should be false

        // Set classVip to true
        ticket.setClassVip(true);

        // Verify the updated value of classVip
        assertTrue(ticket.getClassVip()); // Should be true

        // Set classVip back to false
        ticket.setClassVip(false);

        // Verify the value of classVip after resetting
        assertFalse(ticket.getClassVip()); // Should be false
    }


    @Test
    @DisplayName("testToString")
    public void testToString() {
        // Create a sample Passenger
        Passenger passenger = new Passenger("John", "Doe", 30, "Man", "johndoe@example.com", "+61456789012", "ABC123", "1234567890", 123);

        // Create a sample Flight


        // Create a Ticket object
        Ticket ticket = new Ticket(1, 100, mockFlight, true, passenger);

        // Get the expected string representation
        String expectedString = "Ticket{" + '\n' +
                "Price=100KZT, " + '\n' +
                mockFlight.toString() + '\n' + // Assuming Flight's toString() method is correctly implemented
                "Vip status=true" + '\n' +
                passenger.toString() + '\n' + // Assuming Passenger's toString() method is correctly implemented
                "Ticket was purchased=false\n}"; // Assuming ticketStatus() method correctly returns "Not Purchased"

        // Get the actual string representation using toString() method
        String actualString = ticket.toString();

        // Compare the expected and actual strings
        assertEquals(expectedString, actualString);
    }







}