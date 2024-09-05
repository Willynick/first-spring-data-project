package com.itclopedia.cources.first.spring.data.project.controller;

import com.itclopedia.cources.first.spring.data.project.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/houses")
@RequiredArgsConstructor
public class HouseController {

    private final HouseService houseService;

    @GetMapping
    public ResponseEntity<?> findByNumber(@RequestParam Integer number) {
        return new ResponseEntity<>(houseService.findByNumber(number), HttpStatus.OK);
    }

    @DeleteMapping("/{houseId}")
    public void delete(@PathVariable("houseId") Integer houseId) {
        houseService.delete(houseId);
    }

}
