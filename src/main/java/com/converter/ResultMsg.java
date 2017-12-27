package com.converter;

/**
 * Created by 54472 on 2017/12/20.
 */
public class ResultMsg {
    public static final int EXIST = 9;

    public static final int SUCCESS = 1;

    public static final int DENY = 0;

    private int success;

    private String msg;

    public ResultMsg() {
    }

    public ResultMsg(int success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public static ResultMsg success() {
        return new ResultMsg(SUCCESS, "成功");
    }

    public static ResultMsg success(String msg) {
        return new ResultMsg(SUCCESS, msg);
    }

    public static ResultMsg deny() {
        return new ResultMsg(DENY, "失败");
    }

    public static ResultMsg deny(String msg) {
        return new ResultMsg(DENY, msg);
    }

    public static ResultMsg exist() {
        return new ResultMsg(EXIST, "存在");
    }

    public static ResultMsg exist(String msg) {
        return new ResultMsg(EXIST, msg);
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}