package com.jooq.entities;

import com.jooq.type.ArticleStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;
import java.util.UUID;


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
    @Transient
    private String slug;
    private String title;
    private String description;
    @Column(length = 100000)
    private String body;
    @ElementCollection
    private List<String> tags;
    @Column(updatable = false, nullable = false)
    private Date createdAt;
    private Date updatedAt;
    private boolean favorited;
    private long favoritesCount;
    @OneToMany(mappedBy = "article")
    private List<Comment> comments;

    private String image;

    @Enumerated(EnumType.STRING)
    private ArticleStatus status;
}
