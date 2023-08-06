package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.regex.Pattern;


public class PassengerTest {

    Passenger trevor = new Passenger();
    PassengerTest(){
    }
    @BeforeEach
    public void setup(){
        trevor = new Passenger("Fanhao", "Ma", 25, "Man", "932952939@qq.com",
                "+61481888206", "88888","88888",88888);
    }
    @Test
    public void testPassengerAllFieldsRequired() {
        Assertions.assertDoesNotThrow(()->{new Passenger("Fanhao", "Ma", 25, "Man",
                "932952939@qq.com", "+61481888206", "88888","88888",88888);});
        Assertions.assertThrows(NullPointerException.class, () -> new Passenger("Fanhao", "Ma",
                25, "Man", null, "+61481888206", "88888","88888",88888));
        Assertions.assertThrows(NullPointerException.class, () -> new Passenger("Fanhao", "Ma",
                25, "Man", "932952939@qq.com", null, "88888","88888",88888));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Passenger("Fanhao", "Ma",
                25, "Man", "932952939@qq.com", "+61481888206", null,"88888",88888));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Passenger("Fanhao", "Ma",
                25, "Man", "932952939@qq.com", "+61481888206", "88888",null,88888));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Passenger("Fanhao", "Ma",
                25, "Man", "932952939@qq.com", "+61481888206", "88888","88888",0));
    }
    @Test
    public void validateAustralianPhoneNumber(){
        Assertions.assertThrows(IllegalArgumentException.class,()-> new Passenger("Fanhao", "Ma",
                24, "Man", "932952939@qq.com", "+8681888206", "null","null",888));
        Assertions.assertDoesNotThrow(() -> {
            new Passenger("John", "Doe", 30, "Prefer not to say", "john.doe@example.com",
                    "+61456789012", "ABCD1234","5678",999);});
        Assertions.assertDoesNotThrow(() -> {
            new Passenger("Alice", "Smith", 25, "Prefer not to say", "alice.smith@example.com",
                    "0441234567", "EFGH5678","1234",777);});
    }
    @Test
    public void validateEmailAddress(){
        Assertions.assertThrows(IllegalArgumentException.class,()-> new Passenger("Fanhao", "Ma",
                24, "Man", "932952939", "+61481888206", "6666","6666",888));
        Assertions.assertDoesNotThrow(() -> {new Passenger("Fanhao", "Ma", 24, "Man",
                "932952939@qq.com", "+61481888206", "6666","6666",888);});
    }
    @Test
    public void validatePassport(){
        Assertions.assertThrows(IllegalArgumentException.class,()-> new Passenger("Fanhao", "Ma",
                24, "Man", "932952939", "+61481888206", "6666666666","6666",888));
        Assertions.assertDoesNotThrow(() -> {new Passenger("Fanhao", "Ma", 24, "Man", "932952939@qq.com",
                    "+61481888206", "666666666","6666",888);});
    }
    @Test
    public void testGetFirstNameAndSecondName() {
        String firstName = trevor.getFirstName();
        String secondName = trevor.getSecondName();

        Assertions.assertTrue(firstName.matches("[a-zA-Z]+"));
        Assertions.assertTrue(secondName.matches("[a-zA-Z]+"));

        Assertions.assertFalse(firstName.isEmpty());
        Assertions.assertFalse(secondName.isEmpty());

    }
    @Test
    public void testSetFirstNameAndSecondName(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> trevor.setFirstName("Trevor258"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> trevor.setFirstName("@lex"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> trevor.setSecondName("Ma$"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> trevor.setSecondName("L1 ee"));
        Assertions.assertDoesNotThrow(() -> trevor.setFirstName("Cristiano"));
        Assertions.assertDoesNotThrow(() -> trevor.setSecondName("Ronaldo"));
        trevor.setFirstName("jack");
        trevor.setSecondName("Ma");
    }
    @Test
    public void testgetgender(){
        String gen = trevor.getGender();
        Assertions.assertTrue(gen.equals("Woman") || gen.equals("Man") || gen.equals("Non-binary | gender diverse")
                || gen.equals("Prefer not to say") || gen.equals("Other"));
    }
    @Test
    public void testsetgender(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> trevor.setGender("Male"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> trevor.setGender("Child"));
        Assertions.assertDoesNotThrow(() -> trevor.setGender("Prefer not to say"));
    }
    @Test
    public void testgetAge(){
        int age = trevor.getAge();
        Assertions.assertTrue(age >= 1 && age <= 100);
    }
    @Test
    public void testsetAge(){
        Assertions.assertDoesNotThrow(() -> trevor.setAge(30));
        Assertions.assertThrows(IllegalArgumentException.class, () -> trevor.setAge(130));
        Assertions.assertThrows(IllegalArgumentException.class, () -> trevor.setAge(-10));
        Assertions.assertThrows(IllegalArgumentException.class, () -> trevor.setAge(101));
        Assertions.assertThrows(IllegalArgumentException.class, () -> trevor.setAge(-1));
        Assertions.assertDoesNotThrow(() -> trevor.setAge(100));
        Assertions.assertDoesNotThrow(() -> trevor.setAge(1));
    }
    @Test
    public void testsetPassport(){
        Assertions.assertDoesNotThrow(() -> trevor.setPassport("440509199"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> trevor.setPassport("4405091999"));
    }
    @Test
    public void testgetPassort(){
        Assertions.assertTrue(()-> trevor.getPassport().length() < 9);
        Assertions.assertEquals("88888",trevor.getPassport());
    }
    @Test
    public void testsetPhoneNumber(){
        Assertions.assertDoesNotThrow(() -> trevor.setPhoneNumber("+61481888206"));
        Assertions.assertDoesNotThrow(() -> trevor.setPhoneNumber("0581888206"));
        Assertions.assertDoesNotThrow(() -> trevor.setPhoneNumber("0481888206"));
        Assertions.assertThrows(IllegalArgumentException.class,() -> trevor.setPhoneNumber("058188820"));
        Assertions.assertThrows(IllegalArgumentException.class,() -> trevor.setPhoneNumber("05818882066"));

    }
    @Test
    public void testgetPhoneNumber(){
        Assertions.assertEquals("+61481888206", trevor.getPhoneNumber());
        Assertions.assertTrue(Pattern.matches("^((\\+614)|(0[45]))\\d{8}$",trevor.getPhoneNumber()));
    }
    @Test
    public void testsetSecurityCode(){
        Assertions.assertThrows(IllegalArgumentException.class,() -> trevor.setSecurityCode(-1));
        Assertions.assertDoesNotThrow(() -> trevor.setSecurityCode(88888));
    }
    @Test
    public void testsetCardNumber(){
        Assertions.assertTrue(trevor.getSecurityCode() > 0);
        Assertions.assertTrue(trevor.getSecurityCode() == 88888);
    }
    @Test
    public void testgetCardNumber(){
        Assertions.assertTrue(trevor.getCardNumber() != null);
        Assertions.assertEquals(trevor.getCardNumber(), "88888");
    }
    @Test
    public void testToString() {
        String expectedOutput = "Passenger{ Fullname= Fanhao Ma, email='932952939@qq.com', phoneNumber='+61481888206', passport='88888'}";
        String actualOutput = trevor.toString();
        Assertions.assertEquals(expectedOutput, actualOutput);
    }
}