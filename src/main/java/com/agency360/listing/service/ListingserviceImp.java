package com.agency360.listing.service;



import com.agency360.listing.model.tables.daos.DealerDao;
import com.agency360.listing.model.tables.daos.ListingDao;
import com.agency360.listing.model.tables.daos.TierLimitDao;
import com.agency360.listing.model.tables.pojos.Listing;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class ListingserviceImp implements ListingService{

    private final ListingDao listingDao;

    Logger logger = LoggerFactory.getLogger(ListingserviceImp.class);
    @Override
    public void create(Listing listing) {


    }

    @Override
    public void update(Listing listing) {

    }

    @Override
    public Set<Listing> getListingByDealerIdAndState(Integer dealerId, String state) {
        return null;
    }

    @Override
    public void publishListing(Integer id) {

    }

    @Override
    public void unpublishListing(Integer id) {

    }
}
