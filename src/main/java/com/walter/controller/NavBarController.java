package com.walter.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.walter.common.ServerResponse;
import com.walter.service.NavBarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by walter on 2017/7/25.
 */
@Controller
@RequestMapping("/navbar/")
public class NavBarController {

    @Resource
    private NavBarService navBarService;

    @RequestMapping("getbars.do")
    @ResponseBody
    public ServerResponse<PageInfo> getBars() {
        PageInfo pageInfo = navBarService.getNavBars(1, 100);
        return ServerResponse.createBySuccess(pageInfo);
    }
}
