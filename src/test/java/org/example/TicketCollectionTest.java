package org.example;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import org.mockito.Mock;
import org.mockito.Mockito;

import static org.example.TicketCollection.getTicketInfo;


public class TicketCollectionTest {

    private ArrayList<Ticket> tickets;
    private Ticket ticket;
    private Flight flight;
    @BeforeEach
    public void setUp() {
        tickets = new ArrayList<>();

        flight = new Flight();

        Passenger passenger = new Passenger("John", "Doe", 30, "Man", "john.doe@example.com", "+61481888206", "AB123456", "123456789", 123);
        ticket = new Ticket(1, 100, flight, true, passenger);

        // 创建一个示例的 Ticket 对象

    }

//    @Test
//    public void testAddValidatedTickets() {
//      //  Ticket ticket = new Ticket(123, 100, new Flight(), true, new Passenger());
//        flight = new Flight();
//
//        tickets.add(ticket);
//        Passenger passenger = new Passenger("John", "Doe", 30, "Man", "john.doe@example.com", "+61481888206", "AB123456", "123456789", 123);
//        ticket = new Ticket(1, 100, flight, true, passenger);
//
//        TicketCollection.addTickets(tickets);
//        ArrayList<Ticket> retrievedTickets = TicketCollection.getTickets();
//
//        Assertions.assertEquals(tickets, retrievedTickets);
//    }

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
}










