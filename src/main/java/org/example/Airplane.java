package org.example;
public class Airplane
{
    private int airplaneID;
    private String airplaneModel;
    private int businessSitsNumber;
    private int economySitsNumber;
    private int crewSitsNumber;


    public Airplane(int airplaneID, String airplaneModel, int businessSitsNumber, int economySitsNumber, int crewSitsNumber)
    {

        if (airplaneModel == null || airplaneModel.isEmpty()) {
            throw new IllegalArgumentException("airplaneModel must not be null or empty.");
        }

        if(businessSitsNumber < 1 || businessSitsNumber > 298){
            throw new IllegalArgumentException("Seat number must be in the range [1, 300].");
        }
        if(economySitsNumber < 1 || economySitsNumber > 298){
            throw new IllegalArgumentException("Seat number must be in the range [1, 300].");
        }
        if(crewSitsNumber < 1 || crewSitsNumber > 298){
            throw new IllegalArgumentException("Seat number must be in the range [1, 300].");
        }
        int totalSitsNumber = businessSitsNumber + economySitsNumber + crewSitsNumber;
        if(totalSitsNumber < 3 || totalSitsNumber > 300){
            throw new IllegalArgumentException("Seat number must be in the range [1, 300].");
        }
        if(airplaneID <= 0 ){
            throw new IllegalArgumentException("airplaneID must be positive integer.");
        }
        this.airplaneID=airplaneID;
        this.airplaneModel = airplaneModel;
        this.businessSitsNumber = businessSitsNumber;
        this.economySitsNumber = economySitsNumber;
        this.crewSitsNumber = crewSitsNumber;

    }


    public int getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(int airplaneID) {
         if (airplaneID <= 0) {
            throw new IllegalArgumentException("airplaneID must be a positive integer.");
        } else {
            this.airplaneID = airplaneID;
        }
    }


    public String getAirplaneModel() {
        return airplaneModel;
    }

    public void setAirplaneModel(String airplaneModel) {
        if (airplaneModel != null && !airplaneModel.isEmpty()) {
            this.airplaneModel = airplaneModel;
        } else {
            throw new IllegalArgumentException("airplaneModel must not be null or empty.");
        }
    }




    public int getBusinessSitsNumber() {
        return businessSitsNumber;
    }

    public void setBusinessSitsNumber(int businessSitsNumber) {
        if(businessSitsNumber < 1 || businessSitsNumber > 298){
            throw new IllegalArgumentException("Seat number must be in the range [1, 300].");
        }
        else {
            this.businessSitsNumber = businessSitsNumber;
        }
    }


    public int getEconomySitsNumber() {
        return economySitsNumber;
    }

    public void setEconomySitsNumber(int economySitsNumber) {
        if(economySitsNumber < 1 || economySitsNumber > 298){
            throw new IllegalArgumentException("Seat number must be in the range [1, 300].");
        }
        else {
            this.economySitsNumber = economySitsNumber;
        }

    }


    public int getCrewSitsNumber() {
        return crewSitsNumber;
    }

    public void setCrewSitsNumber(int crewSitsNumber) {
        if(crewSitsNumber < 1 || crewSitsNumber > 298){
            throw new IllegalArgumentException("Seat number must be in the range [1, 300].");
        }
        else {
            this.crewSitsNumber = crewSitsNumber;
        }

    }

    public String toString()
    {
        return "Airplane{" +
                "model=" + getAirplaneModel() + '\'' +
                ", business sits=" + getBusinessSitsNumber() + '\'' +
                ", economy sits=" + getEconomySitsNumber() + '\'' +
                ", crew sits=" + getCrewSitsNumber() + '\'' +
                '}';
    }



    public static Airplane getAirPlaneInfo(int airplane_id) {
        // TODO Auto-generated method stub

        return null;
    }
}