package org.example;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Flight {
    private int flightID;
    private String departTo;
    private String departFrom;
    private String code;
    private String company;
    private Timestamp dateFrom;
    private Timestamp dateTo;
    Airplane airplane;
    
    public Flight(){}


    public static boolean isValidDateFormat(Timestamp timestamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        dateFormat.setLenient(false); // Disable leniency to enforce strict format validation

        String formattedDate = dateFormat.format(timestamp);

        if (!formattedDate.matches("\\d{2}/\\d{2}/\\d{2}")) {
            return false;
        }

        int day = Integer.parseInt(formattedDate.substring(0, 2));
        int month = Integer.parseInt(formattedDate.substring(3, 5));
        int year = Integer.parseInt(formattedDate.substring(6, 8));

        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 0) {
            return false;
        }

        return true;
    }

    public static boolean isValidTimeFormat(Timestamp timestamp) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        timeFormat.setLenient(false); // Disable leniency to enforce strict format validation

        String formattedTime = timeFormat.format(timestamp);

        if (!formattedTime.matches("\\d{2}:\\d{2}:\\d{2}")) {
            return false;
        }

        int hour = Integer.parseInt(formattedTime.substring(0, 2));
        int minute = Integer.parseInt(formattedTime.substring(3, 5));
        int second = Integer.parseInt(formattedTime.substring(6, 8));

        if (hour < 0 || hour > 23 || minute < 0 || minute > 59 || second < 0 || second > 59) {
            return false;
        }

        return true;
    }


    public Flight(int flight_id, String departTo, String departFrom, String code, String company, Timestamp dateFrom,Timestamp dateTo, Airplane airplane)
    {
        if (flight_id <= 0) {
            throw new IllegalArgumentException("Flight ID should be positive number");
        }
        if (departTo == null) {
            throw new IllegalArgumentException("the Depart to destination cannot be empty");
        }
        if (departFrom == null) {
            throw new IllegalArgumentException("the Depart from place cannot be empty");
        }
        if (code == null) {
            throw new IllegalArgumentException("the code cannot be empty");
        }
        if (company == null) {
            throw new IllegalArgumentException("the company cannot be empty");
        }
        if (dateFrom == null)
            throw new IllegalArgumentException("Date from cannot be null");
        if (dateFrom.before(new Timestamp(System.currentTimeMillis()))) {
            throw new IllegalArgumentException("Date from cannot before current time");
        }

        if(isValidDateFormat(dateFrom)== false)
            throw new IllegalArgumentException("DateFrom format is invalid.");
        if(isValidTimeFormat(dateFrom) == false)
            throw new IllegalArgumentException("TimeFrom format is invalid.");

        if(isValidDateFormat(dateTo)== false)
            throw new IllegalArgumentException("DateTo format is invalid.");
        if(isValidTimeFormat(dateTo) == false)
            throw new IllegalArgumentException("TimeTo format is invalid.");

        if (dateTo.before(new Timestamp(System.currentTimeMillis())) || dateTo.before(dateFrom)) {
            throw new IllegalArgumentException("Date from cannot before current time or Date from");
        }
        if (airplane == null) {
            throw new IllegalArgumentException("airplane cannot be empty");
        }
            this.flightID=flight_id;
            this.departTo = departTo;
            this.departFrom = departFrom;
            this.code = code;
            this.company = company;
            this.airplane = airplane;
            this.dateTo = dateTo;
            this.dateFrom = dateFrom;
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
        if (departTo == null) {
            throw new IllegalArgumentException("the Depart to destination cannot be empty");
        }
        this.departTo = departTo;
    }

    public String getDepartFrom() {
        return departFrom;
    }

    public void setDepartFrom(String departFrom) {
        if (departFrom == null) {
            throw new IllegalArgumentException("the Depart from place cannot be empty");
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

    public Timestamp getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Timestamp dateFrom) {
        if (dateFrom == null)
            throw new IllegalArgumentException("Date from cannot be null");
        if(isValidDateFormat(dateFrom)== false)
            throw new IllegalArgumentException("DateFrom format is invalid.");
        if(isValidTimeFormat(dateFrom) == false)
            throw new IllegalArgumentException("TimeFrom format is invalid.");
        if (dateFrom.before(new Timestamp(System.currentTimeMillis()))) {
            throw new IllegalArgumentException("Date from cannot before current time");
        }
        this.dateFrom = dateFrom;
    }

    public Timestamp getDateTo() {
        return dateTo;
    }

    public void setDateTo(Timestamp dateTo) {
        if (dateTo == null)
            throw new IllegalArgumentException("dateTo cannot be null");
        if(isValidDateFormat(dateTo)== false)
            throw new IllegalArgumentException("DateTo format is invalid.");
        if(isValidTimeFormat(dateTo) == false)
            throw new IllegalArgumentException("TimeTo format is invalid.");
        if (dateTo.before(new Timestamp(System.currentTimeMillis()))) {
            throw new IllegalArgumentException("dateTo cannot before current time");
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
                    ", code=" + getCode() + '\'' +
                    '}';
    }
}
