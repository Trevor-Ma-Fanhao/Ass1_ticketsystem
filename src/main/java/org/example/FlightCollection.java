package org.example;
import java.util.ArrayList;

public class FlightCollection {
	
	//public static ArrayList<Flight> flights;
	public static ArrayList<Flight> flights = new ArrayList<>();

	public static ArrayList<Flight> getFlights() {

		return flights;
	}


	public static boolean validateCity(String cityName) {
		if (cityName == null) {
			throw new IllegalArgumentException("City cannot be empty");
		} else if (!cityName.matches("^[a-zA-Z\\s]+$")) {
			throw new IllegalArgumentException("Invalid city name: City name can only contain letters and spaces");
		}

		return true;
	}

//	public static void addFlights(ArrayList<Flight> flights) {
//
//		FlightCollection.flights.addAll(flights);
//	}


	public static void addFlights(ArrayList<Flight> newFlights) {
		if (newFlights == null || newFlights.contains(null)) {
			throw new IllegalArgumentException("Flight collection cannot be null or contain null value");
		}

		FlightCollection.flights.addAll(newFlights);
	}

	public static Flight getFlightInfo(String city1, String city2) {
    	//display the flights where there is a direct flight from city 1 to city2
		if(validateCity(city1) || validateCity(city2)){
			throw new IllegalArgumentException("Invalid city name: City name can only contain letters and spaces");
		}
    	return null;
    }
    
//    public static Flight getFlightInfo(String city) {
//    	//SELECT a flight where depart_to = city
//    	return null;
//
//    }

	public static Flight getFlightInfo(String city) {
		//SELECT a flight where depart_to = city

		if(validateCity(city)){
			throw new IllegalArgumentException("Invalid city name: City name can only contain letters and spaces");
		}

		return null;

	}
    public static Flight getFlightInfo(int flight_id) {
    	//SELECT a flight with a particular flight id
    	return null;

    }
    

}
