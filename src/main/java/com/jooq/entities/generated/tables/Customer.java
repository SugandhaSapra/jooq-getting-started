/*
 * This file is generated by jOOQ.
 */
package com.jooq.entities.generated.tables;


import com.jooq.entities.generated.Indexes;
import com.jooq.entities.generated.Keys;
import com.jooq.entities.generated.Public;
import com.jooq.entities.generated.tables.records.CustomerRecord;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row10;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Customer extends TableImpl<CustomerRecord> {

    private static final long serialVersionUID = 890669409;

    /**
     * The reference instance of <code>public.customer</code>
     */
    public static final Customer CUSTOMER = new Customer();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CustomerRecord> getRecordType() {
        return CustomerRecord.class;
    }

    /**
     * The column <code>public.customer.customer_id</code>.
     */
    public final TableField<CustomerRecord, Integer> CUSTOMER_ID = createField(DSL.name("customer_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('customer_customer_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.customer.store_id</code>.
     */
    public final TableField<CustomerRecord, Short> STORE_ID = createField(DSL.name("store_id"), org.jooq.impl.SQLDataType.SMALLINT.nullable(false), this, "");

    /**
     * The column <code>public.customer.first_name</code>.
     */
    public final TableField<CustomerRecord, String> FIRST_NAME = createField(DSL.name("first_name"), org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * The column <code>public.customer.last_name</code>.
     */
    public final TableField<CustomerRecord, String> LAST_NAME = createField(DSL.name("last_name"), org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * The column <code>public.customer.email</code>.
     */
    public final TableField<CustomerRecord, String> EMAIL = createField(DSL.name("email"), org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.customer.address_id</code>.
     */
    public final TableField<CustomerRecord, Short> ADDRESS_ID = createField(DSL.name("address_id"), org.jooq.impl.SQLDataType.SMALLINT.nullable(false), this, "");

    /**
     * The column <code>public.customer.activebool</code>.
     */
    public final TableField<CustomerRecord, Boolean> ACTIVEBOOL = createField(DSL.name("activebool"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("true", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>public.customer.create_date</code>.
     */
    public final TableField<CustomerRecord, LocalDate> CREATE_DATE = createField(DSL.name("create_date"), org.jooq.impl.SQLDataType.LOCALDATE.nullable(false).defaultValue(org.jooq.impl.DSL.field("('now'::text)::date", org.jooq.impl.SQLDataType.LOCALDATE)), this, "");

    /**
     * The column <code>public.customer.last_update</code>.
     */
    public final TableField<CustomerRecord, LocalDateTime> LAST_UPDATE = createField(DSL.name("last_update"), org.jooq.impl.SQLDataType.LOCALDATETIME.defaultValue(org.jooq.impl.DSL.field("now()", org.jooq.impl.SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.customer.active</code>.
     */
    public final TableField<CustomerRecord, Integer> ACTIVE = createField(DSL.name("active"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>public.customer</code> table reference
     */
    public Customer() {
        this(DSL.name("customer"), null);
    }

    /**
     * Create an aliased <code>public.customer</code> table reference
     */
    public Customer(String alias) {
        this(DSL.name(alias), CUSTOMER);
    }

    /**
     * Create an aliased <code>public.customer</code> table reference
     */
    public Customer(Name alias) {
        this(alias, CUSTOMER);
    }

    private Customer(Name alias, Table<CustomerRecord> aliased) {
        this(alias, aliased, null);
    }

    private Customer(Name alias, Table<CustomerRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Customer(Table<O> child, ForeignKey<O, CustomerRecord> key) {
        super(child, key, CUSTOMER);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.IDX_FK_ADDRESS_ID, Indexes.IDX_FK_STORE_ID, Indexes.IDX_LAST_NAME);
    }

    @Override
    public Identity<CustomerRecord, Integer> getIdentity() {
        return Keys.IDENTITY_CUSTOMER;
    }

    @Override
    public UniqueKey<CustomerRecord> getPrimaryKey() {
        return Keys.CUSTOMER_PKEY;
    }

    @Override
    public List<UniqueKey<CustomerRecord>> getKeys() {
        return Arrays.<UniqueKey<CustomerRecord>>asList(Keys.CUSTOMER_PKEY);
    }

    @Override
    public List<ForeignKey<CustomerRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<CustomerRecord, ?>>asList(Keys.CUSTOMER__CUSTOMER_ADDRESS_ID_FKEY);
    }

    public Address address() {
        return new Address(this, Keys.CUSTOMER__CUSTOMER_ADDRESS_ID_FKEY);
    }

    @Override
    public Customer as(String alias) {
        return new Customer(DSL.name(alias), this);
    }

    @Override
    public Customer as(Name alias) {
        return new Customer(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Customer rename(String name) {
        return new Customer(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Customer rename(Name name) {
        return new Customer(name, null);
    }

    // -------------------------------------------------------------------------
    // Row10 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row10<Integer, Short, String, String, String, Short, Boolean, LocalDate, LocalDateTime, Integer> fieldsRow() {
        return (Row10) super.fieldsRow();
    }
}
