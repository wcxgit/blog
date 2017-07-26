package com.walter.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.internal.NotNull;

import javax.print.DocFlavor;

/**
 * Created by walter on 2017/7/23.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> {

    private int status;//状态码
    private T data;//响应数据
    private String msg;//相应信息

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
    private ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status, T data, String msg) {

        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    private ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private ServerResponse(T data, String msg) {
        this.data = data;
        this.msg = msg;
    }

    public ServerResponse(int code, String msg, T data) {
    }

    public ServerResponse(int code) {
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    /**
     * 返回成功状态码
     *
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> createBySuccess() {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    /**
     * 返回成功时的状态码和成功信息
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> createBySuccessMessage(String msg) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg);
    }

    /**
     * 返回成功状态码和数据
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> createBySuccess(T data) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), data);
    }

    /**
     * 返回成功状态码,成功信息,数据
     *
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> createBySuccess(String msg, T data) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg, data);
    }

    /**
     * 返回枚举中的错误状态码和错误信息
     *
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> createByError() {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }

    /**
     * 返回错误状态码和自定义错误信息
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> createByError(String msg) {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), msg);
    }

    /**
     * 返回自定义错误信息和自定义错误状态码
     *
     * @param errorCode
     * @param errorMsg
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> createByError(int errorCode, String errorMsg) {
        return new ServerResponse<T>(errorCode, errorMsg);
    }

}
