package com.tiny.core.api.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangzb
 * @version 1.0
 * @date 2020/12/30
 */
@Data
public class AccountInfoVO implements Serializable {
    private String accountName;
    private Integer accountMoney;
}
