package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    PersonTest(){
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
}