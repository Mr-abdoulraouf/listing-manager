/*
 * This file is generated by jOOQ.
 */
package com.agency360.listing.model.tables.records;


import com.agency360.listing.model.tables.Listing;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ListingRecord extends UpdatableRecordImpl<ListingRecord> implements Record5<Integer, Integer, Long, LocalDateTime, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.listing.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.listing.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.listing.dealer_id</code>.
     */
    public void setDealerId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.listing.dealer_id</code>.
     */
    public Integer getDealerId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>public.listing.price</code>.
     */
    public void setPrice(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.listing.price</code>.
     */
    public Long getPrice() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.listing.created_at</code>.
     */
    public void setCreatedAt(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.listing.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>public.listing.state</code>.
     */
    public void setState(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.listing.state</code>.
     */
    public String getState() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, Integer, Long, LocalDateTime, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Integer, Integer, Long, LocalDateTime, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Listing.LISTING.ID;
    }

    @Override
    public Field<Integer> field2() {
        return Listing.LISTING.DEALER_ID;
    }

    @Override
    public Field<Long> field3() {
        return Listing.LISTING.PRICE;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return Listing.LISTING.CREATED_AT;
    }

    @Override
    public Field<String> field5() {
        return Listing.LISTING.STATE;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public Integer component2() {
        return getDealerId();
    }

    @Override
    public Long component3() {
        return getPrice();
    }

    @Override
    public LocalDateTime component4() {
        return getCreatedAt();
    }

    @Override
    public String component5() {
        return getState();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public Integer value2() {
        return getDealerId();
    }

    @Override
    public Long value3() {
        return getPrice();
    }

    @Override
    public LocalDateTime value4() {
        return getCreatedAt();
    }

    @Override
    public String value5() {
        return getState();
    }

    @Override
    public ListingRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public ListingRecord value2(Integer value) {
        setDealerId(value);
        return this;
    }

    @Override
    public ListingRecord value3(Long value) {
        setPrice(value);
        return this;
    }

    @Override
    public ListingRecord value4(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public ListingRecord value5(String value) {
        setState(value);
        return this;
    }

    @Override
    public ListingRecord values(Integer value1, Integer value2, Long value3, LocalDateTime value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ListingRecord
     */
    public ListingRecord() {
        super(Listing.LISTING);
    }

    /**
     * Create a detached, initialised ListingRecord
     */
    public ListingRecord(Integer id, Integer dealerId, Long price, LocalDateTime createdAt, String state) {
        super(Listing.LISTING);

        setId(id);
        setDealerId(dealerId);
        setPrice(price);
        setCreatedAt(createdAt);
        setState(state);
    }

    /**
     * Create a detached, initialised ListingRecord
     */
    public ListingRecord(com.agency360.listing.model.tables.pojos.Listing value) {
        super(Listing.LISTING);

        if (value != null) {
            setId(value.getId());
            setDealerId(value.getDealerId());
            setPrice(value.getPrice());
            setCreatedAt(value.getCreatedAt());
            setState(value.getState());
        }
    }
}