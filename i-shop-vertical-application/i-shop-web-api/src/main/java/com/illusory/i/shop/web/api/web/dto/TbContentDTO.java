package com.illusory.i.shop.web.api.web.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * 内容数据传输对象
 *
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/27
 */
@Data
public class TbContentDTO implements Serializable {
    private Long id;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
}
