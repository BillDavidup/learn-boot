package com.david.learn.learnboot.utils.result;

import java.io.Serializable;
import java.util.List;

/**
 * <T> == <T extends Object> T参数类型必须是Object或Object的子类型 上届
 *
 * @Author: wudening
 * @Description: 返回结果封装类
 * @Date: 2021/2/26 6:05 下午
 */
public class ResultDTO<T> implements Serializable {
    private static final long serialVersionUID = -4386065492454783771L;
    /**
     * 返回码
     */
    private String code;

    /**
     * 返回消息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;


    /**
     * 默认构造方法
     */
    public ResultDTO() {
    }

    /**
     * 构造方法
     *
     * @param code 返回码
     * @param msg  返回消息
     * @param data 返回数据
     */
    public ResultDTO(final String code, final String msg, final T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 构造请求成功时的返回对象
     *
     * @return 返回对象
     */
    public static ResultDTO success() {

        return new ResultDTO(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg(), null);
    }

    /**
     * 构造请求成功时的返回对象
     *
     * @param data 数据信息
     * @return 返回对象
     */
    public static <T> ResultDTO<T> success(final T data) {

        return new ResultDTO(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg(), data);
    }

    /**
     * 构造请求成功时的返回数组对象
     *
     * @param data 数据信息
     * @return 返回对象
     */
    public static <T> ResultDTO<List<T>> success(final List<T> data) {

        return new ResultDTO(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg(), data);
    }

    /**
     * 构造请求失败时的返回对象
     *
     * @param code 错误码
     * @param msg  错误内容
     * @return 返回对象
     */
    public static ResultDTO failed(final String code, final String msg) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMsg(msg);
        return resultDTO;
    }

    /**
     * 构造请求失败时的返回对象
     *
     * @param resultCode 错误码对象
     * @return 返回对象
     */
    public static ResultDTO failed(ResultCodeEnum resultCode) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(resultCode.getCode());
        resultDTO.setMsg(resultCode.getMsg());
        return resultDTO;
    }

    /**
     * 获取 返回码
     */
    public String getCode() {
        return this.code;
    }

    /**
     * 设置 返回码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取 返回消息
     */
    public String getMsg() {
        return this.msg;
    }

    /**
     * 设置 返回消息
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取 返回数据
     */
    public T getData() {
        return this.data;
    }

    /**
     * 设置 返回数据
     */
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
