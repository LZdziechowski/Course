package com.hibernate.manytomany.facade;

import com.hibernate.manytomany.Company;
import com.hibernate.manytomany.Employee;
import com.hibernate.manytomany.dao.CompanyDao;
import com.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchingFacade {

    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchingFacade.class);

    @Autowired
    public SearchingFacade(final CompanyDao companyDao, final EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public int addCompanyToDbReturnId(final Company company) throws SearchProcessingException {
        LOGGER.info("Adding new company: " + company.getName());
        try {
            companyDao.save(company);
        } catch (IllegalArgumentException e) {
            LOGGER.error(SearchProcessingException.ERR_GIVEN_IS_NULL);
            throw new SearchProcessingException(SearchProcessingException.ERR_GIVEN_IS_NULL);
        }
        LOGGER.info("Adding complete");
        return company.getId();
    }

    public int addEmployeeToDbReturnId(final Employee employee) throws SearchProcessingException {
        LOGGER.info("Adding new employee: " + employee.getFirstName());
        try {
            employeeDao.save(employee);
        } catch (IllegalArgumentException e) {
            LOGGER.error(SearchProcessingException.ERR_GIVEN_IS_NULL);
            throw new SearchProcessingException(SearchProcessingException.ERR_GIVEN_IS_NULL);
        }
        LOGGER.info("Adding complete");
        return employee.getId();
    }

    public void cleanUpCompanyById (int... ids) {
        for (int id : ids) {
            companyDao.deleteById(id);
        }
    }

    public void cleanUpEmployeeById (int... ids) {
        for (int id : ids) {
            employeeDao.deleteById(id);
        }
    }

    public List<Company> searchCharInCompanies(final String characters) throws SearchProcessingException {
        LOGGER.info("Executing search");
        if (characters == null || characters.equals("")) {
            LOGGER.error(SearchProcessingException.ERR_EMPTY_PARAM);
            throw new SearchProcessingException(SearchProcessingException.ERR_EMPTY_PARAM);
        }
        List<Company> resultList = companyDao.retrieveCompanyWithCharacters(characters);
        resultCheck(resultList);
        return resultList;
    }

    public List<Employee> searchNameInEmployees(final String name) throws SearchProcessingException {
        LOGGER.info("Executing search");
        if (name == null || name.equals("")) {
            LOGGER.error(SearchProcessingException.ERR_EMPTY_PARAM);
            throw new SearchProcessingException(SearchProcessingException.ERR_EMPTY_PARAM);
        }
        List<Employee> resultList = employeeDao.retrieveEmployeeWhoseNameIs(name);
        resultCheck(resultList);
        return resultList;
    }

    private void resultCheck(List<? extends ListType> resultList) throws SearchProcessingException {
        if (!(resultList.size() == 0)) {
            if (resultList.size() == 1) {
                LOGGER.info("Search complete with one result");
            } else {
                LOGGER.info("Search complete with " + resultList.size() + " results");
            }
        } else {
            LOGGER.error(SearchProcessingException.ERR_NOT_FOUND);
            throw new SearchProcessingException(SearchProcessingException.ERR_NOT_FOUND);
        }
    }
}
