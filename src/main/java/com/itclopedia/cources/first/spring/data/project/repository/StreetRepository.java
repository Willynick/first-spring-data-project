package com.itclopedia.cources.first.spring.data.project.repository;

import com.itclopedia.cources.first.spring.data.project.entity.Street;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetRepository extends CrudRepository<Street, Integer> {

    @Override
    List<Street> findAll();

    List<Street> findByName(String name);

}
