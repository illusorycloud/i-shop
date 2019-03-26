package com.illusory.i.shop.domain;

import com.illusory.i.shop.commoms.persistence.BaseEntity;
import com.sun.istack.internal.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2019/3/26 0026
 */
@Getter
@Setter
@ToString
public class TbContent extends BaseEntity {
    private String title;

    private String subTitle;

    private String titleDesc;

    private String url;
    private String pic;
    private String pic2;

    private String content;

    private TbContentCategory tbContentCategory;
}
