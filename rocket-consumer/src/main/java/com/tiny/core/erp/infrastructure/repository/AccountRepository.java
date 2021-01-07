package com.tiny.core.erp.infrastructure.repository;

import com.tiny.core.erp.infrastructure.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wangzb
 * @version 1.0
 * @date 2020/12/30
 */
@Repository
public interface AccountRepository extends JpaRepository<AccountEntity,Long> {
}
