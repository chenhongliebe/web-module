/**
 * 
 * **
 * 
 * Comment.java
 * 
 */
package com.frico.website.model.articleManagement;

import java.util.Date;

/**
 * <p>
 * 表 : comment的 Model 类
 * 
 * @author 	chh
 * @date 	2018年03月26日
 */
public class Comment {
    /** 字段:id，评论的主键id */
    private Integer id;

    /** 字段:content，评论的内容 */
    private String content;

    /** 字段:article_id，评论对应的文章id */
    private Integer articleId;

    /** 字段:create_id，评论人对应的id */
    private Integer createId;

    /** 字段:update_id，更新评论人对应的id */
    private Integer updateId;

    /** 字段:create_date，发表评论的时间 */
    private Date createDate;

    /** 字段:update_date，更新评论的时间 */
    private Date updateDate;

    /** 字段:is_delete，是否删除评论  1  是  2 否 */
    private String isDelete;

    /** 字段:comment_id，评论的id */
    private Integer commentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
}