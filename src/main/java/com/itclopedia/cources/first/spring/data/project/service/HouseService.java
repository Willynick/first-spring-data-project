package com.itclopedia.cources.first.spring.data.project.service;

import com.itclopedia.cources.first.spring.data.project.entity.House;

import java.util.List;

public interface HouseService {

    House findByNumber(Integer number);

    House findByNumberNativeSQL(Integer number);

}
