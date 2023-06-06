package com.agency360.listing.service;


import com.agency360.listing.model.tables.pojos.Listing;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface ListingService {


    void create (Listing listing);
    void update(Listing listing);
    Set<Listing> getListingByDealerIdAndState(Integer dealerId, String state);

    void publishListing(Integer id);

    void unpublishListing(Integer id);
}
