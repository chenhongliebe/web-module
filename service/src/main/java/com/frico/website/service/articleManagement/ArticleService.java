package com.frico.website.service.articleManagement;

import com.frico.website.model.articleManagement.Article;

import java.util.List;

/**
 * 文章的接口
 * xrb
 */

public interface ArticleService {

    public void insert(Article article);

    public void delete(Integer[] ids);

    public void update(Article article);

    public List<Article> findList(Article article);
    //通过文章主键查询文章
    public Article get(Integer id);


}
