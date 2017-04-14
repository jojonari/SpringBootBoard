package com.fast87.springboot.acticle;

import java.time.OffsetDateTime;

/**
 * Created by jojonari on 2017. 4. 14..
 */
public class Article {

    private Long id;
    private String title;
    private String body;
    private String author;
    private OffsetDateTime created;

    public Article() {}

    public Article(Long id, String title, String body, String author) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
        //OffsetDateTime : TIMESTAMP WITH TIMEZONE
        //OffeSetDateTime은 data를 직렬화 하여 DB에 넣거나 만약 서버가 다른 시간대를 사용한다면 직렬화된 형태로 logging time stamp를 표현하는데 사용할 수 있다.
        this.created = OffsetDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuther(String author) {
        this.author = author;
    }

    public OffsetDateTime getCreated() {
        return created;
    }

    public void setCreated(OffsetDateTime created) {
        this.created = created;
    }
}
