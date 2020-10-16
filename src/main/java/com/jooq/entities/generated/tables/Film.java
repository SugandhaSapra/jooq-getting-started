/*
 * This file is generated by jOOQ.
 */
package com.jooq.entities.generated.tables;


import com.jooq.entities.generated.Indexes;
import com.jooq.entities.generated.Keys;
import com.jooq.entities.generated.Public;
import com.jooq.entities.generated.enums.MpaaRating;
import com.jooq.entities.generated.tables.records.FilmRecord;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row13;
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
public class Film extends TableImpl<FilmRecord> {

    private static final long serialVersionUID = -378837982;

    /**
     * The reference instance of <code>public.film</code>
     */
    public static final Film FILM = new Film();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FilmRecord> getRecordType() {
        return FilmRecord.class;
    }

    /**
     * The column <code>public.film.film_id</code>.
     */
    public final TableField<FilmRecord, Integer> FILM_ID = createField(DSL.name("film_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('film_film_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.film.title</code>.
     */
    public final TableField<FilmRecord, String> TITLE = createField(DSL.name("title"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>public.film.description</code>.
     */
    public final TableField<FilmRecord, String> DESCRIPTION = createField(DSL.name("description"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.film.release_year</code>.
     */
    public final TableField<FilmRecord, Integer> RELEASE_YEAR = createField(DSL.name("release_year"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.film.language_id</code>.
     */
    public final TableField<FilmRecord, Short> LANGUAGE_ID = createField(DSL.name("language_id"), org.jooq.impl.SQLDataType.SMALLINT.nullable(false), this, "");

    /**
     * The column <code>public.film.rental_duration</code>.
     */
    public final TableField<FilmRecord, Short> RENTAL_DURATION = createField(DSL.name("rental_duration"), org.jooq.impl.SQLDataType.SMALLINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("3", org.jooq.impl.SQLDataType.SMALLINT)), this, "");

    /**
     * The column <code>public.film.rental_rate</code>.
     */
    public final TableField<FilmRecord, BigDecimal> RENTAL_RATE = createField(DSL.name("rental_rate"), org.jooq.impl.SQLDataType.NUMERIC(4, 2).nullable(false).defaultValue(org.jooq.impl.DSL.field("4.99", org.jooq.impl.SQLDataType.NUMERIC)), this, "");

    /**
     * The column <code>public.film.length</code>.
     */
    public final TableField<FilmRecord, Short> LENGTH = createField(DSL.name("length"), org.jooq.impl.SQLDataType.SMALLINT, this, "");

    /**
     * The column <code>public.film.replacement_cost</code>.
     */
    public final TableField<FilmRecord, BigDecimal> REPLACEMENT_COST = createField(DSL.name("replacement_cost"), org.jooq.impl.SQLDataType.NUMERIC(5, 2).nullable(false).defaultValue(org.jooq.impl.DSL.field("19.99", org.jooq.impl.SQLDataType.NUMERIC)), this, "");

    /**
     * The column <code>public.film.rating</code>.
     */
    public final TableField<FilmRecord, MpaaRating> RATING = createField(DSL.name("rating"), org.jooq.impl.SQLDataType.VARCHAR.defaultValue(org.jooq.impl.DSL.field("'G'::mpaa_rating", org.jooq.impl.SQLDataType.VARCHAR)).asEnumDataType(com.jooq.entities.generated.enums.MpaaRating.class), this, "");

    /**
     * The column <code>public.film.last_update</code>.
     */
    public final TableField<FilmRecord, LocalDateTime> LAST_UPDATE = createField(DSL.name("last_update"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false).defaultValue(org.jooq.impl.DSL.field("now()", org.jooq.impl.SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.film.special_features</code>.
     */
    public final TableField<FilmRecord, String[]> SPECIAL_FEATURES = createField(DSL.name("special_features"), org.jooq.impl.SQLDataType.CLOB.getArrayDataType(), this, "");

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    public final TableField<FilmRecord, Object> FULLTEXT = createField(DSL.name("fulltext"), org.jooq.impl.DefaultDataType.getDefaultDataType("\"pg_catalog\".\"tsvector\"").nullable(false), this, "");

    /**
     * Create a <code>public.film</code> table reference
     */
    public Film() {
        this(DSL.name("film"), null);
    }

    /**
     * Create an aliased <code>public.film</code> table reference
     */
    public Film(String alias) {
        this(DSL.name(alias), FILM);
    }

    /**
     * Create an aliased <code>public.film</code> table reference
     */
    public Film(Name alias) {
        this(alias, FILM);
    }

    private Film(Name alias, Table<FilmRecord> aliased) {
        this(alias, aliased, null);
    }

    private Film(Name alias, Table<FilmRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Film(Table<O> child, ForeignKey<O, FilmRecord> key) {
        super(child, key, FILM);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.FILM_FULLTEXT_IDX, Indexes.IDX_FK_LANGUAGE_ID, Indexes.IDX_TITLE);
    }

    @Override
    public Identity<FilmRecord, Integer> getIdentity() {
        return Keys.IDENTITY_FILM;
    }

    @Override
    public UniqueKey<FilmRecord> getPrimaryKey() {
        return Keys.FILM_PKEY;
    }

    @Override
    public List<UniqueKey<FilmRecord>> getKeys() {
        return Arrays.<UniqueKey<FilmRecord>>asList(Keys.FILM_PKEY);
    }

    @Override
    public List<ForeignKey<FilmRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<FilmRecord, ?>>asList(Keys.FILM__FILM_LANGUAGE_ID_FKEY);
    }

    public Language language() {
        return new Language(this, Keys.FILM__FILM_LANGUAGE_ID_FKEY);
    }

    @Override
    public Film as(String alias) {
        return new Film(DSL.name(alias), this);
    }

    @Override
    public Film as(Name alias) {
        return new Film(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Film rename(String name) {
        return new Film(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Film rename(Name name) {
        return new Film(name, null);
    }

    // -------------------------------------------------------------------------
    // Row13 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row13<Integer, String, String, Integer, Short, Short, BigDecimal, Short, BigDecimal, MpaaRating, LocalDateTime, String[], Object> fieldsRow() {
        return (Row13) super.fieldsRow();
    }
}
