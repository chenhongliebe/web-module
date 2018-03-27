/**
 * 
 * **
 * 
 * ArticleMapperExt.java
 * 
 */
package com.frico.website.dao.articleManagement;

import com.frico.website.model.articleManagement.Article;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * ArticleMapper的扩展 Mapper 接口
 * 
 * @author 	chh
 * @date 	2018年03月26日
 */
@Resource
public interface ArticleMapperExt extends ArticleMapper {

    public List<Article> findList(Article article);

}