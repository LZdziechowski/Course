package com.hibernate.manytomany.dao;

import com.hibernate.manytomany.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {

    @Query
    List<Company> retrieveCompanyWithFirstChar(@Param("CHARACTERS") String characters);

    @Query
    List<Company> retrieveCompanyWithCharacters(@Param("CHARACTERS") String characters);
}
