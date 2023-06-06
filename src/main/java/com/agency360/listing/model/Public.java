/*
 * This file is generated by jOOQ.
 */
package com.agency360.listing.model;


import com.agency360.listing.model.tables.Dealer;
import com.agency360.listing.model.tables.Listing;
import com.agency360.listing.model.tables.TierLimit;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.dealer</code>.
     */
    public final Dealer DEALER = Dealer.DEALER;

    /**
     * The table <code>public.listing</code>.
     */
    public final Listing LISTING = Listing.LISTING;

    /**
     * The table <code>public.tier_limit</code>.
     */
    public final TierLimit TIER_LIMIT = TierLimit.TIER_LIMIT;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Sequence<?>> getSequences() {
        return Arrays.asList(
            Sequences.DEALER_ID_SEQ,
            Sequences.LISTING_ID_SEQ,
            Sequences.TIER_LIMIT_ID_SEQ
        );
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            Dealer.DEALER,
            Listing.LISTING,
            TierLimit.TIER_LIMIT
        );
    }
}
