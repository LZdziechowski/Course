package com.hibernate.manytomany.dao;

import com.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    @Query
    List<Employee> retrieveEmployeeWhoseLastNameIs(@Param("LASTNAME") String lastName);

    @Query
    List<Employee> retrieveEmployeeWhoseNameIs(@Param("NAME") String name);
}
