/**
 * 
 * **
 * 
 * CommentMapper.java
 * 
 */
package com.frico.website.dao.articleManagement;

import com.frico.website.model.articleManagement.Comment;

/**
 * <p>
 * 表 : comment的 Mapper 类
 * 
 * @author 	chh
 * @date 	2018年03月26日
 */
public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}