package com.walter.service.impl;

import com.walter.common.ServerResponse;
import com.walter.dao.TypeDao;
import com.walter.pojo.Type;
import com.walter.service.TypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by walter on 2017/7/25.
 */
@Service("typeService")
public class TypeServiceImpl implements TypeService {

    @Resource
    private TypeDao typeDao;

    public Type getByUnameAndTypeName(int uId, String cContent) {
        return typeDao.getByUnameAndTypeName(uId, cContent);
    }

    @Transactional
    public int addType(int uId, String tName) {
        return typeDao.addType(uId, tName);
    }
}
