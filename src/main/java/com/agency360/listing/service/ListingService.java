package com.agency360.listing.service;


import com.agency360.listing.dto.ListingDto;
import com.agency360.listing.model.tables.pojos.Listing;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface ListingService {


    void create (ListingDto listingDto);
    ListingDto update(Integer id, ListingDto listingDto);
    Set<Listing> getListingByDealerIdAndState(Integer dealerId, String state);

    Listing publishListing(Integer id);

    Listing unpublishListing(Integer id);
}
