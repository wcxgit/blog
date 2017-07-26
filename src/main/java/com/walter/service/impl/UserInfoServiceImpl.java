package com.walter.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.walter.Utils.MD5Util;
import com.walter.common.ResponseCode;
import com.walter.common.ServerResponse;
import com.walter.dao.UserInfoDao;
import com.walter.pojo.UserInfo;
import com.walter.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by walter on 2017/7/23.
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoDao userInfoDao;

    public ServerResponse register(UserInfo userInfo) {
        int rowCount = userInfoDao.register(userInfo);
        if (rowCount == 0) {
            return ServerResponse.createByError(ResponseCode.ERROR.getCode(), "注册失败");
        }
        return ServerResponse.createBySuccessMessage("注册成功");
    }


    public ServerResponse login(String uName, String uPassword, int uRole, HttpSession session) {
        uPassword = MD5Util.getMd5(uPassword);
        UserInfo userInfo = userInfoDao.login(uName, uPassword, uRole);
        if (userInfo == null) {
            return ServerResponse.createByError("用户名或密码错误");
        }
        session.setAttribute("user", userInfo);
        return ServerResponse.createBySuccessMessage("登录成功");
    }

    public PageInfo getUsers(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserInfo> userInfos = userInfoDao.getUsers();
        PageInfo pageInfo = new PageInfo(userInfos);
        return pageInfo;
    }

    public ServerResponse<String> removeUser(int uId, String type) {
        int rowCount;
        if ("remove".equals(type)) {
            //封号
            rowCount = userInfoDao.removeUser(uId);
        } else {
            //解封
            rowCount = userInfoDao.undo(uId);
        }

        if (rowCount > 0) {
            return ServerResponse.createBySuccessMessage("操作成功");
        }
        return ServerResponse.createByError("操作失败");
    }

}
