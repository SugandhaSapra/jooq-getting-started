package com.jooq.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@SqlResultSetMapping(name = "ArticleTitle",
        classes = @ConstructorResult(
                targetClass = ArticleTitle.class,
                columns = {
                        @ColumnResult(name = "title")
                }))


@Entity
@Table(name = "articles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String description;
    @Column(length = 100000)
    private String body;
    @OneToMany(mappedBy = "article")
    private List<Comment> comments;
}
