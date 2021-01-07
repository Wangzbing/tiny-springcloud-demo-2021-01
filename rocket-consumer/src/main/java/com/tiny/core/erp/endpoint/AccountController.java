package com.tiny.core.erp.endpoint;

import com.tiny.core.api.service.UserService;
import com.tiny.core.api.vo.AccountInfoVO;
import com.tiny.core.api.vo.UserInfoVO;
import com.tiny.core.erp.service.user.AccountService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wangzb
 * @version 1.0
 * @date 2020/12/29
 */
@Controller
public class AccountController {
    @Resource
    private AccountService accountService;
    
    @Reference(version = "1.0.0")
    private UserService userService;

    @GetMapping
    public ModelAndView sendMessage(ModelAndView mv){
        mv = accountService.qryUserList(mv);
        List<UserInfoVO> vos = userService.qryUserList();
        Map<String, Object> model = mv.getModel();
        model.put("userList",vos);
        return mv;
    }

    @PostMapping("/addUser")
    @ResponseBody
    public ModelAndView addUser(@ModelAttribute AccountInfoVO accountInfoVO){
        accountService.addUser(accountInfoVO);
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setUserName(accountInfoVO.getAccountName());
        userInfoVO.setAge(accountInfoVO.getAccountMoney()+1);
        userService.addUser(userInfoVO);
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfoVO> vos = userService.qryUserList();
        Map<String, Object> model = modelAndView.getModel();
        model.put("userList",vos);
        return accountService.qryUserList(modelAndView);
    }

    @GetMapping("/addUser")
    public ModelAndView userIndex(ModelAndView mv){
        mv.setViewName("user/add-user");
        return mv;
    }
}
