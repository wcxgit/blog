package com.walter.controller;

import com.github.pagehelper.util.StringUtil;
import com.sun.javaws.jnl.RContentDesc;
import com.sun.net.httpserver.HttpsConfigurator;
import com.walter.Utils.MD5Util;
import com.walter.common.ResponseCode;
import com.walter.common.ServerResponse;
import com.walter.pojo.UserInfo;
import com.walter.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by walter on 2017/7/23.
 * 用户相关操作
 */
@Controller
@RequestMapping("/user/")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    /**
     * 用户注册
     *
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "register.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse regiseter(UserInfo userInfo) {
        userInfo.setuRole(0);
        userInfo.setuPassword(MD5Util.getMd5(userInfo.getuPassword()));
        return userInfoService.register(userInfo);
    }

    /**
     * 用户登录
     *
     * @param uName
     * @param uPassword
     * @param code
     * @param role      用户角色:管理员/普通用户
     * @param session
     * @return
     */
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse login(@RequestParam("uName") String uName, @RequestParam("uPassword") String uPassword,
                                @RequestParam("code") String code, @RequestParam(value = "uRole", defaultValue = "0") Integer role,
                                HttpSession session) {
        if (role != 0 && role != 1) {
            return ServerResponse.createByError(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        String codeSession = (String) session.getAttribute("code_session");
        if (!StringUtils.isEmpty(code)) {
            if (!code.equals(codeSession.toLowerCase())) {
                return ServerResponse.createByError(ResponseCode.CODE_ERROR.getCode(), ResponseCode.CODE_ERROR.getDesc());
            }
        }
        if (uName == null || uPassword == null) {
            return ServerResponse.createByError(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        return userInfoService.login(uName, uPassword, role, session);
    }

    /**
     * 注销
     *
     * @param session
     */
    @RequestMapping(value = "signOut.do", method = RequestMethod.POST)
    public void signOut(HttpSession session) {
        session.invalidate();
    }


}
