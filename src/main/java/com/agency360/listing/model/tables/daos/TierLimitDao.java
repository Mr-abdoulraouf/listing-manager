/*
 * This file is generated by jOOQ.
 */
package com.agency360.listing.model.tables.daos;


import com.agency360.listing.model.tables.TierLimit;
import com.agency360.listing.model.tables.records.TierLimitRecord;

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
public class TierLimitDao extends DAOImpl<TierLimitRecord, com.agency360.listing.model.tables.pojos.TierLimit, Integer> {

    /**
     * Create a new TierLimitDao without any configuration
     */
    public TierLimitDao() {
        super(TierLimit.TIER_LIMIT, com.agency360.listing.model.tables.pojos.TierLimit.class);
    }

    /**
     * Create a new TierLimitDao with an attached configuration
     */
    @Autowired
    public TierLimitDao(Configuration configuration) {
        super(TierLimit.TIER_LIMIT, com.agency360.listing.model.tables.pojos.TierLimit.class, configuration);
    }

    @Override
    public Integer getId(com.agency360.listing.model.tables.pojos.TierLimit object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.agency360.listing.model.tables.pojos.TierLimit> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(TierLimit.TIER_LIMIT.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.agency360.listing.model.tables.pojos.TierLimit> fetchById(Integer... values) {
        return fetch(TierLimit.TIER_LIMIT.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.agency360.listing.model.tables.pojos.TierLimit fetchOneById(Integer value) {
        return fetchOne(TierLimit.TIER_LIMIT.ID, value);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public Optional<com.agency360.listing.model.tables.pojos.TierLimit> fetchOptionalById(Integer value) {
        return fetchOptional(TierLimit.TIER_LIMIT.ID, value);
    }

    /**
     * Fetch records that have <code>dealer_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.agency360.listing.model.tables.pojos.TierLimit> fetchRangeOfDealerId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(TierLimit.TIER_LIMIT.DEALER_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>dealer_id IN (values)</code>
     */
    public List<com.agency360.listing.model.tables.pojos.TierLimit> fetchByDealerId(Integer... values) {
        return fetch(TierLimit.TIER_LIMIT.DEALER_ID, values);
    }

    /**
     * Fetch records that have <code>listing_limit BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.agency360.listing.model.tables.pojos.TierLimit> fetchRangeOfListingLimit(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(TierLimit.TIER_LIMIT.LISTING_LIMIT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>listing_limit IN (values)</code>
     */
    public List<com.agency360.listing.model.tables.pojos.TierLimit> fetchByListingLimit(Integer... values) {
        return fetch(TierLimit.TIER_LIMIT.LISTING_LIMIT, values);
    }

    /**
     * Fetch records that have <code>who_done BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.agency360.listing.model.tables.pojos.TierLimit> fetchRangeOfWhoDone(String lowerInclusive, String upperInclusive) {
        return fetchRange(TierLimit.TIER_LIMIT.WHO_DONE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>who_done IN (values)</code>
     */
    public List<com.agency360.listing.model.tables.pojos.TierLimit> fetchByWhoDone(String... values) {
        return fetch(TierLimit.TIER_LIMIT.WHO_DONE, values);
    }

    /**
     * Fetch records that have <code>when_done BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.agency360.listing.model.tables.pojos.TierLimit> fetchRangeOfWhenDone(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(TierLimit.TIER_LIMIT.WHEN_DONE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>when_done IN (values)</code>
     */
    public List<com.agency360.listing.model.tables.pojos.TierLimit> fetchByWhenDone(LocalDateTime... values) {
        return fetch(TierLimit.TIER_LIMIT.WHEN_DONE, values);
    }
}
