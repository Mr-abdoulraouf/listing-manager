package com.agency360.listing.controller;

import com.agency360.listing.dto.ListingDto;
import com.agency360.listing.exception.ResourceNotFoundException;
import com.agency360.listing.model.tables.pojos.Listing;
import com.agency360.listing.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/listing")
public class ListingController {


    private final ListingService listingService;

    @GetMapping("/{dealerId}/{state}")
    public ResponseEntity<Set<Listing>> getListingsByCriteria(@PathVariable(value = "dealerId") Integer dealerId,@PathVariable(value = "state") String state) {
        Set<Listing> listings = listingService.getListingByDealerIdAndState(dealerId, state);
        return listings.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HashSet<>()) : ResponseEntity.ok(listings);
    }
    @PostMapping("/save")
    public ResponseEntity<ListingDto> createListing(@Valid @RequestBody ListingDto listingDto) throws ResourceNotFoundException {
        listingService.create(listingDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(listingDto);
    }

    @PutMapping("/update/{listingId}")
    public ResponseEntity<ListingDto> updateListing(@PathVariable(value = "listingId") Integer listingId, @Valid @RequestBody ListingDto listingDto) throws ResourceNotFoundException {
        ListingDto listing = listingService.update(listingId, listingDto);
        return ResponseEntity.ok(listing);
    }

    @PutMapping("/publish/{listingId}")
    public ResponseEntity<Listing> publishListing(@PathVariable(value = "listingId") Integer listingId) throws ResourceNotFoundException {
        Listing listing = listingService.publishListing(listingId);
        return ResponseEntity.ok(listing);
    }
    @PutMapping("/unpublish/{listingId}")
    public ResponseEntity<Listing> unpublishListing(@PathVariable(value = "listingId") Integer listingId) throws ResourceNotFoundException {
        Listing listing = listingService.unpublishListing(listingId);
        return ResponseEntity.ok(listing);
    }
}
