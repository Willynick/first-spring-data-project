package com.itclopedia.cources.first.spring.data.project.controller;

import com.itclopedia.cources.first.spring.data.project.entity.House;
import com.itclopedia.cources.first.spring.data.project.entity.Street;
import com.itclopedia.cources.first.spring.data.project.service.HouseService;
import com.itclopedia.cources.first.spring.data.project.service.StreetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final StreetService streetService;

    public final HouseService houseService;

    public List<Street> getAllStreets(boolean isJdbcTemplate) {
        return streetService.getAllStreets(isJdbcTemplate);
    }

    public List<Street> findStreetByName(String name) {
        return streetService.findByName(name);
    }

    public House findByNumber(Integer number) {
        return houseService.findByNumber(number);
    }

    public House findByNumberNativeSQL(Integer number) {
        return houseService.findByNumberNativeSQL(number);
    }

}
