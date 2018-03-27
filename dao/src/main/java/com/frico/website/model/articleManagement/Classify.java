/**
 * 
 * **
 * 
 * Classify.java
 * 
 */
package com.frico.website.model.articleManagement;

import java.util.Date;

/**
 * <p>
 * 表 : classify的 Model 类
 * 
 * @author 	chh
 * @date 	2018年03月26日
 */
public class Classify {
    /** 字段:id，主键 */
    private Integer id;

    /** 字段:type，类别 */
    private String type;

    /** 字段:create_id，创建者 */
    private Integer createId;

    /** 字段:create_date，创建时间 */
    private Date createDate;

    /** 字段:update_id，更新者 */
    private Integer updateId;

    /** 字段:update_date，更新时间 */
    private Date updateDate;

    /** 字段:is_delete，是否删除 */
    private String isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
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
}