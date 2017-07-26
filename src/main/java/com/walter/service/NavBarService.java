package com.walter.service;

import com.github.pagehelper.PageInfo;
import com.walter.common.ServerResponse;
import com.walter.pojo.NavBar;

/**
 * Created by walter on 2017/7/24.
 */
public interface NavBarService {
    int addNavBar(NavBar navBar);

    PageInfo getNavBars(int pageNum,int pageSize);

    ServerResponse getById(Integer uId);

    ServerResponse<String> updateById(NavBar navBar);

    ServerResponse<String> delById(int nId);


}
