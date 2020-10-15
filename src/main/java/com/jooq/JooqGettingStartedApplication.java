package com.jooq;

import com.jooq.entities.generated.tables.records.ActorRecord;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.util.stream.Collectors;

import static com.jooq.config.DataSourceConfig.createDataSource;
import static com.jooq.entities.generated.Tables.ACTOR;
import static com.jooq.entities.generated.Tables.CUSTOMER;
import static com.jooq.entities.generated.Tables.FILM;
import static com.jooq.entities.generated.Tables.FILM_ACTOR;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static org.jooq.impl.DSL.count;
import static org.jooq.impl.DSL.row;
import static org.jooq.impl.DSL.select;

@Slf4j
@SpringBootApplication
public class JooqGettingStartedApplication {

    public static void main(String[] args) {
        String lineSeparator = System.getProperty("line.separator");
        DataSource dataSource = createDataSource();
        SpringApplication.run(JooqGettingStartedApplication.class, args);
        DSLContext dslContext = DSL.using(dataSource, SQLDialect.POSTGRES);

//        Fetch an actor by id
        ActorRecord actorRecord = dslContext
                .selectFrom(ACTOR)
                .where(ACTOR.ACTOR_ID.eq(1))
                .fetchAny();
        log.info("Actor Record {}.{}", lineSeparator, actorRecord);

//        Select Actors making join from film actors
        Result<Record3<String, String, Integer>> filmActors = dslContext.select(ACTOR.FIRST_NAME, ACTOR.LAST_NAME, count())
                .from(ACTOR)
                .join(FILM_ACTOR).on(ACTOR.ACTOR_ID.eq(FILM_ACTOR.ACTOR_ID.cast(Integer.class)))
                .groupBy(ACTOR.FIRST_NAME, ACTOR.LAST_NAME)
//                .fetchOne()
                .fetch();

        log.info("Film Actors {}.{}", lineSeparator, filmActors);

//      Select Customers who are actors
        Result<Record2<String, String>> actors = dslContext.select(CUSTOMER.FIRST_NAME, CUSTOMER.LAST_NAME)
                .from(CUSTOMER)
                .where(
                        row(CUSTOMER.FIRST_NAME, CUSTOMER.LAST_NAME)
                                .in(select(ACTOR.FIRST_NAME, ACTOR.LAST_NAME)
                                        .from(ACTOR))
                )
                .fetch();

        log.info("Actors {}.{}", lineSeparator, actors);

//        Actors with the list of their films
        dslContext.select(ACTOR.FIRST_NAME, ACTOR.LAST_NAME, FILM.TITLE)
                .from(ACTOR)
                .join(FILM_ACTOR).on(ACTOR.ACTOR_ID.eq(FILM_ACTOR.ACTOR_ID.cast(Integer.class)))
                .join(FILM).on(FILM_ACTOR.FILM_ID.cast(Integer.class).eq(FILM.FILM_ID))
                .stream()
                .collect(groupingBy(r -> r.getValue(ACTOR.FIRST_NAME)
                                + " " +
                                r.getValue(ACTOR.LAST_NAME),
                        mapping(r -> r.getValue(FILM.TITLE), Collectors.toList())))
                .forEach((k, v) -> log.info("{} -> {}", k, v));


    }

}
