package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PassengerTest {
    PassengerTest(){
    }
    @Test
    public void testPassengerAllFieldsRequired() {
        Assertions.assertDoesNotThrow(()->{new Passenger("Fanhao", "Ma", 25, "Man",
                "932952939@qq.com", "+61481888206", "88888","88888",88888);});
        Assertions.assertThrows(NullPointerException.class, () -> {
            new Passenger("Fanhao", "Ma", 25, "Man", null, "+61481888206",
                    "88888","88888",88888);
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            new Passenger("Fanhao", "Ma", 25, "Man", "932952939@qq.com", null,
                    "88888","88888",88888);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Passenger("Fanhao", "Ma", 25, "Man", "932952939@qq.com", "+61481888206",
                    null,"88888",88888);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Passenger("Fanhao", "Ma", 25, "Man", "932952939@qq.com", "+61481888206",
                    "88888",null,88888);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Passenger("Fanhao", "Ma", 25, "Man", "932952939@qq.com", "+61481888206",
                    "88888","88888",0);
        });
    }
    @Test
    public void validateAustralianPhoneNumber(){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            new Passenger("Fanhao", "Ma", 24, "Man", "932952939@qq.com",
                    "+8681888206", "null","null",888);
        });
        Assertions.assertDoesNotThrow(() -> {
            new Passenger("John", "Doe", 30, "Prefer not to say", "john.doe@example.com",
                    "+61456789012", "ABCD1234","5678",999);
        });

        Assertions.assertDoesNotThrow(() -> {
            new Passenger("Alice", "Smith", 25, "Prefer not to say", "alice.smith@example.com",
                    "0441234567", "EFGH5678","1234",777);
        });
    }
    @Test
    public void validateEmailAddress(){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            new Passenger("Fanhao", "Ma", 24, "Man", "932952939",
                    "+61481888206", "6666","6666",888);
        });
        Assertions.assertDoesNotThrow(() -> {
            new Passenger("Fanhao", "Ma", 24, "Man", "932952939@qq.com",
                    "+61481888206", "6666","6666",888);
        });
    }
    @Test
    public void validatePassport(){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            new Passenger("Fanhao", "Ma", 24, "Man", "932952939",
                    "+61481888206", "6666666666666","6666",888);
        });
        Assertions.assertDoesNotThrow(() -> {
            new Passenger("Fanhao", "Ma", 24, "Man", "932952939@qq.com",
                    "+61481888206", "6666","6666",888);
        });
    }

}