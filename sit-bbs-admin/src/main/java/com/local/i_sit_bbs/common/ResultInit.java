/**
 * Copyright © 贵阳市委政法委 2019 Info. Tech Ltd. All rights reserved
 */
package com.local.i_sit_bbs.common;

/**
 * @ClassName:  ResultInit
 * @Description: TODO
 * @Author: chen.dedao
 * @Date: 2019/8/26 15:47
 * @Version: 1.0.0
 */
public enum ResultInit {
    OK(true, 200, "成功"),
    FAILED(false, -1, "失败"),
    BAD_REQUEST(false, 400, "错误请求"),
    NOT_FOUND(false, 404, "无法映射请求"),
    INTERNAL_SERVER_ERROR(false, 500, "服务器内部错误");

    // @Property: 响应 是否成功
    private final boolean success;
    // @Property: 响应 错误码
    private final int code;
    // @Property: 响应 信息
    private final String msg;

    ResultInit(boolean success, int code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

