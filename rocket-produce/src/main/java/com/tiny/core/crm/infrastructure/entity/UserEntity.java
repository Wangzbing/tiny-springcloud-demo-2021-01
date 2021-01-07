package com.tiny.core.crm.infrastructure.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author wangzb
 * @version 1.0
 * @date 2020/12/30
 */
@Table
@Entity(name = "user_info")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Basic
    private String userName;
    @Basic
    private Integer age;
}
