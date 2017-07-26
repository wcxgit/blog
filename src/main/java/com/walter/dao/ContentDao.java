package com.walter.dao;

import com.walter.pojo.Content;
import com.walter.pojo.Type;
import org.apache.ibatis.annotations.Param;

/**
 * Created by walter on 2017/7/25.
 */
public interface ContentDao {

    //添加内容
    int addContent(Content content);
}
