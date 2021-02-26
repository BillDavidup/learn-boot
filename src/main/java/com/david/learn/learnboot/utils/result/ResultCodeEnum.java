package com.david.learn.learnboot.utils.result;

/**
 * @Author: wudening
 * @Description: 错误码枚举,可自定义
 * @Date: 2021/2/26 5:54 下午
 */
public enum ResultCodeEnum {
    /**
     * 成功
     */
    SUCCESS("0", "成功"),

    /**
     * 失败
     */
    FAIL("1", "失败");



    /**
     * 错误编码
     */
    private String code;
    /**
     * 错误消息
     */
    private String msg;

    ResultCodeEnum() {
    }

    /**
     * 构造方法
     *
     * @param code 返回码
     * @param msg  返回消息
     */
    ResultCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 获取 错误编码
     */
    public String getCode() {
        return this.code;
    }

    /**
     * 设置 错误编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取 错误消息
     */
    public String getMsg() {
        return this.msg;
    }

    /**
     * 设置 错误消息
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResultCodeEnum{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                "} " + super.toString();
    }
}
