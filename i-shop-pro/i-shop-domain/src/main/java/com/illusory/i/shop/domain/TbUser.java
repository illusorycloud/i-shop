package com.illusory.i.shop.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2019/3/25 0025
 */
@Getter
@Setter
@ToString
public class TbUser implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Date created;
    private Date updated;
}
