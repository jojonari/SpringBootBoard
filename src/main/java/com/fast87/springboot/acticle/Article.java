package com.fast87.springboot.acticle;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class Article {

    private Long id;
    private String title;
    private String body;
    private String author;
    private OffsetDateTime created;

    public Article() {}

    public Article(Long id, String title, String body, String author, OffsetDateTime created) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
        this.created = created;
    }
}
