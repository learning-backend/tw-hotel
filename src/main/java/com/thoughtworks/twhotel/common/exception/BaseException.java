package com.thoughtworks.twhotel.common.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

@Getter
@Setter
@Builder
public class BaseException extends RuntimeException {
    private String message;
    private ExceptionCode exceptionCode;
    private Map<String, Object> parameters;
    private int statusCode;

    public BaseException(String message, ExceptionCode exceptionCode, Map<String, Object> parameters, int statusCode) {
        super(message);
        this.message = message;
        this.exceptionCode = exceptionCode;
        this.parameters = parameters;
        this.statusCode = statusCode;
    }

    public BaseException(String message, ExceptionCode exceptionCode, int statusCode) {
        super(message);
        this.message = message;
        this.exceptionCode = exceptionCode;
        this.statusCode = statusCode;
    }

    public BaseException(ExceptionCode exceptionCode, int statusCode) {
        super(StringUtils.EMPTY);
        this.exceptionCode = exceptionCode;
        this.statusCode = statusCode;
    }
}
