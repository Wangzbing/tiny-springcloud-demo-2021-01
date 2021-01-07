package com.tiny.core.api.service;

import com.tiny.core.api.vo.UserInfoVO;

import java.util.List;

/**
 * @author wangzb
 * @version 1.0
 * @date 2020/12/30
 */
public interface UserService {
    /**
     * userList
     * @return mv
     */
    List<UserInfoVO> qryUserList();

    /**
     * 添加用户
     * @param userInfoVO infovo
     */
    void addUser(UserInfoVO userInfoVO);
}
