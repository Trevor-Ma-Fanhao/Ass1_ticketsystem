package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    private Person trevor;
    PersonTest(){
    }
    @BeforeEach
    public void setup(){
        trevor = new Person("trevor", "Ma", 24, "Man");
    }
    @Test
    public void testPersonAllFieldsRequired() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Person(null, "Ma", 25, "Man"));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Person("Fanhao", null, 25, "Man"));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Person("Fanhao", "Ma", 0, "Man"));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Person("Fanhao", "Ma", 25, null));
    }
    @Test
    public void testValidGenderOptions() {
        //String[] validGenders = {"Woman", "Man", "Non-binary | gender diverse", "Prefer not to say", "Other"};
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Person("trevor", "Ma", 24, "boy"));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Person("trevor", "Ma", 24, "evwhcv"));
        Assertions.assertDoesNotThrow(() -> {new Person("trevor", "Ma", 24, "Man");});
    }
    @Test
    public void testInvalidNameFormat() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Person("123John", "Doe", 25, "Man"));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Person("John", "123Doe", 25, "Man"));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Person("!@#$", "Doe", 25, "Man"));
    }
    @Test
    public void testgetAge(){
        int age = trevor.getAge();
        Assertions.assertTrue(age >= 1 && age <= 100);
    }
    @Test void testsetAge(){
        Assertions.assertDoesNotThrow(() -> trevor.setAge(30));
        Assertions.assertThrows(IllegalArgumentException.class, () -> trevor.setAge(130));
        Assertions.assertThrows(IllegalArgumentException.class, () -> trevor.setAge(-10));
        Assertions.assertThrows(IllegalArgumentException.class, () -> trevor.setAge(101));
        Assertions.assertThrows(IllegalArgumentException.class, () -> trevor.setAge(-1));
        Assertions.assertDoesNotThrow(() -> trevor.setAge(100));
        Assertions.assertDoesNotThrow(() -> trevor.setAge(1));
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
    public void testToString() {
        String tostring = trevor.toString();
        Assertions.assertEquals("Person{firstName='trevor', secondName='Ma', age=24, gender='Man'}", tostring);
    }
}