package com.agency360.listing.service;



import com.agency360.listing.dto.ListingDto;
import com.agency360.listing.exception.ResourceNotFoundException;
import com.agency360.listing.model.tables.daos.DealerDao;
import com.agency360.listing.model.tables.daos.ListingDao;
import com.agency360.listing.model.tables.daos.TierLimitDao;
import com.agency360.listing.model.tables.pojos.Listing;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();
    Logger logger = LoggerFactory.getLogger(ListingserviceImp.class);
    @Override
    public void create(ListingDto listingDto) {
      listingDto.setState("draft");
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
        return null;
    }

    @Override
    public void publishListing(Integer id) {

    }

    @Override
    public void unpublishListing(Integer id) {

    }
}
