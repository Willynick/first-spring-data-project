package com.itclopedia.cources.first.spring.data.project.service;

import com.itclopedia.cources.first.spring.data.project.entity.House;
import com.itclopedia.cources.first.spring.data.project.repository.HouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HouseServiceImpl implements HouseService {

    public final HouseRepository houseRepository;

    @Override
    public House findByNumber(Integer number) {
        return houseRepository.findByNumber(number);
    }

    @Override
    public House findByNumberNativeSQL(Integer number) {
        return houseRepository.findByNumberNativeSQL(number);
    }
}
