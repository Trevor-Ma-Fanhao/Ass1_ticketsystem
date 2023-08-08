package org.example;

import org.mockito.internal.matchers.Null;

import java.util.regex.Pattern;

public class Passenger extends Person
{
    final String AUSTRALIAN_PHONE_REGEX = "^((\\+614)|(0[45]))\\d{8}$";
    final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private String email;
    private String phoneNumber;
    private String cardNumber;
    private int securityCode;
    private String passport;

    private String firstName;
    private String secondName;
    public Passenger(){}

    public Passenger(String firstName, String secondName, int age, String gender,String email, String phoneNumber,
                     String passport, String cardNumber,int securityCode)
    {
        super(firstName, secondName, age, gender);

        if (firstName == null || secondName == null || age == 0 ||gender == null ||
                passport==null || cardNumber==null || securityCode <= 0) {
            throw new IllegalArgumentException("Parameters can't be empty");
        }
        if (!Pattern.matches(AUSTRALIAN_PHONE_REGEX,phoneNumber)){
            throw new IllegalArgumentException("phone number should be in format");
        }
        if (!Pattern.matches(EMAIL_REGEX,email)){
            throw new IllegalArgumentException("email should be in format");
        }
        if ( passport.length() > 9) {
            throw new IllegalArgumentException("Passport number should not exceed 9 characters");
        }
        this.securityCode=securityCode;
        this.cardNumber=cardNumber;
        this.passport=passport;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.firstName=firstName;
        this.secondName=secondName;
    }


    public String getFirstName() {
        return super.getFirstName();
    }
    public String getSecondName() {
        return super.getSecondName();
    }
    public void setSecondName(String secondName) {
        super.setSecondName(secondName);
    }
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }
    @Override
    public int getAge() {
        return super.getAge();
    }
    @Override
    public String getGender() {
        return super.getGender();
    }
    public void setGender(String gender) {
    super.setGender(gender);
}


    public void setPassport(String passport) {
        if ( passport.length() > 9) {
            throw new IllegalArgumentException("Passport number should not exceed 9 characters");
        }
        this.passport = passport;
    }
    public String getPassport() {
        return passport;
    }
    public void setPhoneNumber(String phoneNumber) {
        if (!Pattern.matches(AUSTRALIAN_PHONE_REGEX,phoneNumber)){
            throw new IllegalArgumentException("phone number should be in format");
        }
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setSecurityCode(int securityCode) {
        if(securityCode <= 0){
            throw new IllegalArgumentException("securityCode should be in format (>0)");
        }
        this.securityCode = securityCode;
    }
    public int getSecurityCode() {
        return securityCode;
    }
    public void setCardNumber(String cardNumber) {
        if(cardNumber == null){
            throw new IllegalArgumentException("cardNumber should be in format (can't be null)");
        }
        this.cardNumber = cardNumber;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public void setEmail(String email) {
        if (!Pattern.matches(EMAIL_REGEX,email)){
            throw new IllegalArgumentException("email should be in format");
        }
        this.email = email;
    }
    public String getEmail() {
        return email;
    }


    @Override
    public String toString()
    {
        return "Passenger{" + " Fullname= "+ super.getFirstName()+" "+super.getSecondName()+
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", passport='" + passport + "'}"
            ;
    }
}
