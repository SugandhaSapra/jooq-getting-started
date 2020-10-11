package com.jooq;

import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.sources.tables.records.BookRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

import static com.jooq.config.DataSourceConfig.createDataSource;
import static org.jooq.sources.tables.Book.BOOK;

@Slf4j
@SpringBootApplication
public class JooqGettingStartedApplication {

    public static void main(String[] args) {
        DataSource dataSource = createDataSource();
        SpringApplication.run(JooqGettingStartedApplication.class, args);
        DSLContext dslContext = DSL.using(dataSource, SQLDialect.POSTGRES);
        BookRecord bookRecord = dslContext
                .selectFrom(BOOK)
                .where(BOOK.ID.eq(1))
                .fetchAny();

        log.info("Book Record {}", bookRecord);
        dslContext
                .insertInto(BOOK)
                .set(BOOK.ID, 2)
                .set(BOOK.TITLE, "Docker")
                .onConflict()
                .doUpdate()
                .set(BOOK.AUTHOR, "Sugandha")
                .execute();

        log.info("SQL {}", dslContext
                .insertInto(BOOK)
                .set(BOOK.ID, 2)
                .set(BOOK.TITLE, "Docker")
                .onConflict()
                .doUpdate()
                .set(BOOK.AUTHOR, "Sugandha")
                .getSQL());

    }

}
