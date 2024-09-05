package com.itclopedia.cources.first.spring.data.project.repository;

import com.itclopedia.cources.first.spring.data.project.entity.House;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends CrudRepository<House, Integer> {

    @Query("SELECT h FROM House h WHERE h.number = :number AND h.area is null")
    House findByNumber(@Param("number") Integer number);

}
