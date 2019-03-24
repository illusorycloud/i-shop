package com.illusory.i.shop.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author illusoryCloud
 * @version 1.0.0
 * @date 2019/3/24 16:36
 */
@Getter
@Setter
@ToString
public class User implements Serializable {
    private String email;
    private String password;
    private String username;
}
