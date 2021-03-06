package com.hibernate.manytomany;

import com.hibernate.manytomany.facade.ListType;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQuery(
        name = "Employee.retrieveEmployeeWhoseLastNameIs",
        query = "FROM Employee WHERE lastName = :LASTNAME"
)

@NamedNativeQuery(
        name = "Employee.retrieveEmployeeWhoseNameIs",
        query = "SELECT * FROM employees WHERE employees.firstname LIKE CONCAT('%', :NAME, '%') " +
                "or employees.lastname LIKE CONCAT('%', :NAME, '%')",
        resultClass = Employee.class
)

@Entity
@Table(name = "EMPLOYEES")
public class Employee implements ListType {

    private int id;
    private String firstName;
    private String lastName;
    private List<Company> companies = new ArrayList<>();

    public Employee() {
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "EMPLOYEE_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "FIRSTNAME")
    public String getFirstName() {
        return firstName;
    }

    @NotNull
    @Column(name = "LASTNAME")
    public String getLastName() {
        return lastName;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_COMPANY_EMPLOYEE",
            joinColumns = {@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID")}
    )
    public List<Company> getCompanies() {
        return companies;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}
