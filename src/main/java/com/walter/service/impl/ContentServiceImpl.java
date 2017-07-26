package com.walter.service.impl;

import com.walter.common.ServerResponse;
import com.walter.dao.ContentDao;
import com.walter.dao.TypeDao;
import com.walter.pojo.Type;
import com.walter.pojo.UserInfo;
import com.walter.service.ContentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by walter on 2017/7/25.
 */
@Service("contentService")
public class ContentServiceImpl implements ContentService {

    @Resource
    private ContentDao contentDao;
    @Resource
    private TypeDao typeDao;

    @Transactional
    public ServerResponse<String> addMood(UserInfo userInfo, String cContent) {
        String tName = "心情物语";
        Type type = typeDao.getByUnameAndTypeName(userInfo.getuId(), tName);
        if (type == null) {
            //还没有此类别
            //添加心情类别
            int rowCount = typeDao.addType(userInfo.getuId(), tName);
            System.out.println(rowCount);
            System.out.println(type.gettId());
            /*if (rowCount > 0) {
                return ServerResponse.createBySuccessMessage("新增类别成功");
            } else {
                return ServerResponse.createByError("新增类别失败");
            }
        }

        //心情类别存在,将添加心情内容
        Content content = new Content();
        content.setUserInfo(userInfo);*/

        }
        return null;
    }
}
