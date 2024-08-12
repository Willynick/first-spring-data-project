package com.itclopedia.cources.first.spring.data.project.service;

import com.itclopedia.cources.first.spring.data.project.entity.Street;

import java.util.List;

public interface StreetService {

    List<Street> getAllStreets(boolean isJdbcTemplate);

    List<Street> findByName(String name);

}
