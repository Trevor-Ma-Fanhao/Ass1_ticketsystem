package org.example;
public class Person //abstract class Person
{
    private String firstName;
    private String secondName;
    private int age;
    private String gender;

    public Person(){}

    public Person(String firstName, String secondName, int age, String gender){

//            if(age>=120 || age<=0)
//            {
//                throw new IllegalArgumentException("age should be between 0 and 120");
//            }



        if (firstName == null || secondName == null || age == 0 ||gender == null) {
            throw new IllegalArgumentException("age should be in 1-100");
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
        if ( age < 1 || age > 100 ){
        throw new IllegalArgumentException("age should be in 1-100");
        }
        this.age = age;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (!gender.equals("Woman") && !gender.equals("Man") && !gender.equals("Non-binary | gender diverse")
                && !gender.equals("Prefer not to say") && !gender.equals("Other")) {
            throw new IllegalArgumentException("gender should be one of 5");
        }
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setFirstName(String firstName) {
        if (!firstName.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("firstName should only contain alphabets");
        }
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        if ( !secondName.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("secondName should only contain alphabets");
        }
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
