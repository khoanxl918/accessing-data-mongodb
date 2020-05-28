package com.example.accessingdatamongodb.model;

import org.springframework.data.annotation.Id;

public class Customer {

    @Id
    //use public in example for simplicity (without generating getters/setters) ????
    private String id; //match MongoDB pattern and used mainly by it.
    private String firstName;
    private String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%s, firstName=%s, lastName=%s]", id, firstName, lastName);
    }
}
