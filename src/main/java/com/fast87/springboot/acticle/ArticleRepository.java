package com.fast87.springboot.acticle;

import com.fast87.springboot.acticle.util.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


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
           article.setAuthor(rs.getString("AUTHOR"));
           article.setBody(rs.getString("BODY"));
           article.setCreated(OffsetDateTime.now());
           return article;
       });
   }

    public List<Article> getList(Paging paging){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM ARTICLE LIMIT ?, ?", new Object[]{paging.getStartRow(), paging.getPageSize()});
        List<Article> articles = new ArrayList();

        for (Map row : rows){
            Article article = new Article();
            article.setId(Long.parseLong(row.get("ID").toString()));
            article.setTitle(row.get("TITLE").toString());
            article.setAuthor(row.get("AUTHOR").toString());
            article.setBody(row.get("BODY").toString());
            article.setCreated(OffsetDateTime.now());

            articles.add(article);
        }

        return articles;

    }

    public int getArticleCount(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int cnt = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM ARTICLE", new Object[]{}, Integer.class);
        return cnt;
    }
}
