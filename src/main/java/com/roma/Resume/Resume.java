package com.roma.Resume;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "resume")
public class Resume {
    @Id
    String id;
    String firstName;
    String lastName;
    int age;
    String email;
    String city;
    String vacancy;
    int salary;
    String educationalInstitution;

    public Resume() {

    }

    public Resume(String firstName, String lastName, int age, String email, String city, String vacancy,
                  int salary, String educationalInstitution) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.age = age;
        this.email = email;
        this.city = city;
        this.vacancy = vacancy;
        this.salary = salary;
        this.educationalInstitution = educationalInstitution;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVacancy() {
        return vacancy;
    }

    public void setVacancy(String vacancy) {
        this.vacancy = vacancy;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEducationalInstitution() {
        return educationalInstitution;
    }

    public void setEducationalInstitution(String educationalInstitution) {
        this.educationalInstitution = educationalInstitution;
    }
}