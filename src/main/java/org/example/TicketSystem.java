package org.example;

import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class TicketSystem {

    Scanner in = new Scanner(System.in);

    Passenger passenger = new Passenger();
    Ticket ticket = new Ticket();
    Ticket ticket_first= new Ticket();
    Ticket ticket_second= new Ticket();
    Flight flight = new Flight();
    private TicketCollection ticketCollection;
    private FlightCollection flightCollection;

    public TicketSystem()
    {
    }
    public TicketSystem(TicketCollection ticketCollection,FlightCollection flightCollection,Scanner in){
        this.ticketCollection = ticketCollection;
        this.flightCollection = flightCollection;
        this.in = in;
    }


//    public TicketSystem()
//    {
//        passenger = new Passenger();
//        ticket = new Ticket();
//        flight = new Flight();
//    }
//    public TicketSystem(Passenger passenger, Flight flight, Ticket ticket) {
//        this.passenger = passenger;
//        this.ticket = ticket;
//        this.flight = flight;
//
//        this.ticket.setTicketStatus(true);
//    }



        private boolean isAlpha(String input) {
            return input.matches("[a-zA-Z]+");
        }

        //BuyTicket buyTicket = new BuyTicket();


        public void chooseTicket(String city1, String city2) throws Exception {
            if (!isAlpha(city1) || !isAlpha(city2)) {
                throw new IllegalArgumentException("City names should contain only English letters.");
            }
            int counter = 1;
            int idFirst = 0;
            int idSecond = 0;

            Flight flight = new Flight();
            Ticket ticket = new Ticket();

            //search for direct flight from city1 to city2

            flight = flightCollection.getFlightInfo(city1, city2);
          //  flight.toString();
            if (flight != null) {


                ticketCollection.getAllTickets();
                System.out.println("\nEnter ID of ticket you want to choose:");
                //validate ticker here  验证是否选定的票有效
                ticket = ticketCollection.getTicketInfo(2);
                System.out.println("\nticket you choose is :");
                ticket.toString();
                if (ticket.ticketStatus() == true) {
                    System.out.println("\nticket is ordered by other people!");
                    throw new IllegalArgumentException("ticket is ordered by other people!");
                }
                //buy ticket here
                buyTicket(2);
                return;
            } else
                //in case there is no direct ticket from city1 to city2
                System.out.println("\nin case there is no direct ticket from city1 to city2");
            {
                //SELECT a flight where depart_to = city2

                Flight depart_to = flightCollection.getFlightInfo(city2);

                //and search for city with depart_from as connector city

                String connectCity = depart_to.getDepartFrom();

                //SELECT * from flight where depart_to = '" + connectCity + "' and depart_from = '" + city1+"'"

                Flight flightConnectingTwoCities = flightCollection.getFlightInfo(city1, connectCity);


                if (flightConnectingTwoCities != null) {

                    System.out.println("There is special way to go there. And it is transfer way, like above. Way №" + counter);

                    counter++;

                    buyTicket(2, 4); //pass two tickets and buy them
                }


                if (counter == 1) {
                    System.out.println("There is no possible variants.");
                }
                return;
            }


        }

        public void buyTicket(int ticket_id) throws Exception
        //method for buying one ticket with direct flight
        {
            int flight_id = 0;

            //select ticket where ticket_id="+ticket_id"
            Ticket validTicket = ticketCollection.getTicketInfo(ticket_id);
            ticketCollection.getAllTickets();
            System.out.println(ticket_id);

            //if there is a valid ticket id was input then we buy it, otherwise show message
            if (validTicket == null) {
                System.out.println("This ticket does not exist1111111.");
                return;
            } else {
                //select flight_id from ticket where ticket_id=" + ticket_id

                flight_id = validTicket.getFlight().getFlightID();

                try {
                    System.out.println("Enter your First Name: ");
                    String firstName = "";
                    firstName = in.nextLine();
                    passenger.setFirstName(firstName);


                    System.out.println("Enter your Second name:");
                    String secondName = "";
                    secondName = in.nextLine();
                    passenger.setSecondName(secondName); //setting passengers info

                    System.out.println("Enter your age:");
                    Integer age = 0;
                    age = Integer.valueOf(in.nextLine());
                    passenger.setAge(age);

                    System.out.println("Enter your gender: ");
                    String gender = "";
                    gender = in.nextLine();
                    passenger.setGender(gender);

                    System.out.println("Enter your e-mail address");
                    String email = "";
                    email = in.nextLine();
                    passenger.setEmail(email);

                    System.out.println("Enter your phone number (+7):");
                    String phoneNumber = "";
                    phoneNumber = in.nextLine();
                    passenger.setPhoneNumber(phoneNumber);

                    System.out.println("Enter your passport number:");
                    String passportNumber = "";
                    passportNumber = in.nextLine();
                    passenger.setPassport(passportNumber);

                    System.out.println("Do you want to purchase?\n 1-YES 0-NO");
                    System.out.println("111");
                    int purch = in.nextInt();
                    //判断是否继续购买
                    if (purch == 0) {
                        return;
                    } else {

                        flight = flightCollection.getFlightInfo(flight_id);

                        int airplane_id = flight.getAirplane().getAirplaneID();
                        System.out.println(airplane_id);

                        Airplane airplane = Airplane.getAirPlaneInfo(airplane_id);

                        ticket = ticketCollection.getTicketInfo(ticket_id);

                        ticket.setPassenger(passenger);
                        ticket.setTicket_id(ticket_id);
                        ticket.setFlight(flight);
                        ticket.setPrice(ticket.getPrice());
                        ticket.setClassVip(ticket.getClassVip());
                        ticket.setTicketStatus(true);
                        if (ticket.getClassVip() == true) {
                            airplane.setBusinessSitsNumber(airplane.getBusinessSitsNumber() - 1);
                        } else {
                            airplane.setEconomySitsNumber(airplane.getEconomySitsNumber() - 1);
                        }

                    }
                    System.out.println("Your bill: " + ticket.getPrice() );

                    String temp = in.nextLine();
                    System.out.println("Enter your card number:");

                    String cardNumber = "";
                    cardNumber = in.nextLine();
                    passenger.setCardNumber(cardNumber);

                    System.out.println("Enter your security code:");
                    Integer securityCode = 0;
                    securityCode = Integer.valueOf(in.nextLine());
                    passenger.setSecurityCode(securityCode);
                    System.out.println("Success");



                } catch (PatternSyntaxException patternException) {
                    patternException.printStackTrace();
                }

            }

        }

        public void buyTicket(int ticket_id_first, int ticket_id_second) throws Exception {
            //method for buying two tickets with transfer flight
            int flight_id_first = 0;

            int flight_id_second = 0;


            System.out.println(ticket_id_first + " " + ticket_id_second);

            Ticket validTicketfirst = ticketCollection.getTicketInfo(ticket_id_first);

            Ticket validTicketSecond = ticketCollection.getTicketInfo(ticket_id_second);


            System.out.println("Processing...");

            //if there is a valid ticket id was input then we buy it, otherwise show message

            if (validTicketfirst == null || validTicketSecond == null) {
                System.out.println("This ticket does not exist.");
                return;
            } else {
                flight_id_first = validTicketfirst.getFlight().getFlightID();

                flight_id_second = validTicketSecond.getFlight().getFlightID();


                try {
                    System.out.println("Enter your First Name: ");
                    String firstName = "";
                    firstName = in.nextLine();
                    passenger.setFirstName(firstName);


                    System.out.println("Enter your Second name:");
                    String secondName = "";
                    secondName = in.nextLine();
                    passenger.setSecondName(secondName); //setting passengers info

                    System.out.println("Enter your age:");
                    Integer age = 0;
                    age = Integer.valueOf(in.nextLine());
                    passenger.setAge(age);

                    System.out.println("Enter your gender: ");
                    String gender = "";
                    gender = in.nextLine();
                    passenger.setGender(gender);

                    System.out.println("Enter your e-mail address");
                    String email = "";
                    email = in.nextLine();
                    passenger.setEmail(email);

                    System.out.println("Enter your phone number (+7):");
                    String phoneNumber = "";
                    phoneNumber = in.nextLine();
                    passenger.setPhoneNumber(phoneNumber);

                    System.out.println("Enter your passport number:");
                    String passportNumber = "";
                    passportNumber = in.nextLine();
                    passenger.setPassport(passportNumber);

                    System.out.println("Do you want to purchase?\n 1-YES 0-NO");
                    int purch = in.nextInt();
                    if (purch == 0) {
                        return;
                    } else {

                        //  "select * from flight, airplane where flight_id=" + flight_id_first + " and flight.airplane_id=airplane.airplane_id");
                        Flight flight_first = flightCollection.getFlightInfo(flight_id_first);
                        Flight flight_second = flightCollection.getFlightInfo(flight_id_second);

                        int airplane_id_first = flight_first.getAirplane().getAirplaneID();
                        int airplane_id_second = flight_second.getAirplane().getAirplaneID();

                        Airplane airplane_first = Airplane.getAirPlaneInfo(airplane_id_first);
                        Airplane airpairplane_second = Airplane.getAirPlaneInfo(airplane_id_second);

//                      Ticket ticket_first = ticketCollection.getTicketInfo(ticket_id_first);
//                      Ticket ticket_second = ticketCollection.getTicketInfo(ticket_id_second);
                        ticket_first = ticketCollection.getTicketInfo(ticket_id_first);
                 //       ticket_second = ticketCollection.getTicketInfo(ticket_id_second);

                        ticket_first.setPassenger(passenger);
                        ticket_first.setTicket_id(ticket_id_first);
                        ticket_first.setFlight(flight_first);
                        ticket_first.setPrice(ticket_first.getPrice());
                        ticket_first.setClassVip(ticket_first.getClassVip());
                        ticket_first.setTicketStatus(true);

                        if (ticket_first.getClassVip() == true) {
                            airplane_first.setBusinessSitsNumber(airplane_first.getBusinessSitsNumber() - 1);
                        } else {
                            airplane_first.setEconomySitsNumber(airplane_first.getEconomySitsNumber() - 1);
                        }

                        System.out.println("--*-*-");
                        ticket_second = ticketCollection.getTicketInfo(ticket_id_second);
                        ticket_second.setPassenger(passenger);
                        ticket_second.setTicket_id(ticket_id_second);
                        ticket_second.setFlight(flight_second);
                    //    ticket_second.setPrice(ticket_second.getPrice());
                        ticket_second.setClassVip(ticket_second.getClassVip());
                        ticket_second.setTicketStatus(true);
                        if (ticket_second.getClassVip() == true) {
                            airpairplane_second.setBusinessSitsNumber(airpairplane_second.getBusinessSitsNumber() - 1);
                        } else {
                            airpairplane_second.setEconomySitsNumber(airpairplane_second.getEconomySitsNumber() - 1);
                        }


                        int totalPrice = ticket_first.getPrice() + ticket_second.getPrice();

                        System.out.println("Your bill: " + totalPrice + "\n");

                        System.out.println("Enter your card number:");

                        String cardNumber = "";
                        cardNumber = in.nextLine();
                        passenger.setCardNumber(cardNumber);

                        System.out.println("Enter your security code:");
                        Integer securityCode = 0;
                        securityCode = Integer.valueOf(in.nextLine());
                        passenger.setSecurityCode(securityCode);
                        System.out.println("Success buy two ticket");

                    }
                } catch (PatternSyntaxException patternException) {
                    patternException.printStackTrace();
                }
            }

        }

    }
