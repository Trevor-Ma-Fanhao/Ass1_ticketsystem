package org.example;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.sql.Timestamp;

import java.security.KeyStore;
//import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class TicketSystemTest {

    private Passenger dummypassenger;
    private Passenger dummypassenger2;
    private Ticket dummyticket;
    private Flight dummyflight;
    private Airplane dummyairplane;
    private BuyTicket buyTicket;

    @BeforeEach
    public void setUp() {
        // 创建 dummy 对象并设置其属性
        dummypassenger = new Passenger("Fanhao", "Ma", 24, "Man",
                "932952939@qq.com", "+61481888206", "6666","6666",888);
        dummyairplane = new Airplane(888,"C919",100,50,10);
        dummyflight = new Flight(1,"NewYork","London","LN258","Airline",
                Timestamp.valueOf(LocalDateTime.now().plusHours(1)),Timestamp.valueOf(LocalDateTime.now().plusDays(1)),dummyairplane);
        dummyticket = new Ticket(1,100,dummyflight,true,dummypassenger);


        //创建空的ticketcollection 并addticket
        ArrayList<Ticket> ticketslist = new ArrayList<>();
        ticketslist.add(dummyticket);
        TicketCollection ticketCollection = new TicketCollection();
        ticketCollection.addTickets(ticketslist);

        //创建空的flightcollection 并addflight
        ArrayList<Flight> flightslist = new ArrayList<>();
        flightslist.add(dummyflight);
        FlightCollection flightCollection = new FlightCollection();
        flightCollection.addFlights(flightslist);

    }

    @Test
    void chooseTicketValidCityTest() throws Exception {
        String city1 = "London";
        String city2 = "NewYork";

        // 创建 ChooseTicket 对象，并调用 chooseTicket 方法
        ChooseTicket chooseTicket1 = new ChooseTicket();
        ChooseTicket chooseTicket2 = new ChooseTicket();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            chooseTicket2.chooseTicket("6hongkong", city2);
        });
//        Assertions.assertDoesNotThrow(()->{chooseTicket1.chooseTicket(city1,city2);});
        //这里如果输入了正确的出发地和目的地，会跳转到对应的ticketID选择以及passenger信息输入，需要用Scanner Mock实现，暂时跳过
    }

    @Test
    public void testShowTicketWithValidTicket() {
        buyTicket = new BuyTicket(dummypassenger, dummyflight, dummyticket);
        assertTrue(buyTicket.showTicket());
    }
    @Test
    public void testChooseBookedTicket(){

        Ticket dummyticket_booked = new Ticket(2,100,dummyflight,true,dummypassenger);
        dummyticket_booked.setTicketStatus(true);

        //创建空的ticketcollection 并addticket
        ArrayList<Ticket> ticketslist = new ArrayList<>();
        ticketslist.add(dummyticket_booked);
        TicketCollection ticketCollection = new TicketCollection();
        ticketCollection.addTickets(ticketslist);

        ChooseTicket chooseTicket_booked = new ChooseTicket();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                chooseTicket_booked.chooseTicket("London", "NewYork");
        });
    }


    @Test
    public void testBuyTicketWithValidPassenger() {


        Throwable e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dummypassenger2 = new Passenger("Junjia", "Zhang", 0, "Man",
                    "932952939@qq.com", "+61481888206", "6666", "6666", 888);
            dummyticket = new Ticket(1,100,dummyflight,true,dummypassenger2);
            ArrayList<Ticket> ticketList = new ArrayList<>();
            ticketList.add(dummyticket);
            TicketCollection.addTickets(ticketList);

                BuyTicket buyTicket = new BuyTicket();
                buyTicket.buyTicket(1);

        });
        assertEquals("age should be in 1-100", e.getMessage());

    }

    @Test
    public void testBuyTicketWithInvalidFlightInfo() {
        Throwable e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        dummypassenger2 = new Passenger("Junjia", "Zhang", 0, "Man",
                "932952939@qq.com", "+61481888206", "6666", "6666", 888);
        dummyticket = new Ticket(1,100,dummyflight,true,dummypassenger2);
        ArrayList<Ticket> ticketList = new ArrayList<>();
        ticketList.add(dummyticket);
        TicketCollection.addTickets(ticketList);

        BuyTicket buyTicket = new BuyTicket();
        buyTicket.buyTicket(1);
    });

    }


}

