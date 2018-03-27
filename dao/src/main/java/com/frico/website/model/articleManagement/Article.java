/**
 * 
 * **
 * 
 * Article.java
 * 
 */
package com.frico.website.model.articleManagement;

import com.frico.website.common.Enum.DeleteEnum;
import com.frico.website.common.model.DataEntity;

import java.util.Date;

/**
 * <p>
 * 表 : article的 Model 类
 * 
 * @author 	chh
 * @date 	2018年03月26日
 */
public class Article extends DataEntity<Article> {

    private static final long serialVersionUID = 1L;

    /** 字段:title，发表文章的标题 */
    private String title;

    /** 字段:status，文章的状态 1已发布 2保存草稿箱 */
    private String status;

    /** 字段:type，文章的分类1 外汇 2 期货 3 股票 4 基金 */
    private String type;

    /** 字段:author，文章的作者 */
    private String author;

    /** 字段:cover_url，封面图地址 */
    private String coverUrl;

    /** 字段:content，发表的文章内容 */
    private String content;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl == null ? null : coverUrl.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}