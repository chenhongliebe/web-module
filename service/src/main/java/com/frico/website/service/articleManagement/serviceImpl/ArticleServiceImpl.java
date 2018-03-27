package com.frico.website.service.articleManagement.serviceImpl;


import com.frico.website.common.exception.MyException;
import com.frico.website.dao.articleManagement.ArticleMapperExt;
import com.frico.website.model.articleManagement.Article;
import com.frico.website.service.articleManagement.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: Administrator
 * Date: 2018/3/21
 * Time: 16:14
 * Java gives me life and I have to work hard.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapperExt articleMapperExt;

    @Override
    public void insert(Article article){
        article.preInsert();
        articleMapperExt.insertSelective(article);
    }

    @Override
    public void delete(Integer[] ids) {
        if(ids !=null && ids.length >1){
            for(Integer id :ids){
                articleMapperExt.deleteByPrimaryKey(id);
            }
        }else {
            throw new MyException("11","删除失败，主键不能为空");
        }
    }

    @Override
    public void update(Article article) {
        articleMapperExt.updateByPrimaryKeySelective(article);
    }

    @Override
    public List<Article> findList(Article article) {

        return articleMapperExt.findList(article);
    }

    @Override
    public Article get(Integer id) {
        return articleMapperExt.selectByPrimaryKey(id);
    }


}
