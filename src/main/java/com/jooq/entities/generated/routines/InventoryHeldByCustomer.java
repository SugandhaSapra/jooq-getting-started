/*
 * This file is generated by jOOQ.
 */
package com.jooq.entities.generated.routines;


import com.jooq.entities.generated.Public;

import org.jooq.Field;
import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;
import org.jooq.impl.Internal;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class InventoryHeldByCustomer extends AbstractRoutine<Integer> {

    private static final long serialVersionUID = -1247251699;

    /**
     * The parameter <code>public.inventory_held_by_customer.RETURN_VALUE</code>.
     */
    public static final Parameter<Integer> RETURN_VALUE = Internal.createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.INTEGER, false, false);

    /**
     * The parameter <code>public.inventory_held_by_customer.p_inventory_id</code>.
     */
    public static final Parameter<Integer> P_INVENTORY_ID = Internal.createParameter("p_inventory_id", org.jooq.impl.SQLDataType.INTEGER, false, false);

    /**
     * Create a new routine call instance
     */
    public InventoryHeldByCustomer() {
        super("inventory_held_by_customer", Public.PUBLIC, org.jooq.impl.SQLDataType.INTEGER);

        setReturnParameter(RETURN_VALUE);
        addInParameter(P_INVENTORY_ID);
    }

    /**
     * Set the <code>p_inventory_id</code> parameter IN value to the routine
     */
    public void setPInventoryId(Integer value) {
        setValue(P_INVENTORY_ID, value);
    }

    /**
     * Set the <code>p_inventory_id</code> parameter to the function to be used with a {@link org.jooq.Select} statement
     */
    public void setPInventoryId(Field<Integer> field) {
        setField(P_INVENTORY_ID, field);
    }
}
