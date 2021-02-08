/**
 * Copyright © 贵阳市委政法委 2019 Info. Tech Ltd. All rights reserved
 */
package com.local.i_sit_bbs.common;

import java.io.Serializable;

/** 
 * @ClassName:  Result
 * @Description: TODO
 * @Author: chen.dedao
 * @Date: 2019/8/26 15:54
 * @Version: 1.0.0  
 */
public class Result<T> implements Serializable {

    // @Property: 响应 是否成功
    private boolean success;
    // @Property: 响应 错误码
    private int code;
    // @Property: 响应 信息
    private String msg;
    // @Property: 响应 数据对象
    private T data;

    public Result(boolean success, int code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result() {
    }

    //200成功，ResultInit枚举值 + 返回数据
    public static Result success(Object data) {
        return new Result(ResultInit.OK.isSuccess(), ResultInit.OK.getCode(), ResultInit.OK.getMsg(), data);
    }

    //200成功，自定义消息，ResultInit中预定义的成功boolean值和状态码 + 返回数据
    public static Result success(Object data, String msg) {
        return new Result(ResultInit.OK.isSuccess(), ResultInit.OK.getCode(), msg, data);
    }

    //500服务器错误，ResultInit枚举值 + 返回数据
    public static Result error(Object data) {
        return new Result(ResultInit.INTERNAL_SERVER_ERROR.isSuccess(), ResultInit.INTERNAL_SERVER_ERROR.getCode(),
                ResultInit.INTERNAL_SERVER_ERROR.getMsg(), data);
    }

    //400请求语法错误，ResultInit枚举值 + 返回数据
    public static Result badRequest(Object data) {
        return new Result(ResultInit.BAD_REQUEST.isSuccess(), ResultInit.BAD_REQUEST.getCode(),
                ResultInit.BAD_REQUEST.getMsg(), data);
    }

    //404资源不存在，ResultInit枚举值
    public static Result notFound(Object data) {
        return new Result(ResultInit.NOT_FOUND.isSuccess(), ResultInit.NOT_FOUND.getCode(),
                ResultInit.NOT_FOUND.getMsg(), data);
    }

    //未知错误，数据返回失败，自定义消息
    public static Result failed(String msg) {
        return new Result(false, ResultInit.FAILED.getCode(), msg, null);
    }

    //通过一个boolean值判定是否成功,不返回数据
    public static Result result(boolean result) {
        return new Result(result, result ? ResultInit.OK.getCode() : ResultInit.FAILED.getCode(),
                result ? ResultInit.OK.getMsg() :ResultInit.FAILED.getMsg(), null);
    }

    public Result setError(ResultInit code, String msg) {
        return new Result(false, code.getCode(), msg, null);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
