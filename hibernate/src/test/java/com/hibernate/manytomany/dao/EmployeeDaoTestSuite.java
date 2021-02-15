package com.hibernate.manytomany.dao;

import com.hibernate.manytomany.Employee;
import com.hibernate.manytomany.facade.SearchProcessingException;
import com.hibernate.manytomany.facade.SearchingFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmployeeDaoTestSuite {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private SearchingFacade searchingFacade;

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

    @Test
    void testSearchEmployeeWithName() throws SearchProcessingException {
        System.out.println("Test Search Employee With Name");
        //Given
        int testEmloyee1Id = searchingFacade.addEmployeeToDbReturnId(new Employee("testFN1", "testLN1"));
        int testEmloyee2Id = searchingFacade.addEmployeeToDbReturnId(new Employee("testFN2", "testLN2"));
        int testEmloyee3Id = searchingFacade.addEmployeeToDbReturnId(new Employee("testFN3", "testLN3"));
        //When & Then
        searchingFacade.searchNameInEmployees("FN1");
        //CleanUp
        searchingFacade.cleanUpEmployeeById(testEmloyee1Id, testEmloyee2Id, testEmloyee3Id);
    }
}
