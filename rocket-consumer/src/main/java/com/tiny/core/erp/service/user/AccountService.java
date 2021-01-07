package com.tiny.core.erp.service.user;

import com.tiny.core.api.vo.AccountInfoVO;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wangzb
 * @version 1.0
 * @date 2020/12/30
 */
public interface AccountService {
    /**
     * userList
     * @param mv model and view
     * @return mv
     */
    ModelAndView qryUserList(ModelAndView mv);

    /**
     * 添加用户
     * @param userInfoVO infovo
     */
    void addUser(AccountInfoVO userInfoVO);
}
