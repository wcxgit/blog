package com.walter.service;

import com.github.pagehelper.PageInfo;
import com.walter.common.ServerResponse;
import com.walter.pojo.UserInfo;

import javax.servlet.http.HttpSession;

/**
 * Created by walter on 2017/7/23.
 */
public interface UserInfoService {
    ServerResponse register(UserInfo userInfo);

    ServerResponse login(String uName, String uPassword, int uRole, HttpSession session);

    PageInfo getUsers(int pageNum, int pageSize);

    ServerResponse<String> removeUser(int uId, String type);
}
