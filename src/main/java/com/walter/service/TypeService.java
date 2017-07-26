package com.walter.service;

import com.walter.pojo.Type;

/**
 * Created by walter on 2017/7/25.
 */
public interface TypeService {

    Type getByUnameAndTypeName(int uId, String cContent);

    int addType(int uId, String tName);
}
