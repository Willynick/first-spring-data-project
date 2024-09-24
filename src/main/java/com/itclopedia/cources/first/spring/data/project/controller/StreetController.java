package com.itclopedia.cources.first.spring.data.project.controller;

import com.itclopedia.cources.first.spring.data.project.entity.Street;
import com.itclopedia.cources.first.spring.data.project.service.StreetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/streets")
@RequiredArgsConstructor
public class StreetController {

    private final StreetService streetService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllStreets() {
        return new ResponseEntity<>(streetService.getAllStreets(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> findStreetByName(@RequestParam String name) {
        return new ResponseEntity<>(streetService.findByName(name), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> createStreet(@RequestBody Street street) {
        streetService.createStreet(street);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{streetId}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<?> updateStreet(@PathVariable("streetId") Integer streetId, @RequestBody Street street) {
        streetService.updateStreet(streetId, street);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
