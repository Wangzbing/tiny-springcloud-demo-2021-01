package com.tiny.core.erp.service.user.impl;


import com.tiny.core.api.vo.AccountInfoVO;
import com.tiny.core.erp.infrastructure.entity.AccountEntity;
import com.tiny.core.erp.infrastructure.repository.AccountRepository;
import com.tiny.core.erp.service.user.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author wangzb
 * @version 1.0
 * @date 2020/12/30
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountRepository accountRepository;
    /**
     * userList
     */
    @Override
    public ModelAndView qryUserList(ModelAndView mv) {
        Map<String, Object> model = mv.getModel();
        model.put("accountList",accountRepository.findAll());
        mv.setViewName("index");
        return mv;
    }

    /**
     * 添加用户
     *
     * @param userInfoVO infovo
     */
    @Override
    public void addUser(AccountInfoVO userInfoVO) {
        AccountEntity userEntity = new AccountEntity();
        BeanUtils.copyProperties(userInfoVO,userEntity);
        accountRepository.save(userEntity);
    }
}
