package org.example;

import java.util.regex.Pattern;

public class Passenger extends Person
{
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
        final String AUSTRALIAN_PHONE_REGEX = "^((\\+614)|(0[45]))\\d{8}$";
        final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (firstName == null || secondName == null || age == 0 ||gender == null ||
                passport==null||cardNumber==null||securityCode <= 0) {
            throw new IllegalArgumentException("age should be in 1-100");
        }
        if (!Pattern.matches(AUSTRALIAN_PHONE_REGEX,phoneNumber)){
            throw new IllegalArgumentException("phone number should be in format");
        }
        if (!Pattern.matches(EMAIL_REGEX,email)){
            throw new IllegalArgumentException("email should be in format");
        }
        if (passport != null && passport.length() > 9) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public void setSecondName(String secondName) {
        super.setSecondName(secondName);
    }

    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    public String getPassport() {
        return passport;
    }

    public void setGender(String gender) {
        super.setGender(gender);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public String getGender() {
        return super.getGender();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public String toString()
    {
        return "Passenger{" + " Fullname= "+ super.getFirstName()+" "+super.getSecondName()+
                " ,email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", passport='" + passport +
                '}';
    }
}
