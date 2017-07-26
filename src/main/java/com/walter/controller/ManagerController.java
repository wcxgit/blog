package com.walter.controller;

import com.github.pagehelper.PageInfo;
import com.walter.common.Constant;
import com.walter.common.ResponseCode;
import com.walter.common.ServerResponse;
import com.walter.pojo.NavBar;
import com.walter.pojo.UserInfo;
import com.walter.service.NavBarService;
import com.walter.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by walter on 2017/7/24.
 * 管理员相关操作
 */
@Controller
@RequestMapping("/manage/")
public class ManagerController {

    @Resource
    private NavBarService navBarService;
    @Resource
    private UserInfoService userInfoService;

    /**
     * 添加导航栏内容
     *
     * @param navBar
     * @return
     */
    @RequestMapping(value = "addNavBar.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> addNavBar(NavBar navBar) {
        if (navBar.getnName() == null || navBar.getnPath() == null) {
            return ServerResponse.createByError(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        int rowCount = navBarService.addNavBar(navBar);
        if (rowCount > 0) {
            return ServerResponse.createBySuccessMessage("添加成功!");
        }
        return ServerResponse.createByError("添加失败!");
    }

    /**
     * 获取所有导航栏内容
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "getNavBars.do", method = RequestMethod.GET)
    public String getNavBars(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                             HttpServletRequest request) {
        PageInfo pageInfo = navBarService.getNavBars(pageNum, pageSize);
        System.out.println(pageInfo.getList());
        request.setAttribute("pageInfo", pageInfo);
        return "forward:" + Constant.path.MANAGERPATH + "navbar.jsp";
    }

    /**
     * 根据id查找指定navbar信息
     *
     * @param uId
     * @return
     */
    @RequestMapping(value = "getById.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getById(Integer uId) {
        if (uId == null) {
            return ServerResponse.createByError(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        return navBarService.getById(uId);
    }

    /**
     * 根据id修改navbar内容
     *
     * @param navBar
     * @return
     */
    @RequestMapping(value = "updateById.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> updateById(NavBar navBar) {
        if (StringUtils.isEmpty(navBar.getnName()) || StringUtils.isEmpty(navBar.getnPath())) {
            return ServerResponse.createByError(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        return navBarService.updateById(navBar);
    }

    /**
     * 根据id删除指定navbar信息
     *
     * @param nId
     * @return
     */
    @RequestMapping(value = "delById.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> delById(Integer nId) {
        if (nId == null) {
            return ServerResponse.createByError(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        return navBarService.delById(nId);
    }

    /**
     * 查询所有用户信息
     *
     * @param pageNum
     * @param pageSize
     * @param request
     * @return
     */
    @RequestMapping(value = "getUsers.do", method = RequestMethod.GET)
    public String getUsers(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                           HttpServletRequest request) {
        PageInfo pageInfo = userInfoService.getUsers(pageNum, pageSize);
        request.setAttribute("pageInfo", pageInfo);
        return "forward:" + Constant.path.MANAGERPATH + "usermanage.jsp";
    }

    /**
     * 封存账号
     *
     * @param uId
     * @param type 操作类型:解封或者封号
     * @return
     */
    @RequestMapping(value = "removeUser.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> removeUser(Integer uId, String type) {
        if (uId == null || StringUtils.isEmpty(type)) {
            return ServerResponse.createByError(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        return userInfoService.removeUser(uId, type);
    }

}
