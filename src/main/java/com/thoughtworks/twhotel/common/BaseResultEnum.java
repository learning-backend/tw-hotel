package com.thoughtworks.twhotel.common;

import lombok.Getter;

@Getter
public enum BaseResultEnum {
    SUCCESS(200, "成功"),
    FAIL(400, "失败"),
    NOT_FOUND(404, "不存在"),
    TOKEN_ERROR(405, "token过期"),
    SERVER_ERROR(500, "服务异常");

    private final int code;

    private final String message;

    BaseResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
