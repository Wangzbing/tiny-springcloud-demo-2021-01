package com.tiny.core.erp.infrastructure.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

/**
 * @author wangzb
 * @version 1.0
 * @date 2020/12/30
 */
@Table
@Entity(name = "account_info")
@Data
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
    @Basic
    private String accountName;
    @Basic
    private Integer accountMoney;
}
