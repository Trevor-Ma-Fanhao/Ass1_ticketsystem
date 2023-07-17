package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    PersonTest(){
    }
    @Test
    public void testPersonAllFieldsRequired() {
        // 方法应该移出 testAllFieldsRequired 方法的内部
        // 并且没有必要将该方法声明为 final
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Person(null, null, 0, null);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Person(null, null, 0, null);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Person(null, null, 0, null);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Person(null, null, 0, null);
        });
    }
    @Test
    public void testValidGenderOptions() {
        //String[] validGenders = {"Woman", "Man", "Non-binary | gender diverse", "Prefer not to say", "Other"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Person("trevor", "Ma", 24, "boy" );
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Person("trevor", "Ma", 24, "girl");
        });
    }
    @Test
    public void testInvalidNameFormat() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Person("123John", "Doe", 25, "Man");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Person("John", "123Doe", 25, "Man");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Person("!@#$", "Doe", 25, "Man");
        });
    }
}