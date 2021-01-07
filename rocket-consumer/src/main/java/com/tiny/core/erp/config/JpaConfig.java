package com.tiny.core.erp.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wangzb
 * @version 1.0
 * @date 2020/12/30
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.tiny.core.**.infrastructure.repository"})
@EnableTransactionManagement
@EntityScan("com.tiny.core.**.infrastructure.entity")
public class JpaConfig{
}
