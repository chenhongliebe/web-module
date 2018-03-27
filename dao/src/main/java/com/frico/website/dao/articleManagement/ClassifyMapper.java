/**
 * 
 * **
 * 
 * ClassifyMapper.java
 * 
 */
package com.frico.website.dao.articleManagement;

import com.frico.website.model.articleManagement.Classify;

/**
 * <p>
 * 表 : classify的 Mapper 类
 * 
 * @author 	chh
 * @date 	2018年03月26日
 */
public interface ClassifyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Classify record);

    int insertSelective(Classify record);

    Classify selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Classify record);

    int updateByPrimaryKey(Classify record);
}