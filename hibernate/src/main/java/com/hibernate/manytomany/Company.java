package com.hibernate.manytomany;

import com.hibernate.manytomany.facade.ListType;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Company.retrieveCompanyWithFirstChar",
                query = "SELECT * FROM COMPANIES WHERE SUBSTRING(NAME, 1, 3) = :CHARACTERS",
                resultClass = Company.class
        ),
        @NamedNativeQuery(
                name = "Company.retrieveCompanyWithCharacters",
                query = "SELECT * FROM companies WHERE companies.name LIKE CONCAT('%', :CHARACTERS, '%')",
                resultClass = Company.class
        )
})

@Entity
@Table(name = "COMPANIES")
public class Company implements ListType {

    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COMPANY_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    public List<Employee> getEmployees() {
        return employees;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
