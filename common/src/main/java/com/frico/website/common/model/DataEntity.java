package com.frico.website.common.model;

import com.frico.website.common.Enum.DeleteEnum;
import com.frico.website.common.UserUtil;
import com.frico.website.common.exception.MyException;

import java.io.Serializable;
import java.util.Date;

public abstract class DataEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    //主键id
    private Integer id;

    /** 字段:create_id，创建人 */
    private Integer createId;

    /** 字段:create_date，创建时间 */
    private Date createDate;

    /** 字段:update_id，修改人 */
    private Integer updateId;

    /** 字段:update_date，修改时间 */
    private Date updateDate;

    /** 字段:id_delete，是否删除 */
    protected String isDelete;

    public DataEntity() {
        this.isDelete = DeleteEnum.NOT_DELETE.getCode();
    }

    /**
     * 插入之前执行方法，需要手动调用
     */
    public void preInsert(){
        LoginInfo loginInfo = UserUtil.getLoginInfo();
        if (loginInfo.getId() !=null){
            this.updateId = loginInfo.getId();
            this.createId = loginInfo.getId();
        }else {
            throw new MyException("用户id为空");
        }
        this.updateDate = new Date();
        this.createDate = this.updateDate;
    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    public void preUpdate(){
        LoginInfo loginInfo = UserUtil.getLoginInfo();
        if (loginInfo.getId() !=null){
            this.updateId = loginInfo.getId();
        }
        this.updateDate = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        this.isDelete = isDelete;
    }
}
