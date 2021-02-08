package com.hibernate.manytomany.facade;

import java.util.ArrayList;
import java.util.List;

public class CompanyDto {

    private final String name;
    private final List<EmployeeDto> employees = new ArrayList<>();

    public CompanyDto(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<EmployeeDto> getEmployees() {
        return employees;
    }
}
