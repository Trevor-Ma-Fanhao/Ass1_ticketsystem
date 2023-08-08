package org.example;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import java.io.*;
import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.sql.Timestamp;

import java.security.KeyStore;
//import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static org.mockito.Mockito.*;
public class TicketSystemTest {

    private Passenger dummypassenger;
    private Passenger dummypassenger2;
    private Ticket dummyticket;
    private Ticket dummyticket2;

    private Airplane dummyairplane;

    private Flight dummyflight;
    private Flight dummyflight2;

 //   private BuyTicket buyTicket;

    static Flight mockFlight;
    static FlightCollection mockFlightCollection;
    static Passenger mockPassenger;
    static Airplane mockAirplane;
    private Ticket ticket;
    Airplane DummyAirplane;
    Passenger DummyPassenger;
    Flight DummyFlight;

    Flight NullFlight;
    Passenger NullPassenger;
    Ticket DummyTicket;
    FlightCollection dummyFlightCollection;
    TicketCollection dummyTicketCollection;
    TicketSystem ticketSystem;
     

    private Scanner scannerMock;
    private Scanner in;




    Timestamp timestamp1 = Timestamp.valueOf("2023-08-15 00:00:00");
    Timestamp timestamp2 = Timestamp.valueOf("2023-08-20 00:00:00");
    String dateFrom = "10/08/23 14:25:30";
    String dateTo = "10/08/23 15:25:30";





//    @BeforeAll
//    static void initAll() {
//        mockFlight = mock(Flight.class);
//        mockPassenger = mock(Passenger.class);
//        mockFlightCollection = mock(FlightCollection.class);
//        mockAirplane = mock(Airplane.class);
//        mockStatic(FlightCollection.class);
//        MockedStatic<TicketCollection> mockTicketCollection;
//        mockTicketCollection = mockStatic(TicketCollection.class, CALLS_REAL_METHODS);
//    }
//    @BeforeEach
//    void init() {
//        scannerMock = Mockito.mock(Scanner.class);
//        DummyAirplane = new Airplane(5171, "Boeing747", 30, 130, 6);
//        DummyPassenger = new Passenger("Barry","Ellen", 30, "Man", "HuangYH723@outlook.com", "0412345678", "CN", "10001", 2000);
//        DummyFlight = new Flight(10, "SHANGHAI", "SUZHOU", "0001", "EasternChina", timestamp1, timestamp2, DummyAirplane);
//        DummyTicket = new Ticket(1, 1000, DummyFlight, false, DummyPassenger);
//        DummyFlightCollection = new FlightCollection();
//        DummyTicketCollection = new TicketCollection();
//        DummyFlightCollection.flights.add(DummyFlight);
//        DummyTicketCollection.tickets.add(DummyTicket);
//        ticketSystem = new TicketSystem(DummyTicketCollection, DummyFlightCollection, scannerMock);
//        TicketSystem ticketSystemMock = mock(TicketSystem.class);
//        ticketSystem = ticketSystemMock;
//    }

//    @Test
//    void testChooseTicketWithDirectFlight() throws Exception {
//        // 设定Mock对象的行为
//        when(mockFlightCollection.getFlightInfo(anyString(), anyString())).thenReturn(DummyFlight);
//        when(scannerMock.nextInt()).thenReturn(1); // 模拟用户输入
//
//        ticketSystem.chooseTicket("SHANGHAI", "SUZHOU");
//
//        // 验证相关方法是否被调用
//        verify(mockFlightCollection).getFlightInfo("SHANGHAI", "SUZHOU");
//        verify(ticketSystem).buyTicket(1); // 确保购买机票的方法被调用
//    }





    @BeforeEach
    public void setUp() {
       // scannerMock = Mockito.mock(Scanner.class);
        // 创建 dummy 对象并设置其属性
        dummypassenger = new Passenger("Fanhao", "Ma", 24, "Man",
                "932952939@qq.com", "+61481888206", "6666","6666",888);
        dummyairplane = new Airplane(888,"C919",100,50,10);
        dummyflight = new Flight(1,"NewYork","London","LN258","Airline",
                dateFrom,dateTo,dummyairplane);
        dummyflight2 = new Flight(3,"Zhuhai","NewYork","LN337","Airline",
                dateFrom,dateTo,dummyairplane);
        dummyticket = new Ticket(2,100,dummyflight,true,dummypassenger);
        dummyticket2 = new Ticket(4,100,dummyflight2,true,dummypassenger);


        dummyFlightCollection = new FlightCollection();

        dummyTicketCollection = new TicketCollection();

        dummyFlightCollection.flights.add(dummyflight);
        dummyFlightCollection.flights.add(dummyflight2);

        dummyTicketCollection.tickets.add(dummyticket);
        dummyTicketCollection.tickets.add(dummyticket2);
        ticketSystem = new TicketSystem(dummyTicketCollection, dummyFlightCollection, scannerMock);


    }

//    @Test
//    public void testChooseBookedTicket(){
//
//        Ticket dummyticket_booked = new Ticket(2,100,dummyflight,true,dummypassenger);
//        dummyticket_booked.setTicketStatus(false);
//
//        //创建空的ticketcollection 并addticket
//        ArrayList<Ticket> ticketslist_booked = new ArrayList<>();
//        ticketslist_booked.add(dummyticket_booked);
//        TicketCollection.addTickets(ticketslist_booked);
//
//        ChooseTicket chooseTicket_booked = new ChooseTicket();
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            chooseTicket_booked.chooseTicket("London", "Newyork");
//        });
//    }

    @Test
    public void testChooseTicketOne() throws Exception {

            String input = String.format("Junjia\nZhang\n21\nMan\njzha0424@student.moansh.edu\n+61481888206\nAU\n1\n88888\n123");
            ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
            Scanner in = new Scanner(inputStream);
            ticketSystem = new TicketSystem(dummyTicketCollection, dummyFlightCollection, in);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(outputStream));

            ticketSystem.chooseTicket("London", "NewYork");

            String actualOutput = outputStream.toString().trim();

            String expectedOutput = "Enter ID of ticket you want to choose:";
            Assertions.assertTrue(actualOutput.contains(expectedOutput));
            expectedOutput = "ticket you choose is :";
            Assertions.assertTrue(actualOutput.contains(expectedOutput));
            expectedOutput = "Ticket{";
            Assertions.assertTrue(actualOutput.contains(expectedOutput));
            expectedOutput = "2";
            Assertions.assertTrue(actualOutput.contains(expectedOutput));
            expectedOutput = "Enter your First Name: ";
            Assertions.assertTrue(actualOutput.contains(expectedOutput));
            expectedOutput = "Enter your Second name:";
            Assertions.assertTrue(actualOutput.contains(expectedOutput));
            expectedOutput = "Enter your age:";
            Assertions.assertTrue(actualOutput.contains(expectedOutput));
            expectedOutput = "Enter your gender: ";
            Assertions.assertTrue(actualOutput.contains(expectedOutput));
            expectedOutput = "Enter your e-mail address";
            Assertions.assertTrue(actualOutput.contains(expectedOutput));
            expectedOutput = "Enter your phone number (+7):";
            Assertions.assertTrue(actualOutput.contains(expectedOutput));
            expectedOutput = "Enter your passport number:";
            Assertions.assertTrue(actualOutput.contains(expectedOutput));
            expectedOutput = "Do you want to purchase?";
            Assertions.assertTrue(actualOutput.contains(expectedOutput));
            expectedOutput = "111";
            Assertions.assertTrue(actualOutput.contains(expectedOutput));
            expectedOutput = "Your bill:";
            Assertions.assertTrue(actualOutput.contains(expectedOutput));
            expectedOutput = "Enter your card number:";
            Assertions.assertTrue(actualOutput.contains(expectedOutput));
            expectedOutput = "Enter your security code:";
            Assertions.assertTrue(actualOutput.contains(expectedOutput));
            expectedOutput = "Success";
            Assertions.assertTrue(actualOutput.contains(expectedOutput));
            expectedOutput = "888";
            Assertions.assertTrue(actualOutput.contains(expectedOutput));

            // 恢复原始的 System.out
            System.setOut(originalOut);

            Assertions.assertEquals("Junjia",ticketSystem.ticket.getPassenger().getFirstName());
            Assertions.assertEquals(2,ticketSystem.ticket.getTicket_id());
            Assertions.assertEquals(1,ticketSystem.ticket.getFlight().getFlightID());
            Assertions.assertEquals(112,ticketSystem.ticket.getPrice());
            assertTrue(ticketSystem.ticket.getClassVip());
            assertTrue(ticketSystem.ticket.ticketStatus());
//            Assertions.assertEquals(99,Airplane.getAirPlaneInfo(2).getBusinessSitsNumber());
//            Assertions.assertEquals(50,Airplane.getAirPlaneInfo(2).getEconomySitsNumber());
            Assertions.assertEquals(1,ticketSystem.ticket.getFlight().getFlightID());
            Assertions.assertEquals(112,ticketSystem.ticket.getPrice());



            String output = ticketSystem.passenger.toString();
            String passengerdOutput = "Passenger{ Fullname= Junjia Zhang, email='jzha0424@student.moansh.edu', phoneNumber='+61481888206', passport='AU'}";
            Assertions.assertEquals(passengerdOutput, output);
            Assertions.assertEquals("88888",ticketSystem.passenger.getCardNumber());
            Assertions.assertEquals(123,ticketSystem.passenger.getSecurityCode());


    }

    @Test
    public void testChooseTicketTwo() throws Exception {

        String input = String.format("Junjia\nZhang\n21\nMan\njzha0424@student.moansh.edu\n+61481888206\nAU\n1\n88888\n123");
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner in = new Scanner(inputStream);
        ticketSystem = new TicketSystem(dummyTicketCollection, dummyFlightCollection, in);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        ticketSystem.chooseTicket("London", "Zhuhai");

        System.out.println("ticket1: "+ticketSystem.ticket_first.getTicket_id());
        System.out.println("ticket2: "+ticketSystem.ticket_second.getTicket_id());

        String actualOutput = outputStream.toString().trim();
        String expectedOutput = "in case there is no direct ticket from city1 to city2";
        Assertions.assertTrue(actualOutput.contains(expectedOutput));
        expectedOutput = "There is special way to go there. And it is transfer way, like above.";
        Assertions.assertTrue(actualOutput.contains(expectedOutput));

        expectedOutput = "There is no possible variants.";
        Assertions.assertFalse(actualOutput.contains(expectedOutput));

        expectedOutput = "2 4";
        Assertions.assertTrue(actualOutput.contains(expectedOutput));
        expectedOutput = "Processing...";
        Assertions.assertTrue(actualOutput.contains(expectedOutput));

        expectedOutput = "This ticket does not exist.";
        Assertions.assertFalse(actualOutput.contains(expectedOutput));

        expectedOutput = "Enter your First Name: ";
        Assertions.assertTrue(actualOutput.contains(expectedOutput));
        expectedOutput = "Enter your Second name:";
        Assertions.assertTrue(actualOutput.contains(expectedOutput));
        expectedOutput = "Enter your age:";
        Assertions.assertTrue(actualOutput.contains(expectedOutput));
        expectedOutput = "Enter your gender: ";
        Assertions.assertTrue(actualOutput.contains(expectedOutput));
        expectedOutput = "Enter your e-mail address";
        Assertions.assertTrue(actualOutput.contains(expectedOutput));
        expectedOutput = "Enter your phone number (+7):";
        Assertions.assertTrue(actualOutput.contains(expectedOutput));
        expectedOutput = "Enter your passport number:";
        Assertions.assertTrue(actualOutput.contains(expectedOutput));
        expectedOutput = "Do you want to purchase?";
        Assertions.assertTrue(actualOutput.contains(expectedOutput));

        //String input = String.format("Junjia\nZhang\n21\nMan\njzha0424@student.moansh.edu\n+61481888206\nAU\n1\n88888\n123");
        Assertions.assertEquals("Junjia",ticketSystem.passenger.getFirstName());
        Assertions.assertEquals("Zhang",ticketSystem.passenger.getSecondName());
        Assertions.assertEquals(21,ticketSystem.passenger.getAge());
        Assertions.assertEquals("jzha0424@student.moansh.edu",ticketSystem.passenger.getEmail());
        Assertions.assertEquals("+61481888206",ticketSystem.passenger.getPhoneNumber());
        Assertions.assertEquals("AU",ticketSystem.passenger.getPassport());



        String ticket_first_str_exp = "Ticket{\n" +
                "Price=112KZT, \n" +
                "Flight{Airplane{model=C919', business sits=100', economy sits=50', crew sits=10'}, date to=10/08/23 15:25:30, ', date from='10/08/23 14:25:30', depart from='London', depart to='NewYork', code=LN258', company=Airline'}\n" +
                "Vip status=true\n" +
                "Passenger{ Fullname= Junjia Zhang, email='jzha0424@student.moansh.edu', phoneNumber='+61481888206', passport='AU'}\n" +
                "Ticket was purchased=true\n" +
                "}";
        String ticket_second_str_exp = "Ticket{\n" +
                "Price=100KZT, \n" +
                "Flight{Airplane{model=C919', business sits=100', economy sits=50', crew sits=10'}, date to=10/08/23 15:25:30, ', date from='10/08/23 14:25:30', depart from='NewYork', depart to='Zhuhai', code=LN337', company=Airline'}\n" +
                "Vip status=true\n" +
                "Passenger{ Fullname= Junjia Zhang, email='jzha0424@student.moansh.edu', phoneNumber='+61481888206', passport='AU'}\n" +
                "Ticket was purchased=true\n" +
                "}";
        String ticket_first_str = ticketSystem.ticket_first.toString();
        String ticket_second_str = ticketSystem.ticket_second.toString();
        Assertions.assertEquals(ticket_first_str_exp,ticket_first_str);
        Assertions.assertEquals(ticket_second_str_exp,ticket_second_str);

        expectedOutput = "--*-*-";
        Assertions.assertTrue(actualOutput.contains(expectedOutput));
        expectedOutput = "Your bill:";
        Assertions.assertTrue(actualOutput.contains(expectedOutput));
        expectedOutput = "Enter your card number:";
        Assertions.assertTrue(actualOutput.contains(expectedOutput));
        expectedOutput = "Enter your security code:";
        Assertions.assertTrue(actualOutput.contains(expectedOutput));
        expectedOutput = "Success buy two ticket";
        Assertions.assertTrue(actualOutput.contains(expectedOutput));
        // 恢复原始的 System.out
        System.setOut(originalOut);
    }

//    @Test
//    void chooseTicketValidCityTest() throws Exception {
//        String city1 = "London";
//        String city2 = "NewYork";
//
//        // 创建 ChooseTicket 对象，并调用 chooseTicket 方法
//        TicketSystem ticketSystem1 = new TicketSystem();
//        TicketSystem ticketSystem2 = new TicketSystem();
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            ticketSystem1.chooseTicket("6hongkong", city2);
//        });
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            ticketSystem2.chooseTicket(city1, "L0ndon");
//        });
//
//
//        ChooseTicket chooseTicket1 = new ChooseTicket();
//        ChooseTicket chooseTicket2 = new ChooseTicket();
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            chooseTicket2.chooseTicket("6hongkong", city2);
//        });
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            chooseTicket2.chooseTicket(city1, "L0ndon");
//        });
//        Assertions.assertDoesNotThrow(()->{chooseTicket1.chooseTicket(city1,city2);});
//        这里如果输入了正确的出发地和目的地，会跳转到对应的ticketID选择以及passenger信息输入，需要用Scanner Mock实现，暂时跳过
//    }

//    @Test
//    public void testShowTicketWithValidTicket() {
//        buyTicket = new BuyTicket(dummypassenger, dummyflight, dummyticket);
//        assertTrue(buyTicket.showTicket());
//
//    }


//    Appropriate checks have been implemented to validate passenger information



//    @Test
//    public void testShowTicket() {
//        // 创建模拟的Ticket对象和Flight对象
//        Ticket ticket = mock(Ticket.class);
//        Flight flight = mock(Flight.class);
//
//        // 设置模拟的Ticket对象的行为
//        when(ticket.getFlight()).thenReturn(flight);
//        when(flight.getDepartFrom()).thenReturn("CityA");
//        when(flight.getDepartTo()).thenReturn("CityB");
//
//        // 创建YourClass对象
//        TicketSystem ticketSystem1 = new TicketSystem();
//
//
//
//        // 调用showTicket()方法
//        boolean result = ticketSystem1.showTicket();
//
//        // 验证返回值
//        assertTrue(result); // 确保方法返回true
//    }




//    @Test
//    public void testBuyTicketWithValidPassenger() {
//
//
//        Throwable e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            dummypassenger2 = new Passenger("Junjia", "Zhang", 0, "Man",
//                    "932952939@qq.com", "+61481888206", "6666", "6666", 888);
//            dummyticket = new Ticket(1,100,dummyflight,true,dummypassenger2);
//            ArrayList<Ticket> ticketList = new ArrayList<>();
//            ticketList.add(dummyticket);
//            TicketCollection.addTickets(ticketList);
//
//                BuyTicket buyTicket = new BuyTicket();
//                buyTicket.buyTicket(1);
//
//        });
//        assertEquals("age should be in 1-100", e.getMessage());
//
//    }
    //4. Appropriate checks have been implemented to validate flight information

//    @Test
//    public void testBuyTicketWithInvalidFlightInfo() {
//        Throwable e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
//        dummypassenger2 = new Passenger("Junjia", "Zhang", 0, "Man",
//                "932952939@qq.com", "+61481888206", "6666", "6666", 888);
//        dummyticket = new Ticket(1,100,dummyflight,true,dummypassenger2);
//        ArrayList<Ticket> ticketList = new ArrayList<>();
//        ticketList.add(dummyticket);
//        TicketCollection.addTickets(ticketList);
//
//        BuyTicket buyTicket = new BuyTicket();
//        buyTicket.buyTicket(1);
//    });
//
//    }

//    @Test
//    public void testValidTicket() throws Exception {
//
//        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outputStreamCaptor));
//
//        TicketCollection.tickets = new ArrayList<>();
//        TicketCollection.tickets.add(new Ticket(1, 1000, DummyFlight, false, DummyPassenger));
//        String input = String.format("Junjia\nZhang\n21\nMan\njzha0424@student.moansh.edu\n1273861\nCN\n1\n123456\n123");
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        ticketSystem.buyTicket(1);
//
//        String expectedOutput = "This ticket does not exist.";
//
//        String actualOutput = outputStreamCaptor.toString().trim();
//
//        Assertions.assertEquals(expectedOutput, actualOutput);
//       // verify(System.out, never()).println("This ticket does not exist.");
//    }








}

