package com.converter;

/**
 * Created by 54472 on 2017/12/20.
 */
public class ResultMsg {
    public static final int EXIST = 9;

    public static final int SUCCESS = 1;

    public static final int FAULT = 0;

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

    public static ResultMsg fault() {
        return new ResultMsg(FAULT, "失败");
    }

    public static ResultMsg fault(String msg) {
        return new ResultMsg(FAULT, msg);
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