package com.tiny.core.crm.service.user.rest;

import com.tiny.core.api.service.UserService;
import com.tiny.core.api.utils.ListCopyUtils;
import com.tiny.core.api.vo.UserInfoVO;
import com.tiny.core.crm.infrastructure.entity.UserEntity;
import com.tiny.core.crm.infrastructure.repository.UserRepository;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.stream.messaging.Source;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangzb
 * @version 1.0
 * @date 2020/12/30
 */
@Service(protocol = "dubbo", version = "1.0.0")
public class UserServiceRemoteImpl implements UserService {
    @Resource
    private UserRepository userRepository;
    @Resource
    private Source source;

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
    @GlobalTransactional
    public void addUser(UserInfoVO userInfoVO) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userInfoVO,userEntity);
        userRepository.save(userEntity);
    }
}
