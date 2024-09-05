package com.itclopedia.cources.first.spring.data.project.service;

import com.itclopedia.cources.first.spring.data.project.entity.Street;
import com.itclopedia.cources.first.spring.data.project.exception.EntityNotFoundException;
import com.itclopedia.cources.first.spring.data.project.repository.StreetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StreetServiceImpl implements StreetService {

    private final StreetRepository streetRepository;

    @Override
    public List<Street> getAllStreets() {
        return streetRepository.findAll();
    }

    @Override
    public List<Street> findByName(String name) {
        return streetRepository.findByName(name);
    }

    @Override
    public void createStreet(Street street) {
        streetRepository.save(street);
    }

    @Override
    public void updateStreet(Integer streetId, Street street) {
        if (!streetRepository.existsById(streetId)) {
            throw new EntityNotFoundException("Street", streetId);
        }

        street.setId(streetId);
        streetRepository.save(street);
    }

}
