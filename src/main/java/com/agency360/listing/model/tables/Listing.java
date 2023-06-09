/*
 * This file is generated by jOOQ.
 */
package com.agency360.listing.model.tables;


import com.agency360.listing.model.Keys;
import com.agency360.listing.model.Public;
import com.agency360.listing.model.tables.records.ListingRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Listing extends TableImpl<ListingRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.listing</code>
     */
    public static final Listing LISTING = new Listing();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ListingRecord> getRecordType() {
        return ListingRecord.class;
    }

    /**
     * The column <code>public.listing.id</code>.
     */
    public final TableField<ListingRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.listing.dealer_id</code>.
     */
    public final TableField<ListingRecord, Integer> DEALER_ID = createField(DSL.name("dealer_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.listing.vehicule</code>.
     */
    public final TableField<ListingRecord, String> VEHICULE = createField(DSL.name("vehicule"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>public.listing.price</code>.
     */
    public final TableField<ListingRecord, Long> PRICE = createField(DSL.name("price"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.listing.created_at</code>.
     */
    public final TableField<ListingRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.listing.state</code>.
     */
    public final TableField<ListingRecord, String> STATE = createField(DSL.name("state"), SQLDataType.VARCHAR(158).nullable(false), this, "");

    private Listing(Name alias, Table<ListingRecord> aliased) {
        this(alias, aliased, null);
    }

    private Listing(Name alias, Table<ListingRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.listing</code> table reference
     */
    public Listing(String alias) {
        this(DSL.name(alias), LISTING);
    }

    /**
     * Create an aliased <code>public.listing</code> table reference
     */
    public Listing(Name alias) {
        this(alias, LISTING);
    }

    /**
     * Create a <code>public.listing</code> table reference
     */
    public Listing() {
        this(DSL.name("listing"), null);
    }

    public <O extends Record> Listing(Table<O> child, ForeignKey<O, ListingRecord> key) {
        super(child, key, LISTING);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<ListingRecord, Integer> getIdentity() {
        return (Identity<ListingRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<ListingRecord> getPrimaryKey() {
        return Keys.LISTING_PK;
    }

    @Override
    public List<ForeignKey<ListingRecord, ?>> getReferences() {
        return Arrays.asList(Keys.LISTING__LISTING_FK);
    }

    private transient Dealer _dealer;

    /**
     * Get the implicit join path to the <code>public.dealer</code> table.
     */
    public Dealer dealer() {
        if (_dealer == null)
            _dealer = new Dealer(this, Keys.LISTING__LISTING_FK);

        return _dealer;
    }

    @Override
    public Listing as(String alias) {
        return new Listing(DSL.name(alias), this);
    }

    @Override
    public Listing as(Name alias) {
        return new Listing(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Listing rename(String name) {
        return new Listing(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Listing rename(Name name) {
        return new Listing(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, Integer, String, Long, LocalDateTime, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}
