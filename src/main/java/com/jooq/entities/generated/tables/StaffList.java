/*
 * This file is generated by jOOQ.
 */
package com.jooq.entities.generated.tables;


import com.jooq.entities.generated.Public;
import com.jooq.entities.generated.tables.records.StaffListRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row8;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class StaffList extends TableImpl<StaffListRecord> {

    private static final long serialVersionUID = 1381671089;

    /**
     * The reference instance of <code>public.staff_list</code>
     */
    public static final StaffList STAFF_LIST = new StaffList();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StaffListRecord> getRecordType() {
        return StaffListRecord.class;
    }

    /**
     * The column <code>public.staff_list.id</code>.
     */
    public final TableField<StaffListRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.staff_list.name</code>.
     */
    public final TableField<StaffListRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.staff_list.address</code>.
     */
    public final TableField<StaffListRecord, String> ADDRESS = createField(DSL.name("address"), org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.staff_list.zip code</code>.
     */
    public final TableField<StaffListRecord, String> ZIP_CODE = createField(DSL.name("zip code"), org.jooq.impl.SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>public.staff_list.phone</code>.
     */
    public final TableField<StaffListRecord, String> PHONE = createField(DSL.name("phone"), org.jooq.impl.SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>public.staff_list.city</code>.
     */
    public final TableField<StaffListRecord, String> CITY = createField(DSL.name("city"), org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.staff_list.country</code>.
     */
    public final TableField<StaffListRecord, String> COUNTRY = createField(DSL.name("country"), org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.staff_list.sid</code>.
     */
    public final TableField<StaffListRecord, Short> SID = createField(DSL.name("sid"), org.jooq.impl.SQLDataType.SMALLINT, this, "");

    /**
     * Create a <code>public.staff_list</code> table reference
     */
    public StaffList() {
        this(DSL.name("staff_list"), null);
    }

    /**
     * Create an aliased <code>public.staff_list</code> table reference
     */
    public StaffList(String alias) {
        this(DSL.name(alias), STAFF_LIST);
    }

    /**
     * Create an aliased <code>public.staff_list</code> table reference
     */
    public StaffList(Name alias) {
        this(alias, STAFF_LIST);
    }

    private StaffList(Name alias, Table<StaffListRecord> aliased) {
        this(alias, aliased, null);
    }

    private StaffList(Name alias, Table<StaffListRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.view("create view \"staff_list\" as  SELECT s.staff_id AS id,\n    (((s.first_name)::text || ' '::text) || (s.last_name)::text) AS name,\n    a.address,\n    a.postal_code AS \"zip code\",\n    a.phone,\n    city.city,\n    country.country,\n    s.store_id AS sid\n   FROM (((staff s\n     JOIN address a ON ((s.address_id = a.address_id)))\n     JOIN city ON ((a.city_id = city.city_id)))\n     JOIN country ON ((city.country_id = country.country_id)));"));
    }

    public <O extends Record> StaffList(Table<O> child, ForeignKey<O, StaffListRecord> key) {
        super(child, key, STAFF_LIST);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public StaffList as(String alias) {
        return new StaffList(DSL.name(alias), this);
    }

    @Override
    public StaffList as(Name alias) {
        return new StaffList(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public StaffList rename(String name) {
        return new StaffList(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public StaffList rename(Name name) {
        return new StaffList(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<Integer, String, String, String, String, String, String, Short> fieldsRow() {
        return (Row8) super.fieldsRow();
    }
}
