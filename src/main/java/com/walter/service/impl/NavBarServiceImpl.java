package com.walter.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.walter.common.ServerResponse;
import com.walter.dao.NavBarDao;
import com.walter.pojo.NavBar;
import com.walter.service.NavBarService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by walter on 2017/7/24.
 */
@Service("navBarService")
public class NavBarServiceImpl implements NavBarService {
    @Resource
    private NavBarDao navBarDao;

    @Transactional
    public int addNavBar(NavBar navBar) {
        return navBarDao.addNavBar(navBar);
    }

    public PageInfo getNavBars(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<NavBar> navBarList = navBarDao.getNavBars();
        PageInfo pageInfo = new PageInfo(navBarList);
        return pageInfo;
    }

    public ServerResponse getById(Integer uId) {
        NavBar navBar = navBarDao.getById(uId);
        if (navBar == null) {
            return ServerResponse.createByError("查询失败!");
        }
        return ServerResponse.createBySuccess(navBar);
    }

    public ServerResponse<String> updateById(NavBar navBar) {
        int rowCount = navBarDao.updateById(navBar);
        if (rowCount == 0) {
            return ServerResponse.createByError("修改失败!");
        }
        return ServerResponse.createBySuccessMessage("修改成功!");
    }

    public ServerResponse<String> delById(int nId) {
        int rowCount = navBarDao.delById(nId);
        if (rowCount == 0) {
            return ServerResponse.createByError("删除失败!");
        }
        return ServerResponse.createBySuccessMessage("删除成功!");
    }
}
