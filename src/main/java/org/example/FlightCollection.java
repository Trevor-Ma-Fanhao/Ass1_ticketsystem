package org.example;

import java.util.ArrayList;

public class FlightCollection {
	
	public static ArrayList<Flight> flights;

	public static ArrayList<Flight> getFlights() {
		if (flights == null) {
			flights = new ArrayList<>();
		}
		return flights;
	}

//	public static void addFlights(ArrayList<Flight> flights) {
//
//		FlightCollection.flights.addAll(flights);
//	}


	public static void addFlights(ArrayList<Flight> newFlights) {
		if (FlightCollection.flights == null) {
			FlightCollection.flights = new ArrayList<>();
		}

		FlightCollection.flights.addAll(newFlights);
	}

	public static Flight getFlightInfo(String city1, String city2) {
    	//display the flights where there is a direct flight from city 1 to city2
		for (Flight flight : flights) {
			if (flight.getDepartFrom().equals(city1) && flight.getDepartTo().equals(city2)) {
				return flight;
			}
		}
    	return null;
//		return flights.get(0);
    }
    
//    public static Flight getFlightInfo(String city) {
//    	//SELECT a flight where depart_to = city
//    	return null;
//
//    }

	public static Flight getFlightInfo(String city) {
		//SELECT a flight where depart_to = city
		for (Flight flight : flights) {
			if (flight.getDepartTo().equals(city)) {
				return flight;
			}
		}
		return null;

	}
    public static Flight getFlightInfo(int flight_id) {
    	//SELECT a flight with a particular flight id
		for (Flight flight : flights) {
			if (flight.getFlightID() == flight_id) {
				return flight;
			}
		}
    	return null;

    }
    

}
