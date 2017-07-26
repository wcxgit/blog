package com.walter.dao;

import com.walter.pojo.Type;
import org.apache.ibatis.annotations.Param;

/**
 * Created by walter on 2017/7/25.
 */
public interface TypeDao {
    //根据用户和分类名称查询该用户是否有该分类
    Type getByUnameAndTypeName(@Param("uId") int uId, @Param("tName") String tName);

    int addType(@Param("uId") int uId, @Param("tName") String tName);
}
