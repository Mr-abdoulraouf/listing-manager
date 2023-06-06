/*
 * This file is generated by jOOQ.
 */
package com.agency360.listing.model;


import org.jooq.Sequence;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;


/**
 * Convenience access to all sequences in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>public.dealer_id_seq</code>
     */
    public static final Sequence<Integer> DEALER_ID_SEQ = Internal.createSequence("dealer_id_seq", Public.PUBLIC, SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.listing_id_seq</code>
     */
    public static final Sequence<Integer> LISTING_ID_SEQ = Internal.createSequence("listing_id_seq", Public.PUBLIC, SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.tier_limit_id_seq</code>
     */
    public static final Sequence<Integer> TIER_LIMIT_ID_SEQ = Internal.createSequence("tier_limit_id_seq", Public.PUBLIC, SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);
}
