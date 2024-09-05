package com.itclopedia.cources.first.spring.data.project.service;

import com.itclopedia.cources.first.spring.data.project.entity.House;
import com.itclopedia.cources.first.spring.data.project.exception.EntityNotFoundException;
import com.itclopedia.cources.first.spring.data.project.repository.HouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HouseServiceImpl implements HouseService {

    public final HouseRepository houseRepository;

    @Override
    public House findByNumber(Integer number) {
        return houseRepository.findByNumber(number);
    }

    @Override
    public void delete(Integer houseId) {
        if (!houseRepository.existsById(houseId)) {
            throw new EntityNotFoundException("House", houseId);
        }

        houseRepository.deleteById(houseId);
    }

}
