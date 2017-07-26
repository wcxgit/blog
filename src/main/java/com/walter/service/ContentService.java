package com.walter.service;

import com.walter.common.ServerResponse;
import com.walter.pojo.UserInfo;

/**
 * Created by walter on 2017/7/25.
 */
public interface ContentService {
    ServerResponse<String> addMood(UserInfo userInfo, String cContent);
}
