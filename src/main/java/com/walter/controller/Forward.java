package com.walter.controller;

import com.walter.common.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by walter on 2017/7/23.
 */
@Controller
@RequestMapping("/forward/")
public class Forward {

    /**
     * 跳转到注册页面
     *
     * @return
     */
    @RequestMapping(value = "regist.do", method = RequestMethod.GET)
    public String toRegist() {
        return "forward:" + Constant.path.USERPATH + "register.jsp";
    }

    /**
     * 跳转到登录页面
     *
     * @return
     */
    @RequestMapping(value = "login.do", method = RequestMethod.GET)
    public String toLogin() {
        return "forward:" + Constant.path.USERPATH + "login.jsp";
    }

    /**
     * 跳转到登录页面
     *
     * @return
     */
    @RequestMapping(value = "manager.do", method = RequestMethod.GET)
    public String manager() {
        return "forward:" + Constant.path.USERPATH + "manager.jsp";
    }

    //跳转到心情物语
    @RequestMapping(value = "mood.do", method = RequestMethod.GET)
    public String mood() {
        return "forward:" + Constant.path.USERPATH + "mood.jsp";
    }

    //跳转到后台管理的index页面
    @RequestMapping(value = "managerIndex.do", method = RequestMethod.GET)
    public String managerIndex() {
        return "forward:" + Constant.path.MANAGERPATH + "index.jsp";
    }

    /**
     * 后台管理相关
     * frameset加载内容
     */
    //top
    @RequestMapping(value = "top.do", method = RequestMethod.GET)
    public String top() {
        return "forward:" + Constant.path.MANAGERPATH + "top.jsp";
    }

    //left
    @RequestMapping(value = "left.do", method = RequestMethod.GET)
    public String left() {
        return "forward:" + Constant.path.MANAGERPATH + "left.jsp";
    }

    //main
    @RequestMapping(value = "main.do", method = RequestMethod.GET)
    public String main() {
        return "forward:" + Constant.path.MANAGERPATH + "main.jsp";
    }

    //跳转到导航栏内容管理
    @RequestMapping(value = "navBar.do", method = RequestMethod.GET)
    public String navBar() {
        return "forward:" + Constant.path.MANAGERPATH + "navbar.jsp";
    }


}
