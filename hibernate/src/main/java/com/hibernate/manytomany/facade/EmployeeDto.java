package com.hibernate.manytomany.facade;

public class EmployeeDto {

    private final String firstName;
    private final String lastName;

    public EmployeeDto(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
