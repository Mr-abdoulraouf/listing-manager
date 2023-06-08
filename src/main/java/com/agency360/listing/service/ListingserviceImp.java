package com.agency360.listing.service;



import com.agency360.listing.dto.ListingDto;
import com.agency360.listing.exception.ResourceNotFoundException;
import com.agency360.listing.model.tables.daos.DealerDao;
import com.agency360.listing.model.tables.daos.ListingDao;
import com.agency360.listing.model.tables.daos.TierLimitDao;
import com.agency360.listing.model.tables.pojos.Listing;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.agency360.listing.model.tables.Listing.LISTING;

@RequiredArgsConstructor
@Service
public class ListingserviceImp implements ListingService{

    public static final String DRAFT = "draft";
    public static final String PUBLISHED = "published";
    private final ListingDao listingDao;
    private final TierLimitDao tierLimitDao;
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    private final DSLContext dsl;
    Logger logger = LoggerFactory.getLogger(ListingserviceImp.class);
    @Override
    public void create(ListingDto listingDto) {
      listingDto.setState(DRAFT);
      listingDao.insert(MODEL_MAPPER.map(listingDto,Listing.class));
    }

    @Override
    public ListingDto update(Integer id,ListingDto listingDto) {
        Listing existingListing = listingDao.fetchOptionalById(id).orElseThrow(() -> new ResourceNotFoundException("Ad not found with id: " + id));
        existingListing.setId(listingDto.getId());
        existingListing.setDealerId(listingDto.getDealerId());
        existingListing.setVehicule(listingDto.getVehicule());
        existingListing.setPrice(listingDto.getPrice());
        listingDao.update(existingListing);
        return listingDto;
    }

    @Override
    public Set<Listing> getListingByDealerIdAndState(Integer dealerId, String state) {
        List<Listing> listings = dsl.selectFrom(LISTING).where(LISTING.DEALER_ID.eq(dealerId).and(LISTING.STATE.eq(state))).fetchInto(Listing.class);
        return new HashSet<>(listings);
    }

    @Override
    public Listing publishListing(Integer id) {
        Listing listing = listingDao.fetchOptionalById(id).orElseThrow(() -> new ResourceNotFoundException("Ad not found with id: " + id));
        if(dealerCannotPublishListing(listing.getDealerId()))
            throw new ResourceNotFoundException("Ad posting limit reached of dealer: " + listing.getDealerId());
        listing.setState(PUBLISHED);
        listingDao.update(listing);
        return  listing;
    }

    @Override
    public Listing unpublishListing(Integer id) {
        Listing listing = listingDao.fetchOptionalById(id).orElseThrow(() -> new ResourceNotFoundException("Ad not found with id: " + id));
        listing.setState(DRAFT);
        listingDao.update(listing);
        return  listing;
    }


    private boolean dealerCannotPublishListing(Integer dealerId){

        if(tierLimitDao.fetchByDealerId(dealerId).isEmpty())
            return true;

        int dealerPublishingLimit = tierLimitDao.fetchOneByDealerId(dealerId).getListingLimit();

        return getListingByDealerIdAndState(dealerId,PUBLISHED).size() >= dealerPublishingLimit;


    }
}
