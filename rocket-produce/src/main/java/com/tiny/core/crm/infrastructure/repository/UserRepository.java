package com.tiny.core.crm.infrastructure.repository;

import com.tiny.core.crm.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wangzb
 * @version 1.0
 * @date 2020/12/30
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
