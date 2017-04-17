package com.fast87.springboot.acticle;

import com.fast87.springboot.acticle.util.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository repository;

    public Article createArticle(ArticleCreateRequest request){
        Article article = new Article(request.getId(), request.getTitle(), request.getBody(), request.getAuthor(), OffsetDateTime.now());
        repository.add(article);
        return article;
    }

    public Article getArticle(Long id){
        return repository.get(id);
    }

    public List<Article> getArticles(Paging paging){

        return repository.getList(paging);
    }

    public int getArticleCount() {
        return repository.getArticleCount();
    }
}
