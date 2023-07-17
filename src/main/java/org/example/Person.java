package org.example;
public class Person //abstract class Person
{
    private String firstName;
    private String secondName;
    private int age;
    private String gender;

    public Person(){}

    public Person(String firstName, String secondName, int age, String gender){
        if (firstName == null || secondName == null || age == 0 ||gender == null) {
            throw new IllegalArgumentException("parameter can't be null");
        }
        if (!firstName.matches("[a-zA-Z]+") || !secondName.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("firstName and secondName should only contain alphabets");
        }
        if (!gender.equals("Woman") && !gender.equals("Man") && !gender.equals("Non-binary | gender diverse")
                && !gender.equals("Prefer not to say") && !gender.equals("Other")) {
            throw new IllegalArgumentException("gender should be one of 5");
        }
        this.age=age;
        this.firstName=firstName;
        this.secondName=secondName;
        this.gender=gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
