package com.moises;

public class Person {

    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String country;
    private Integer age;
    private String dob;
    private Integer registerNumber;

    public Person(Long id, String firstName, String lastName, String gender, String country, Integer age, String dob, Integer registerNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.country = country;
        this.age = age;
        this.dob = dob;
        this.registerNumber = registerNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(Integer registerNumber) {
        this.registerNumber = registerNumber;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", First Name: '" + firstName + '\'' +
                ", Last Name: '" + lastName + '\'' +
                ", Gender: '" + gender + '\'' +
                ", DOB: '" + dob + '\'' +
                ", Age: " + age +
                ", Country: '" + country + '\'' +
                ", Register Number: " + registerNumber;
    }
}
