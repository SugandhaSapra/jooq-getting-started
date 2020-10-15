package com.jooq.service;

import com.jooq.entities.Article;
import com.jooq.entities.ArticleTitle;
import com.jooq.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.SelectConditionStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

import static com.jooq.entities.generated.tables.Articles.ARTICLES;
import static com.jooq.entities.generated.tables.Comments.COMMENTS;

@Service
@RequiredArgsConstructor
@Slf4j
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final DSLContext dslContext;

    @Autowired
    private PersistenceService persistenceService;

    @Transactional
    public void saveArticle(Article article) {
        articleRepository.save(article);
    }

    @Transactional
    public List<ArticleTitle> searchArticleByTitleWithComments(String title) {
        SelectConditionStep<Record1<String>> jooqQuery = dslContext
                .select(ARTICLES.TITLE)
                .from(ARTICLES)
                .leftJoin(COMMENTS).on(ARTICLES.ID.eq(COMMENTS.ARTICLE_ID))
                .where(ARTICLES.TITLE.like("%" + title + "%"))
                .and(COMMENTS.BODY.isNotNull());
        EntityManager entityManager = persistenceService.getEntityManager();
        Query q = entityManager.createNativeQuery(jooqQuery.getSQL(), "ArticleTitle");
        setBindParameterValues(q, jooqQuery);
        List<ArticleTitle> resultList = q.getResultList();
        for (ArticleTitle s : resultList) {
            log.info("Title {}", s.getTitle());
        }
        EntityTransaction transaction = entityManager.getTransaction();
        if (transaction.isActive())
            transaction.commit();
        entityManager.close();
        return resultList;
    }

    private static void setBindParameterValues(Query hibernateQuery, org.jooq.Query jooqQuery) {
        List<Object> values = jooqQuery.getBindValues();
        for (int i = 0; i < values.size(); i++) {
            hibernateQuery.setParameter(i + 1, values.get(i));
        }
    }
}
