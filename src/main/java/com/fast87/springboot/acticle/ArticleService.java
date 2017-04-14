package com.fast87.springboot.acticle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jojonari on 2017. 4. 14..
 */
@Service
public class ArticleService {
    @Autowired
    ArticleRepository repository;

    public Article createArticle(ArticleCreateRequest request){
        Article article = new Article(request.getId(), request.getTitle(), request.getBody(), request.getAuthor());
        repository.add(article);
        return article;
    }

    public Article getArticle(Long id){
        return repository.get(id);
    }
}
