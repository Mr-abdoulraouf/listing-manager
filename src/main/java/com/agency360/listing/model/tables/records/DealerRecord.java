/*
 * This file is generated by jOOQ.
 */
package com.agency360.listing.model.tables.records;


import com.agency360.listing.model.tables.Dealer;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DealerRecord extends UpdatableRecordImpl<DealerRecord> implements Record2<Integer, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.dealer.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.dealer.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.dealer.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.dealer.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Integer, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Dealer.DEALER.ID;
    }

    @Override
    public Field<String> field2() {
        return Dealer.DEALER.NAME;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public DealerRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public DealerRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public DealerRecord values(Integer value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DealerRecord
     */
    public DealerRecord() {
        super(Dealer.DEALER);
    }

    /**
     * Create a detached, initialised DealerRecord
     */
    public DealerRecord(Integer id, String name) {
        super(Dealer.DEALER);

        setId(id);
        setName(name);
    }

    /**
     * Create a detached, initialised DealerRecord
     */
    public DealerRecord(com.agency360.listing.model.tables.pojos.Dealer value) {
        super(Dealer.DEALER);

        if (value != null) {
            setId(value.getId());
            setName(value.getName());
        }
    }
}
