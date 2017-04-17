package com.fast87.springboot.acticle;

import com.fast87.springboot.acticle.util.Paging;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Controller
public class ArticleController {
    @Autowired ArticleService service;

    @PostConstruct
    public void setDummyArticle(){
        for (long i = 0; i < 100; i++) {
            service.createArticle(new ArticleCreateRequest(i, "제목_con"+i,"내용_con"+i,"작가_con"+i));
        }

    }

    @GetMapping(value = "/article/{articleId}")
    public String getArticle(Model model, @PathVariable Long articleId){
        Article article = service.getArticle(articleId);
        model.addAttribute("article", article);
        return "article";
    }

    @RequestMapping(value = "article/create")
    public String createArticleView(){
        return "createArticle";
    }

    @PostMapping
    public String createArticle(@ModelAttribute ArticleCreateRequest request){
        service.createArticle(request);
        return "redirect:/article/" + request.getId();
    }


    @GetMapping(value = "/articles/{page}")
    public String getArticleList(Model model, @PathVariable int page){
        Paging paging = new Paging();
        paging.setPageNo(page);
        paging.setPageSize(10);
        paging.setTotalCount(service.getArticleCount());

        List<Article> articles = service.getArticles(paging);
        model.addAttribute("articles", articles);
        model.addAttribute("paging", paging);
        return "articles";
    }

}
