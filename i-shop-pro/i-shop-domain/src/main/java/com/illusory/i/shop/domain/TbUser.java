package com.illusory.i.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.illusory.i.shop.commoms.persistence.BaseEntity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/25
 */
@Data
public class TbUser extends BaseEntity {
    private String username;
    @JsonIgnore
    private String password;
    private String phone;
    private String email;
}
