package com.walter.controller;

import com.walter.common.Constant;
import com.walter.common.ResponseCode;
import com.walter.common.ServerResponse;
import com.walter.pojo.Type;
import com.walter.pojo.UserInfo;
import com.walter.service.ContentService;
import com.walter.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by walter on 2017/7/25.
 */
@Controller
@RequestMapping("/content/")
public class ContentController {

    @Resource
    private ContentService contentService;
    @Resource
    private TypeService typeService;

    @RequestMapping(value = "addMood.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addMood(HttpSession session, @RequestParam("cContent") String cContent) {
        UserInfo userInfo = (UserInfo) session.getAttribute("user");
        if (userInfo == null) {
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }//todo 加入拦截器后能够舍去该代码
        return contentService.addMood(userInfo, cContent);
    }
}
