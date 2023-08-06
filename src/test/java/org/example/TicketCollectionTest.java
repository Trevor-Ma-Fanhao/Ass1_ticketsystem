package org.example;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.example.TicketCollection.getTicketInfo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;


public class TicketCollectionTest {

    private ArrayList<Ticket> tickets;
    private Ticket ticket;
    private Flight flight;

    static Flight mockFlight;
    static FlightCollection mockFlightCollection;
    static Passenger mockPassenger;
    static Airplane mockAirplane;

    @BeforeAll
    static void initAll() {
//        mockFlight = mock(Flight.class);
//        mockPassenger = mock(Passenger.class);
//        mockFlightCollection = mock(FlightCollection.class);
//        mockAirplane = mock(Airplane.class);
    //    mockStatic(FlightCollection.class);
    }

    @BeforeEach
    void init() {
        mockFlight = mock(Flight.class);
        mockPassenger = mock(Passenger.class);
        mockFlightCollection = mock(FlightCollection.class);
        mockAirplane = mock(Airplane.class);
//        mockStatic(FlightCollection.class);
        ticket = new Ticket(2345, 123, mockFlight, false, mockPassenger);
        tickets = new ArrayList<>();
    }

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
//    @BeforeEach
//    public void setUp() {
//        tickets = new ArrayList<>();
//
//        flight = new Flight();
//
//        Passenger passenger = new Passenger("John", "Doe", 30, "Man", "john.doe@example.com", "+61481888206", "AB123456", "123456789", 123);
//        ticket = new Ticket(1, 100, flight, true, passenger);
//
//        // 创建一个示例的 Ticket 对象
//
//    }

    @Test
    public void testGetAllTickets() {

        // Redirect System.out to outputStreamCaptor
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);
        TicketCollection.tickets = tickets;
        // Call getAllTickets() method to trigger System.out.println(ticket.toString())
        TicketCollection.getAllTickets();

        // Verify the output captured by outputStreamCaptor
        String expectedOutput = ""; // Initialize with empty string
        for (Ticket ticket : tickets) {
            expectedOutput += ticket.toString().trim() + "\n";
        }


        byte[] expectedBytes = expectedOutput.getBytes();
        byte[] actualBytes = outputStreamCaptor.toByteArray();

         Assertions.assertEquals(expectedBytes.length, actualBytes.length-1);
        // Restore System.out to its original value
        System.setOut(standardOut);
    }


    @Test
    public void testGetTickets() {

        // 创建一个 Ticket 集合
        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);

        // 设置 TicketCollection 的 tickets
        TicketCollection.tickets = tickets;

        // 调用 getTickets 方法，并验证返回的是预期的 Ticket 集合
        ArrayList<Ticket> result = TicketCollection.getTickets();
        Assertions.assertEquals(tickets, result);
    }
//1. Whenever a ticket is being added to the TicketCollection, it must be validated.

    @Test
    public void testAddTickets() {
        // 创建一个 Ticket 集合
        ArrayList<Ticket> ticketsToAdd = new ArrayList<>();
        ticketsToAdd.add(ticket);

        // 调用 addTickets 方法，将 ticketsToAdd 添加到 TicketCollection
        TicketCollection.addTickets(ticketsToAdd);

        // 验证 TicketCollection 的 tickets 已包含添加的 Ticket
        Assertions.assertTrue(TicketCollection.tickets.contains(ticket));
    }
    //            2. When trying to get a ticket, the correct ticket is returned.
    @Test
    public void testGetTicketInfoWithNull() {

        int ticketId = 123; // 你要测试的 ticket_id 值
        Ticket ticket = getTicketInfo(ticketId);
        Assertions.assertNull(ticket, "Ticket should not be null");
    }

    @Test
    public void testAddTicketsWithNullList() {
        // Create an ArrayList with a null element
        TicketCollection ticketCollection = new TicketCollection();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ticketCollection.addTickets(null);
        });
    }

    @Test
    public void testGetTicketInfo() {

        // Call getTicketInfo() with the ticket_id of the created ticket
        ArrayList<Ticket> ticketsToAdd = new ArrayList<>();
        ticketsToAdd.add(ticket);
        TicketCollection.addTickets(ticketsToAdd);
        Ticket foundTicket = TicketCollection.getTicketInfo(2345);

        // Assert that the returned Ticket object is the same as the one we created
        Assertions.assertEquals(ticket.getTicket_id(), foundTicket.getTicket_id());
    }


}










