package com.illusory.i.shop.commons.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 自定义返回结果集
 *
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/25
 */
@Getter
@Setter
@ToString
public class BaseResult {
    private int status;
    private String message;
    /**
     * HTTP状态码
     */
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAIL = 500;

    public static BaseResult success() {
        return BaseResult.createBaseResult(STATUS_SUCCESS, "成功");

    }

    public static BaseResult success(String message) {
        return BaseResult.createBaseResult(STATUS_SUCCESS, message);
    }

    public static BaseResult fail() {
        return BaseResult.createBaseResult(STATUS_FAIL, "失败");
    }

    public static BaseResult fail(String message) {
        return BaseResult.createBaseResult(STATUS_FAIL, message);
    }

    public static BaseResult fail(int status, String message) {
        return BaseResult.createBaseResult(status, message);
    }

    private static BaseResult createBaseResult(int status, String message) {
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        return baseResult;
    }
}
