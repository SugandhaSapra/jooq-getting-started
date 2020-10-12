/*
 * This file is generated by jOOQ.
*/
package com.jooq.entities.generated;


import com.jooq.entities.generated.tables.Articles;
import com.jooq.entities.generated.tables.Comments;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling indexes of tables of the <code>PUBLIC</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index PRIMARY_KEY_E = Indexes0.PRIMARY_KEY_E;
    public static final Index FKHN0QNGXOF9TAR5R3A4XKLFSXG_INDEX_A = Indexes0.FKHN0QNGXOF9TAR5R3A4XKLFSXG_INDEX_A;
    public static final Index PRIMARY_KEY_A = Indexes0.PRIMARY_KEY_A;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 extends AbstractKeys {
        public static Index PRIMARY_KEY_E = createIndex("PRIMARY_KEY_E", Articles.ARTICLES, new OrderField[] { Articles.ARTICLES.ID }, true);
        public static Index FKHN0QNGXOF9TAR5R3A4XKLFSXG_INDEX_A = createIndex("FKHN0QNGXOF9TAR5R3A4XKLFSXG_INDEX_A", Comments.COMMENTS, new OrderField[] { Comments.COMMENTS.ARTICLE_ID }, false);
        public static Index PRIMARY_KEY_A = createIndex("PRIMARY_KEY_A", Comments.COMMENTS, new OrderField[] { Comments.COMMENTS.ID }, true);
    }
}