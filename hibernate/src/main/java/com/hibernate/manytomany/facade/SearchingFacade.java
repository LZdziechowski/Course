package com.hibernate.manytomany.facade;

import com.hibernate.manytomany.Company;
import com.hibernate.manytomany.Employee;
import org.springframework.stereotype.Service;

import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Company.retrieveCompanyWithCharacters",
                query = "SELECT * FROM companies WHERE companies.name LIKE CONCAT('%', :CHARACTERS, '%')",
                resultClass = Company.class
        ),
        @NamedNativeQuery(
                name = "Employee.retrieveEmployeeWhoseNameIs",
                query = "SELECT * FROM employees WHERE employees.firstname LIKE CONCAT('%', :NAME, '%') " +
                        "or employees.lastname LIKE CONCAT('%', :NAME, '%')",
                resultClass = Employee.class
        )
})


@Service
public class SearchingFacade {

        public


}
