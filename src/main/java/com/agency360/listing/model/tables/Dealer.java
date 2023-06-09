/*
 * This file is generated by jOOQ.
 */
package com.agency360.listing.model.tables;


import com.agency360.listing.model.Keys;
import com.agency360.listing.model.Public;
import com.agency360.listing.model.tables.records.DealerRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
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
public class Dealer extends TableImpl<DealerRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.dealer</code>
     */
    public static final Dealer DEALER = new Dealer();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DealerRecord> getRecordType() {
        return DealerRecord.class;
    }

    /**
     * The column <code>public.dealer.id</code>.
     */
    public final TableField<DealerRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.dealer.name</code>.
     */
    public final TableField<DealerRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(158).nullable(false), this, "");

    private Dealer(Name alias, Table<DealerRecord> aliased) {
        this(alias, aliased, null);
    }

    private Dealer(Name alias, Table<DealerRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.dealer</code> table reference
     */
    public Dealer(String alias) {
        this(DSL.name(alias), DEALER);
    }

    /**
     * Create an aliased <code>public.dealer</code> table reference
     */
    public Dealer(Name alias) {
        this(alias, DEALER);
    }

    /**
     * Create a <code>public.dealer</code> table reference
     */
    public Dealer() {
        this(DSL.name("dealer"), null);
    }

    public <O extends Record> Dealer(Table<O> child, ForeignKey<O, DealerRecord> key) {
        super(child, key, DEALER);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<DealerRecord, Integer> getIdentity() {
        return (Identity<DealerRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<DealerRecord> getPrimaryKey() {
        return Keys.DEALER_PK;
    }

    @Override
    public Dealer as(String alias) {
        return new Dealer(DSL.name(alias), this);
    }

    @Override
    public Dealer as(Name alias) {
        return new Dealer(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Dealer rename(String name) {
        return new Dealer(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Dealer rename(Name name) {
        return new Dealer(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
