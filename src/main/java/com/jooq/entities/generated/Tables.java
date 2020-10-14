/*
 * This file is generated by jOOQ.
 */
package com.jooq.entities.generated;


import com.jooq.entities.generated.tables.Actor;
import com.jooq.entities.generated.tables.ActorInfo;
import com.jooq.entities.generated.tables.Address;
import com.jooq.entities.generated.tables.Category;
import com.jooq.entities.generated.tables.City;
import com.jooq.entities.generated.tables.Country;
import com.jooq.entities.generated.tables.Customer;
import com.jooq.entities.generated.tables.CustomerList;
import com.jooq.entities.generated.tables.Film;
import com.jooq.entities.generated.tables.FilmActor;
import com.jooq.entities.generated.tables.FilmCategory;
import com.jooq.entities.generated.tables.FilmInStock;
import com.jooq.entities.generated.tables.FilmList;
import com.jooq.entities.generated.tables.FilmNotInStock;
import com.jooq.entities.generated.tables.Inventory;
import com.jooq.entities.generated.tables.Language;
import com.jooq.entities.generated.tables.NicerButSlowerFilmList;
import com.jooq.entities.generated.tables.Payment;
import com.jooq.entities.generated.tables.Rental;
import com.jooq.entities.generated.tables.RewardsReport;
import com.jooq.entities.generated.tables.SalesByFilmCategory;
import com.jooq.entities.generated.tables.SalesByStore;
import com.jooq.entities.generated.tables.Staff;
import com.jooq.entities.generated.tables.StaffList;
import com.jooq.entities.generated.tables.Store;
import com.jooq.entities.generated.tables.records.FilmInStockRecord;
import com.jooq.entities.generated.tables.records.FilmNotInStockRecord;
import com.jooq.entities.generated.tables.records.RewardsReportRecord;

import java.math.BigDecimal;

import org.jooq.Configuration;
import org.jooq.Field;
import org.jooq.Result;


/**
 * Convenience access to all tables in public
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.actor</code>.
     */
    public static final Actor ACTOR = Actor.ACTOR;

    /**
     * The table <code>public.actor_info</code>.
     */
    public static final ActorInfo ACTOR_INFO = ActorInfo.ACTOR_INFO;

    /**
     * The table <code>public.address</code>.
     */
    public static final Address ADDRESS = Address.ADDRESS;

    /**
     * The table <code>public.category</code>.
     */
    public static final Category CATEGORY = Category.CATEGORY;

    /**
     * The table <code>public.city</code>.
     */
    public static final City CITY = City.CITY;

    /**
     * The table <code>public.country</code>.
     */
    public static final Country COUNTRY = Country.COUNTRY;

    /**
     * The table <code>public.customer</code>.
     */
    public static final Customer CUSTOMER = Customer.CUSTOMER;

    /**
     * The table <code>public.customer_list</code>.
     */
    public static final CustomerList CUSTOMER_LIST = CustomerList.CUSTOMER_LIST;

    /**
     * The table <code>public.film</code>.
     */
    public static final Film FILM = Film.FILM;

    /**
     * The table <code>public.film_actor</code>.
     */
    public static final FilmActor FILM_ACTOR = FilmActor.FILM_ACTOR;

    /**
     * The table <code>public.film_category</code>.
     */
    public static final FilmCategory FILM_CATEGORY = FilmCategory.FILM_CATEGORY;

    /**
     * The table <code>public.film_in_stock</code>.
     */
    public static final FilmInStock FILM_IN_STOCK = FilmInStock.FILM_IN_STOCK;

    /**
     * Call <code>public.film_in_stock</code>.
     */
    public static Result<FilmInStockRecord> FILM_IN_STOCK(Configuration configuration, Integer pFilmId, Integer pStoreId) {
        return configuration.dsl().selectFrom(com.jooq.entities.generated.tables.FilmInStock.FILM_IN_STOCK.call(pFilmId, pStoreId)).fetch();
    }

    /**
     * Get <code>public.film_in_stock</code> as a table.
     */
    public static FilmInStock FILM_IN_STOCK(Integer pFilmId, Integer pStoreId) {
        return com.jooq.entities.generated.tables.FilmInStock.FILM_IN_STOCK.call(pFilmId, pStoreId);
    }

    /**
     * Get <code>public.film_in_stock</code> as a table.
     */
    public static FilmInStock FILM_IN_STOCK(Field<Integer> pFilmId, Field<Integer> pStoreId) {
        return com.jooq.entities.generated.tables.FilmInStock.FILM_IN_STOCK.call(pFilmId, pStoreId);
    }

    /**
     * The table <code>public.film_list</code>.
     */
    public static final FilmList FILM_LIST = FilmList.FILM_LIST;

    /**
     * The table <code>public.film_not_in_stock</code>.
     */
    public static final FilmNotInStock FILM_NOT_IN_STOCK = FilmNotInStock.FILM_NOT_IN_STOCK;

    /**
     * Call <code>public.film_not_in_stock</code>.
     */
    public static Result<FilmNotInStockRecord> FILM_NOT_IN_STOCK(Configuration configuration, Integer pFilmId, Integer pStoreId) {
        return configuration.dsl().selectFrom(com.jooq.entities.generated.tables.FilmNotInStock.FILM_NOT_IN_STOCK.call(pFilmId, pStoreId)).fetch();
    }

    /**
     * Get <code>public.film_not_in_stock</code> as a table.
     */
    public static FilmNotInStock FILM_NOT_IN_STOCK(Integer pFilmId, Integer pStoreId) {
        return com.jooq.entities.generated.tables.FilmNotInStock.FILM_NOT_IN_STOCK.call(pFilmId, pStoreId);
    }

    /**
     * Get <code>public.film_not_in_stock</code> as a table.
     */
    public static FilmNotInStock FILM_NOT_IN_STOCK(Field<Integer> pFilmId, Field<Integer> pStoreId) {
        return com.jooq.entities.generated.tables.FilmNotInStock.FILM_NOT_IN_STOCK.call(pFilmId, pStoreId);
    }

    /**
     * The table <code>public.inventory</code>.
     */
    public static final Inventory INVENTORY = Inventory.INVENTORY;

    /**
     * The table <code>public.language</code>.
     */
    public static final Language LANGUAGE = Language.LANGUAGE;

    /**
     * The table <code>public.nicer_but_slower_film_list</code>.
     */
    public static final NicerButSlowerFilmList NICER_BUT_SLOWER_FILM_LIST = NicerButSlowerFilmList.NICER_BUT_SLOWER_FILM_LIST;

    /**
     * The table <code>public.payment</code>.
     */
    public static final Payment PAYMENT = Payment.PAYMENT;

    /**
     * The table <code>public.rental</code>.
     */
    public static final Rental RENTAL = Rental.RENTAL;

    /**
     * The table <code>public.rewards_report</code>.
     */
    public static final RewardsReport REWARDS_REPORT = RewardsReport.REWARDS_REPORT;

    /**
     * Call <code>public.rewards_report</code>.
     */
    public static Result<RewardsReportRecord> REWARDS_REPORT(Configuration configuration, Integer minMonthlyPurchases, BigDecimal minDollarAmountPurchased) {
        return configuration.dsl().selectFrom(com.jooq.entities.generated.tables.RewardsReport.REWARDS_REPORT.call(minMonthlyPurchases, minDollarAmountPurchased)).fetch();
    }

    /**
     * Get <code>public.rewards_report</code> as a table.
     */
    public static RewardsReport REWARDS_REPORT(Integer minMonthlyPurchases, BigDecimal minDollarAmountPurchased) {
        return com.jooq.entities.generated.tables.RewardsReport.REWARDS_REPORT.call(minMonthlyPurchases, minDollarAmountPurchased);
    }

    /**
     * Get <code>public.rewards_report</code> as a table.
     */
    public static RewardsReport REWARDS_REPORT(Field<Integer> minMonthlyPurchases, Field<BigDecimal> minDollarAmountPurchased) {
        return com.jooq.entities.generated.tables.RewardsReport.REWARDS_REPORT.call(minMonthlyPurchases, minDollarAmountPurchased);
    }

    /**
     * The table <code>public.sales_by_film_category</code>.
     */
    public static final SalesByFilmCategory SALES_BY_FILM_CATEGORY = SalesByFilmCategory.SALES_BY_FILM_CATEGORY;

    /**
     * The table <code>public.sales_by_store</code>.
     */
    public static final SalesByStore SALES_BY_STORE = SalesByStore.SALES_BY_STORE;

    /**
     * The table <code>public.staff</code>.
     */
    public static final Staff STAFF = Staff.STAFF;

    /**
     * The table <code>public.staff_list</code>.
     */
    public static final StaffList STAFF_LIST = StaffList.STAFF_LIST;

    /**
     * The table <code>public.store</code>.
     */
    public static final Store STORE = Store.STORE;
}
