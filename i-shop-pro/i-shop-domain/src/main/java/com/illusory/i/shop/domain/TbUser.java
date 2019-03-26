package com.illusory.i.shop.domain;

import com.illusory.i.shop.commoms.persistence.BaseEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/25
 */
@Getter
@Setter
@ToString
public class TbUser extends BaseEntity {
    private String username;
    private String password;
    private String phone;
    private String email;
}
