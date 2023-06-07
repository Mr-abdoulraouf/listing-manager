package com.agency360.listing.controller;

import com.agency360.listing.dto.ListingDto;
import com.agency360.listing.exception.ResourceNotFoundException;
import com.agency360.listing.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/listing")
public class ListingController {


    private final ListingService listingService;
    @PostMapping("/save")
    public ResponseEntity<ListingDto> createListing(@Valid @RequestBody ListingDto listingDto) throws ResourceNotFoundException {
        listingService.create(listingDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(listingDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ListingDto> updateListing(@PathVariable(value = "id") Integer listingId, @Valid @RequestBody ListingDto listingDto) throws ResourceNotFoundException {
        ListingDto listing = listingService.update(listingId, listingDto);
        return ResponseEntity.ok(listing);
    }
}
