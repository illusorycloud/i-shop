package com.illusory.i.shop.service.search.domain;

import java.io.Serializable;

/**
 * 搜索结果实体类
 *
 * @author illusory
 * @version 1.0.0
 * @date 2019/4/9
 */
public class TbItemResult implements Serializable {
    private static final long serialVersionUID = -2859677806808201070L;
    private Long id;
    private Long tbItemCid;
    private String tbItemCname;
    private String tbItemTitle;
    private String tbItemSellPoint;
    private String tbItemDesc;

    @Override
    public String toString() {
        return "TbItemResult{" +
                "id=" + id +
                ", tbItemCid=" + tbItemCid +
                ", tbItemCname='" + tbItemCname + '\'' +
                ", tbItemTitle='" + tbItemTitle + '\'' +
                ", tbItemSellPoint='" + tbItemSellPoint + '\'' +
                ", tbItemDesc='" + tbItemDesc + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTbItemCid() {
        return tbItemCid;
    }

    public void setTbItemCid(Long tbItemCid) {
        this.tbItemCid = tbItemCid;
    }

    public String getTbItemCname() {
        return tbItemCname;
    }

    public void setTbItemCname(String tbItemCname) {
        this.tbItemCname = tbItemCname;
    }

    public String getTbItemTitle() {
        return tbItemTitle;
    }

    public void setTbItemTitle(String tbItemTitle) {
        this.tbItemTitle = tbItemTitle;
    }

    public String getTbItemSellPoint() {
        return tbItemSellPoint;
    }

    public void setTbItemSellPoint(String tbItemSellPoint) {
        this.tbItemSellPoint = tbItemSellPoint;
    }

    public String getTbItemDesc() {
        return tbItemDesc;
    }

    public void setTbItemDesc(String tbItemDesc) {
        this.tbItemDesc = tbItemDesc;
    }
}
