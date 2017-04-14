package com.fast87.springboot.acticle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.OffsetDateTime;
import java.util.Date;


@Repository
public class ArticleRepository {
   @Autowired
    DataSource dataSource;

   public void add (Article article){
       JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
       jdbcTemplate.update("INSERT INTO ARTICLE (ID, TITLE, BODY, AUTHOR, CREATED) VALUES (?,?,?,?,?)",
               new Object[]{article.getId(), article.getTitle(), article.getBody(), article.getAuthor(), new Date(article.getCreated().toEpochSecond())//기준일자(epoch) 1970년1월1일을 기준으로 만들어진초
               });
   }

   public Article get(Long id){
       JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
       String sql ="SELECT * FROM ARTICLE WHERE ID = ?";
       return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, i) -> {
           Article article = new Article();
           article.setId(rs.getLong("ID"));
           article.setTitle(rs.getString("TITLE"));
           article.setAuther(rs.getString("AUTHOR"));
           article.setBody(rs.getString("BODY"));
           article.setCreated(OffsetDateTime.now());
           return article;
       });
   }
}
