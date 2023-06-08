/*
 * This file is generated by jOOQ.
 */
package com.agency360.listing.model;


import com.agency360.listing.model.tables.Dealer;
import com.agency360.listing.model.tables.Listing;
import com.agency360.listing.model.tables.TierLimit;
import com.agency360.listing.model.tables.records.DealerRecord;
import com.agency360.listing.model.tables.records.ListingRecord;
import com.agency360.listing.model.tables.records.TierLimitRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<DealerRecord> DEALER_PK = Internal.createUniqueKey(Dealer.DEALER, DSL.name("dealer_pk"), new TableField[] { Dealer.DEALER.ID }, true);
    public static final UniqueKey<ListingRecord> LISTING_PK = Internal.createUniqueKey(Listing.LISTING, DSL.name("listing_pk"), new TableField[] { Listing.LISTING.ID }, true);
    public static final UniqueKey<TierLimitRecord> TIER_LIMIT_PK = Internal.createUniqueKey(TierLimit.TIER_LIMIT, DSL.name("tier_limit_pk"), new TableField[] { TierLimit.TIER_LIMIT.DEALER_ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<ListingRecord, DealerRecord> LISTING__LISTING_FK = Internal.createForeignKey(Listing.LISTING, DSL.name("listing_fk"), new TableField[] { Listing.LISTING.DEALER_ID }, Keys.DEALER_PK, new TableField[] { Dealer.DEALER.ID }, true);
    public static final ForeignKey<TierLimitRecord, DealerRecord> TIER_LIMIT__TIER_LIMIT_FK = Internal.createForeignKey(TierLimit.TIER_LIMIT, DSL.name("tier_limit_fk"), new TableField[] { TierLimit.TIER_LIMIT.DEALER_ID }, Keys.DEALER_PK, new TableField[] { Dealer.DEALER.ID }, true);
}
