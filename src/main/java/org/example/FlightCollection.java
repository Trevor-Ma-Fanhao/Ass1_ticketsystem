package org.example;
import java.util.ArrayList;

public class FlightCollection {

	public ArrayList<Flight> flights = new ArrayList<>();
	public ArrayList<Flight> getFlights() {
		return flights;
	}

	public boolean validateCity(String cityName) {
		if (cityName == null ) {
			return false;
		}

		return true;
	}

	public void addFlights(ArrayList<Flight> newFlights) {
		if (newFlights == null || newFlights.contains(null)) {
			throw new IllegalArgumentException("Flight collection cannot be null or contain null value");
		}
		flights.addAll(newFlights);
	}

	public Flight getFlightInfo(String city1, String city2) {
		// Validate the input cities
		if (!validateCity(city1) || !validateCity(city2)) {
			throw new IllegalArgumentException("City cannot be empty");
		}

		for (Flight flight : flights) {
			if (flight.getDepartFrom().equals(city2) && flight.getDepartTo().equals(city1)) {
				return flight;
			}
		}

		return null; // No matching direct flight found
	}


	public Flight getFlightInfo(String city) {
		// SELECT a flight where depart_to = city
		if (!validateCity(city)) {
			throw new IllegalArgumentException("City cannot be empty");
		} else {
			for (Flight flight : flights) {
				if (flight.getDepartTo().equals(city)) {
					return flight;
				}
			}

		}
		return null;
	}

	public Flight getFlightInfo(int flight_id) {
		//SELECT a ticket where ticket id = ticket_id
		for (Flight flight : flights) {

			if (flight.getFlightID() == flight_id) {
				return flight;
			}
		}
		return null;
	}

}
