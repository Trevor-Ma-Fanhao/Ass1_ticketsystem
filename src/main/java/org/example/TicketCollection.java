package org.example;

import java.util.ArrayList;


public class TicketCollection {

	public ArrayList<Ticket> tickets;
	//在类的静态块中对其进行初始化
	public TicketCollection() {
		tickets = new ArrayList<>();
	}
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}
	public void addTickets(ArrayList<Ticket> tickets_db) {
		if (tickets_db == null)
			throw new IllegalArgumentException("Ticket list cannot contain null");
		tickets.addAll(tickets_db);
	}
	public void getAllTickets() {
		//display all available tickets from the Ticket collection
		for (Ticket ticket : tickets) {
			System.out.println(ticket.toString());
		}
	}
	public Ticket getTicketInfo(int ticket_id) {
		//SELECT a ticket where ticket id = ticket_id
		for (Ticket ticket : tickets) {
			if (ticket.getTicket_id() == ticket_id) {
				return ticket;
			}
		}
		return null;
	}
//	public static ArrayList<Ticket> tickets;
//	//在类的静态块中对其进行初始化
//	static {
//		tickets = new ArrayList<>();
//	}
//	public static ArrayList<Ticket> getTickets() {
//		return tickets;
//	}
//	public static void addTickets(ArrayList<Ticket> tickets_db) {
//		if (tickets_db == null)
//			throw new IllegalArgumentException("Ticket list cannot contain null");
//		TicketCollection.tickets.addAll(tickets_db);
//	}
//	public static void getAllTickets() {
//    	//display all available tickets from the Ticket collection
//		for (Ticket ticket : tickets) {
//			System.out.println(ticket.toString());
//		}
//    }
//	public static Ticket getTicketInfo(int ticket_id) {
//    	//SELECT a ticket where ticket id = ticket_id
//		for (Ticket ticket : tickets) {
//			if (ticket.getTicket_id() == ticket_id) {
//				return ticket;
//			}
//		}
//    	return null;
//    }
}
