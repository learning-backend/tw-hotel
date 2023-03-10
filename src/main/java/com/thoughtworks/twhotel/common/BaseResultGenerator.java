package com.thoughtworks.twhotel.common;

import com.thoughtworks.twhotel.common.exception.BaseException;

public class BaseResultGenerator {
    /**
     * 生成返回结果
     *
     * @param code    返回编码
     * @param message 返回消息
     * @param data    返回数据
     * @param <T>     返回数据类型
     * @return 返回结果
     */
    public static <T> BaseResult<T> generate(final int code, final String message, String token, T data) {
        return new BaseResult<>(code, false, message, token, data);
    }

    /**
     * 操作成功响应结果， 默认结果
     *
     * @return 操作成功的默认响应结果
     */
    public static <T> BaseResult<T> success() {
        return new BaseResult<>(BaseResultEnum.SUCCESS.getCode(), true, BaseResultEnum.SUCCESS.getMessage(), null, null);
    }

    /**
     * 操作成功响应结果， 自定义数据及信息
     *
     * @param message 自定义信息
     * @param data    自定义数据
     * @param <T>     自定义数据类型
     * @return 响应结果
     */
    public static <T> BaseResult<T> success(final String message, final T data) {
        return new BaseResult<>(BaseResultEnum.SUCCESS.getCode(), true, message, null, data);
    }

    /**
     * 操作成功响应结果，自定义数据，默认信息
     *
     * @param data 自定义数据
     * @param <T>  自定义数据类型
     * @return 响应结果
     */
    public static <T> BaseResult<T> success(final T data) {
        return new BaseResult<>(BaseResultEnum.SUCCESS.getCode(), true, BaseResultEnum.SUCCESS.getMessage(), null, data);
    }

    /**
     * 操作成功响应结果，自定义信息，无数据
     *
     * @param message 自定义信息
     * @return 响应结果
     */
    public static <T> BaseResult<T> success4Message(final String message) {
        return new BaseResult<>(BaseResultEnum.SUCCESS.getCode(), true, message, null, null);
    }

    /**
     * 操作失败响应结果， 默认结果
     *
     * @return 操作成功的默认响应结果
     */
    public static <T> BaseResult<T> failure() {
        return new BaseResult<>(BaseResultEnum.FAIL.getCode(), false, BaseResultEnum.FAIL.getMessage(), null, null);
    }

    /**
     * 操作失败响应结果， 自定义错误编码及信息
     *
     * @param code    自定义错误编码
     * @param message 自定义信息
     * @return 响应结果
     */
    public static <T> BaseResult<T> failure(final int code, final String message) {
        return new BaseResult<>(code, false, message, null, null);
    }

    /**
     * 操作失败响应结果， 自定义错误编码及信息
     *
     * @param code    自定义错误编码
     * @param message 自定义信息
     * @return 响应结果
     */
    public static <T> BaseResult<T> failure(final int code, final String message, T data) {
        return new BaseResult<>(code, false, message, null, data);
    }

    /**
     * 操作失败响应结果，自定义错误编码
     *
     * @param baseResultEnum 自定义错误编码枚举
     * @return 响应结果
     */
    public static <T> BaseResult<T> failure(final BaseResultEnum baseResultEnum) {
        return new BaseResult<>(baseResultEnum.getCode(), false, baseResultEnum.getMessage(), null, null);
    }

    /**
     * 操作失败响应结果，自定义信息
     *
     * @param message 自定义信息
     * @return 响应结果
     */
    public static <T> BaseResult<T> failure(final String message) {
        return new BaseResult<>(BaseResultEnum.FAIL.getCode(), false, message, null, null);
    }

    /**
     * 异常响应结果， 自定义错误编码及信息
     *
     * @param code    自定义错误编码
     * @param message 自定义信息
     * @return 响应结果
     */
    public static <T> BaseResult<T> error(final int code, final String message) {
        return new BaseResult<>(code, false, message, null, null);
    }

    /**
     * 异常响应结果，自定义错误编码
     *
     * @param baseResultEnum 自定义错误编码枚举
     * @return 响应结果
     */
    public static <T> BaseResult<T> error(final BaseResultEnum baseResultEnum) {
        return new BaseResult<>(baseResultEnum.getCode(), false, baseResultEnum.getMessage(), null, null);
    }

    /**
     * 业务异常响应结果
     *
     * @param be 业务异常
     * @return 响应结果
     */
    public static <T> BaseResult<T> error(final BaseException be) {
        return new BaseResult<>(BaseResultEnum.SERVER_ERROR.getCode(), false, be.getMessage(), null, null);
    }

    /**
     * 异常响应结果，自定义信息
     *
     * @param message 自定义信息
     * @return 响应结果
     */
    public static <T> BaseResult<T> error(final String message) {
        return new BaseResult<>(BaseResultEnum.SERVER_ERROR.getCode(), false, message, null, null);
    }
}
