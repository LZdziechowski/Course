package com.hibernate.manytomany.dao;

import com.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmployeeDaoTestSuite {

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testNamedQueryEmployee() {
        System.out.println("Test NamedQuery retrieveEmployeeWhoseLastNameIs in Employee class");
        //Given
        final Employee johnSmith = new Employee("John", "Smith");
        employeeDao.save(johnSmith);
        final Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        employeeDao.save(stephanieClarckson);
        final Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        employeeDao.save(lindaKovalsky);
        //When
        final List<Employee> resultList = employeeDao.retrieveEmployeeWhoseLastNameIs("Kovalsky");
        //Then
        assertNotEquals(0, resultList.size());
        //CleanUp
        final int johnSmithId = johnSmith.getId();
        employeeDao.deleteById(johnSmithId);
        final int stephanieClarcksonId = stephanieClarckson.getId();
        employeeDao.deleteById(stephanieClarcksonId);
        final int lindaKovalskyId = lindaKovalsky.getId();
        employeeDao.deleteById(lindaKovalskyId);
    }
}
