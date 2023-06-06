package com.agency360.listing.service;

import com.agency360.listing.model.tables.daos.DealerDao;
import com.agency360.listing.model.tables.daos.ListingDao;
import com.agency360.listing.model.tables.daos.TierLimitDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ListingserviceImp implements ListingService{

    private final ListingDao listingDao;
    private final DealerDao dealerDao;
    private final TierLimitDao tierLimitDao;

}
