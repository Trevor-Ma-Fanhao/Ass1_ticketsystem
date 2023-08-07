package org.example;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Date;

public class Flight {
    private int flightID;
    private String departTo;
    private String departFrom;
    private String code;
    private String company;
    private String dateFrom;
    private String dateTo;
    Airplane airplane;



    public Flight(){}

    public boolean isValidDateFormat(String date) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");

            LocalDate parsedDate = LocalDate.parse(date, dtf);
            return true; // Format is valid
        } catch (DateTimeParseException e) {
            return false; // Format is invalid
        }
    }

    public boolean isValidTimeFormat(String timestamp) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");

            LocalTime parsedTime = LocalTime.parse(timestamp, dtf);
            return true; // Format is valid
        } catch (DateTimeParseException e) {
            return false; // Format is invalid
        }
    }


    public Flight(int flight_id, String departTo, String departFrom, String code, String company, String dateFrom,String dateTo, Airplane airplane)
    {
        if (flight_id <= 0) {
            throw new IllegalArgumentException("Flight ID should be positive number");
        }
        if (departTo == null || departTo =="") {
            throw new IllegalArgumentException("the Depart to destination cannot be empty");
        }
        if (departFrom == null || departFrom == "") {
            throw new IllegalArgumentException("the Depart from place cannot be empty");
        }
        if (code == null) {
            throw new IllegalArgumentException("the code cannot be empty");
        }
        if (company == null) {
            throw new IllegalArgumentException("the company cannot be empty");
        }


        if (!isValidDateFormat(dateFrom)) {
            throw new IllegalArgumentException("DateFrom format is invalid.");
        }
        if (!isValidTimeFormat(dateFrom)) {
            throw new IllegalArgumentException("TimeFrom format is invalid.");
        }
        if (!isValidDateFormat(dateTo)) {
            throw new IllegalArgumentException("DateTo format is invalid.");
        }
        if (!isValidTimeFormat(dateTo)) {
            throw new IllegalArgumentException("TimeTo format is invalid.");
        }


        if (airplane == null) {
            throw new IllegalArgumentException("airplane cannot be empty");
        }


            this.flightID = flight_id;
            this.departTo = departTo;
            this.departFrom = departFrom;
            this.code = code;
            this.company = company;
            this.airplane = airplane;
            this.dateFrom = dateFrom;
            this.dateTo = dateTo;
    }



    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightid) {
        if (flightid <= 0) {
            throw new IllegalArgumentException("Flight ID should be positive number");
        }
        this.flightID = flightid;

    }

    public String getDepartTo() {
        return departTo;
    }

    public void setDepartTo(String departTo) {
        if (departTo == null || departTo.isEmpty()) {
            throw new IllegalArgumentException("the Depart to destination cannot be empty");
        }
        this.departTo = departTo;
    }

    public String getDepartFrom() {
        return departFrom;
    }

    public void setDepartFrom(String departFrom) {
        if (departFrom == null || departFrom.isEmpty()) {
            throw new IllegalArgumentException("the Depart from place cannot be empty or null");
        }
        this.departFrom = departFrom;
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (code == null) {
            throw new IllegalArgumentException("the code cannot be empty");
        }
        this.code = code;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        if (company == null) {
            throw new IllegalArgumentException("the company cannot be empty");
        }
        this.company = company;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        if (dateFrom == null)
            throw new IllegalArgumentException("Date from cannot be null");

        if (!isValidDateFormat(dateFrom)) {
            throw new IllegalArgumentException("DateFrom format is invalid.");
        }

        this.dateFrom = dateFrom;
    }

    public String getDateTo() {

        return dateTo;
    }

    public void setDateTo(String dateTo) {
        if (dateTo == null)
            throw new IllegalArgumentException("Date to cannot be null");

        if (!isValidDateFormat(dateTo)) {
            throw new IllegalArgumentException("dateTo format is invalid.");
        }

        this.dateTo = dateTo;
    }

    public void setAirplane(Airplane airplane) {
        if (airplane == null) {
            throw new IllegalArgumentException("airplane cannot be empty");
        }
        this.airplane = airplane;
    }

    public Airplane getAirplane() {
        return airplane;
    }





    public String toString()
    {
            return "Flight{" + airplane.toString() +
                    ", date to=" +  getDateTo() + ", " + '\'' +
                    ", date from='" + getDateFrom() + '\'' +
                    ", depart from='" + getDepartFrom() + '\'' +
                    ", depart to='" + getDepartTo() + '\'' +
                    ", code=" + getCode() + '\'' +
                    ", company=" + getCompany() + '\'' +
                    '}';
    }
}
