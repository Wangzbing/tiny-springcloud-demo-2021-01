package com.tiny.core.crm.endpoint;

import com.tiny.core.api.service.UserService;
import com.tiny.core.api.vo.UserInfoVO;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wangzb
 * @version 1.0
 * @date 2020/12/29
 */
@RestController
public class MessageController {
    @Resource
    private  Source source;

    @Resource(name = "userServiceImpl")
    private UserService userService;

    @GetMapping
    public ModelAndView sendMessage(ModelAndView mv){
        List<UserInfoVO> vos = userService.qryUserList();
        Map<String, Object> model = mv.getModel();
        model.put("userList",vos);
        mv.setViewName("index");
        source.output().send(MessageBuilder.withPayload("消息！！").build());
        return mv;
    }

    @PostMapping("/addUser")
    @ResponseBody
    public ModelAndView addUser(@ModelAttribute UserInfoVO userInfoVO){
        userService.addUser(userInfoVO);
        ModelAndView mv = new ModelAndView();
        List<UserInfoVO> vos = userService.qryUserList();
        Map<String, Object> model = mv.getModel();
        model.put("userList",vos);
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("/addUser")
    public ModelAndView userIndex(ModelAndView mv){
        mv.setViewName("user/add-user");
        return mv;
    }
}
