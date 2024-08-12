package com.itclopedia.cources.first.spring.data.project.service;

import com.itclopedia.cources.first.spring.data.project.entity.Street;
import com.itclopedia.cources.first.spring.data.project.repository.StreetDao;
import com.itclopedia.cources.first.spring.data.project.repository.StreetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StreetServiceImpl implements StreetService {

    private final StreetRepository streetRepository;

    private final StreetDao streetDao;

    @Override
    public List<Street> getAllStreets(boolean isJdbcTemplate) {
        return isJdbcTemplate ? streetDao.getAllStreets() : streetRepository.findAll();
    }

    @Override
    public List<Street> findByName(String name) {
        return streetRepository.findByName(name);
    }
}
