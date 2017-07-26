package com.walter.dao;

import com.walter.common.ServerResponse;
import com.walter.pojo.NavBar;
import com.walter.pojo.UserInfo;

import java.util.List;

/**
 * Created by walter on 2017/7/24.
 */
public interface NavBarDao {
    int addNavBar(NavBar navBar);

    List<NavBar> getNavBars();

    NavBar getById(int id);

    int updateById(NavBar navBar);

    int delById(int nId);


}
