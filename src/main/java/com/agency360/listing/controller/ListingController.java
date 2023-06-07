package com.agency360.listing.controller;

import com.agency360.listing.dto.ListingDto;
import com.agency360.listing.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/listing")
public class ListingController {


    private final ListingService listingService;
    @PostMapping("/save")
    public ResponseEntity<ListingDto> createListing(@Valid @RequestBody ListingDto listingDto) {
        listingService.create(listingDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(listingDto);
    }
}
