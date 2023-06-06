/*
 * This file is generated by jOOQ.
 */
package com.agency360.listing.model.tables.daos;


import com.agency360.listing.model.tables.Listing;
import com.agency360.listing.model.tables.records.ListingRecord;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class ListingDao extends DAOImpl<ListingRecord, com.agency360.listing.model.tables.pojos.Listing, Integer> {

    /**
     * Create a new ListingDao without any configuration
     */
    public ListingDao() {
        super(Listing.LISTING, com.agency360.listing.model.tables.pojos.Listing.class);
    }

    /**
     * Create a new ListingDao with an attached configuration
     */
    @Autowired
    public ListingDao(Configuration configuration) {
        super(Listing.LISTING, com.agency360.listing.model.tables.pojos.Listing.class, configuration);
    }

    @Override
    public Integer getId(com.agency360.listing.model.tables.pojos.Listing object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.agency360.listing.model.tables.pojos.Listing> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Listing.LISTING.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.agency360.listing.model.tables.pojos.Listing> fetchById(Integer... values) {
        return fetch(Listing.LISTING.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.agency360.listing.model.tables.pojos.Listing fetchOneById(Integer value) {
        return fetchOne(Listing.LISTING.ID, value);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public Optional<com.agency360.listing.model.tables.pojos.Listing> fetchOptionalById(Integer value) {
        return fetchOptional(Listing.LISTING.ID, value);
    }

    /**
     * Fetch records that have <code>dealer_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.agency360.listing.model.tables.pojos.Listing> fetchRangeOfDealerId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Listing.LISTING.DEALER_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>dealer_id IN (values)</code>
     */
    public List<com.agency360.listing.model.tables.pojos.Listing> fetchByDealerId(Integer... values) {
        return fetch(Listing.LISTING.DEALER_ID, values);
    }

    /**
     * Fetch records that have <code>price BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.agency360.listing.model.tables.pojos.Listing> fetchRangeOfPrice(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Listing.LISTING.PRICE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>price IN (values)</code>
     */
    public List<com.agency360.listing.model.tables.pojos.Listing> fetchByPrice(Long... values) {
        return fetch(Listing.LISTING.PRICE, values);
    }

    /**
     * Fetch records that have <code>created_at BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.agency360.listing.model.tables.pojos.Listing> fetchRangeOfCreatedAt(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(Listing.LISTING.CREATED_AT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>created_at IN (values)</code>
     */
    public List<com.agency360.listing.model.tables.pojos.Listing> fetchByCreatedAt(LocalDateTime... values) {
        return fetch(Listing.LISTING.CREATED_AT, values);
    }

    /**
     * Fetch records that have <code>state BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.agency360.listing.model.tables.pojos.Listing> fetchRangeOfState(String lowerInclusive, String upperInclusive) {
        return fetchRange(Listing.LISTING.STATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>state IN (values)</code>
     */
    public List<com.agency360.listing.model.tables.pojos.Listing> fetchByState(String... values) {
        return fetch(Listing.LISTING.STATE, values);
    }
}
