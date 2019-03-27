package com.illusory.i.shop.web.api.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/27
 */
@Data
public class TbUserDTO implements Serializable {
    private Long id;
    private String username;

    @JsonIgnore
    private String password;
    private String phone;
    private String email;
}
