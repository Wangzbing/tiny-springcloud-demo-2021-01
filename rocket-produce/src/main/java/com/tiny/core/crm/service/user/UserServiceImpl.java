package com.tiny.core.crm.service.user;

import com.tiny.core.api.service.UserService;
import com.tiny.core.api.utils.ListCopyUtils;
import com.tiny.core.api.vo.UserInfoVO;
import com.tiny.core.crm.infrastructure.entity.UserEntity;
import com.tiny.core.crm.infrastructure.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangzb
 * @version 1.0
 * @date 2020/12/30
 */
@Service(value = "userServiceImpl")
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;
    /**
     * userList
     */
    @Override
    public List<UserInfoVO> qryUserList() {
        List<UserEntity> entities = userRepository.findAll();
        return ListCopyUtils.copyListProperties(entities,UserInfoVO::new);
    }

    /**
     * 添加用户
     *
     * @param userInfoVO infovo
     */
    @Override
    public void addUser(UserInfoVO userInfoVO) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userInfoVO,userEntity);
        userRepository.save(userEntity);
    }
}
