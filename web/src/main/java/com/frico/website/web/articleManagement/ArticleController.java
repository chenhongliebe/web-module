package com.frico.website.web.articleManagement;

import com.frico.website.common.Enum.DeleteEnum;
import com.frico.website.common.Result;
import com.frico.website.model.articleManagement.Article;
import com.frico.website.service.articleManagement.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 文章的控制层
 * User: Administrator
 * Date: 2018/3/22
 * Time: 14:12
 * Java gives me life and I have to work hard.
 */

@RestController
@RequestMapping("bc/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 发布文章
     * @param article
     * @return
     */
    @RequestMapping("insert")
    public Result insert(@RequestBody Article article){
        articleService.insert(article);
        return Result.success();
    }

    /**
     * 根据id查询文章
     * @return
     */
    @RequestMapping("get")
    public Result get(@RequestBody Article article) {
        if(article !=null){
            article = articleService.get(article.getId());
        }
        return Result.success(article);
    }

    /**
     * 根据条件（类型）查询文章
     * @param article
     * @return
     */
    @RequestMapping("findList")
    public Result<List<Article>> findList(@RequestBody Article article){
        List<Article> list = articleService.findList(article);
        return Result.success(list);
    }

    /**
     * 加入回收站
     * @param ids
     * @return
     */
    @RequestMapping("delete")
    public Result delete(@RequestBody Integer[] ids){
        if(ids !=null && ids.length >1){
            for(Integer id :ids){
                Article article = new Article();
                article.setId(id);
                article.setIsDelete(DeleteEnum.DELETED.getCode());
                articleService.update(article);
            }
            return Result.success();
        }
        return Result.ret("11","主键不能为空");
    }

    /**
     * 回收站还原
     * @param ids
     * @return
     */
    @RequestMapping("restore")
    public Result restore(@RequestBody Integer[] ids){
        if(ids !=null && ids.length >1){
            for(Integer id :ids){
                Article article = new Article();
                article.setId(id);
                article.setIsDelete(DeleteEnum.NOT_DELETE.getCode());
                articleService.update(article);
            }
            return Result.success();
        }
        return Result.ret("11","主键不能为空");
    }

    /**
     * 永久删除
     * @param ids
     * @return
     */
    @RequestMapping("permanentdelete")
    public Result permanentDelete(@RequestBody Integer[] ids){
        articleService.delete(ids);
        return Result.success();
    }

    @RequestMapping("update")
    public Result update(@RequestBody Article article){
        articleService.update(article);
        return Result.success();
    }


}
