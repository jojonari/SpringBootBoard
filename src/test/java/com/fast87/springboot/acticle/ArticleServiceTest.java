package com.fast87.springboot.acticle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ArticleServiceTest {
    @Autowired
    ArticleService articleService;

    @Test
    public void 게시물생성테스트() throws Exception {
        //given
        ArticleCreateRequest request = new ArticleCreateRequest(1L, "제목", "본문" ,"작가");
        //when
        Article article = articleService.createArticle(request);
        //then
        assertThat(article.getId(), is(1L));
        assertThat(article.getTitle(), is("제목"));
        assertThat(article.getBody(), is("본문"));
        assertThat(article.getAuthor(), is("작가"));
    }

    @Test
    public void 게시물조회테스트() throws Exception{
        //given
        ArticleCreateRequest request = new ArticleCreateRequest(1L, "제목", "본문" ,"작가");
        articleService.createArticle(request);
        //when
        Article article = articleService.getArticle(1L);
        assertThat(article.getId(), is(1L));
        assertThat(article.getTitle(), is("제목"));
        assertThat(article.getBody(), is("본문"));
        assertThat(article.getAuthor(), is("작가"));
        assertThat(article.getCreated(), is(org.hamcrest.CoreMatchers.notNullValue()));
    }

}