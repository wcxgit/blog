package com.walter.dao;

import com.walter.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized;

import java.util.List;

/**
 * Created by walter on 2017/7/23.
 */
public interface UserInfoDao {

    /**
     * 用户注册
     * @param userInfo
     * @return
     */
    int register(UserInfo userInfo);

    /**
     * 用户登陆
     * @param username
     * @param password
     * @return
     */
    UserInfo login(@Param("username") String username, @Param("password") String password,@Param("role") int role);


    List<UserInfo> getUsers();

    int removeUser(int uId);

    int undo(int uId);
}
