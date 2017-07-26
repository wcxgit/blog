package com.walter.service.impl;

import com.walter.common.ServerResponse;
import com.walter.dao.ContentDao;
import com.walter.dao.TypeDao;
import com.walter.pojo.Content;
import com.walter.pojo.Type;
import com.walter.pojo.UserInfo;
import com.walter.service.ContentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.security.cert.CertificateNotYetValidException;

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
    public ServerResponse addMood(UserInfo userInfo, String cContent) {
        String tName = "心情物语";
        String abstrart = cContent;
        if (cContent.length() > 100) {
            abstrart = cContent.substring(0, 100);
        }
        Type type1 = null;//用于在添加新类别的时候存储类别信息
        Content content = null; //存储书写的文章信息

        Type type = typeDao.getByUnameAndTypeName(userInfo.getuId(), tName);
        if (type == null) {
            //还没有此类别
            //添加心情类别
            type1 = new Type();
            type1.setUserInfo(userInfo);
            type1.settName(tName);
            int rowCount = typeDao.addType(type1);
            if (rowCount > 0) {
                //类别添加成功
                content = new Content();
                content.setUserInfo(userInfo);
                content.setType(type1);
                content.setcContent(cContent);
                content.setcAbstract(abstrart);
            } else {
                return ServerResponse.createByError("新增类别失败");
            }
        }

        //封装心情内容
        content = new Content();
        content.setUserInfo(userInfo);
        content.setType(type);
        content.setcContent(cContent);
        content.setcAbstract(abstrart);
        //将心情内容添加到数据库
        int rowCount = contentDao.addContent(content);
        if (rowCount > 0) {
            return ServerResponse.createBySuccess("心情内容保存成功", content);
        } else {
            return ServerResponse.createByError("心情内容保存失败");
        }
    }
}
