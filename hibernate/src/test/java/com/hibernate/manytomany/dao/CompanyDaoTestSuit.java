package com.hibernate.manytomany.dao;

import com.hibernate.manytomany.Company;
import com.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CompanyDaoTestSuit {

    @Autowired
    private CompanyDao companyDao;

    @Test
    void testSaveManyToMany() {
        //Given
        final Employee johnSmith = new Employee("John", "Smith");
        final Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        final Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        final Company softwareMachine = new Company("Software Machine");
        final Company dataMaesters = new Company("Data Maesters");
        final Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        final int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        final int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        final int greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    void testNamedNativeQueryCompanies() {
        System.out.println("Test NamedNativeQuery retrieveCompanyWithFirst3Char in Company class");
        //Given
        final Company softwareMachine = new Company("Software Machine");
        companyDao.save(softwareMachine);
        final Company dataMaesters = new Company("Data Maesters");
        companyDao.save(dataMaesters);
        final Company greyMatter = new Company("Grey Matter");
        companyDao.save(greyMatter);
        //When
        final List<Company> resultList = companyDao.retrieveCompanyWithFirstChar("Sof");
        //Then
        assertNotEquals(0, resultList.size());
        //CleanUp
        final int softwareMachineId = softwareMachine.getId();
        companyDao.deleteById(softwareMachineId);
        final int dataMaestersId = dataMaesters.getId();
        companyDao.deleteById(dataMaestersId);
        final int greyMatterId = greyMatter.getId();
        companyDao.deleteById(greyMatterId);
    }
}
