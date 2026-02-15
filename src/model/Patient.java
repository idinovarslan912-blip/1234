package model;

import enums.Gender;

public class Patient {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;

    public Patient(Long id, String firstName, String lastName, int age, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public Long getId() { return id; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
