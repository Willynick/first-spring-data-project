package com.itclopedia.cources.first.spring.data.project.service;

import com.itclopedia.cources.first.spring.data.project.entity.Street;

import java.util.List;

public interface StreetService {

    List<Street> getAllStreets();

    List<Street> findByName(String name);

    void createStreet(Street street);

    void updateStreet(Integer streetId, Street street);

}
