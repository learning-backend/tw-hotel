package com.thoughtworks.twhotel.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResult<T> implements Serializable {
    private Integer code;

    private boolean success;

    private String message;

    private String token;

    private T data;

    public boolean isSuccess() {
        return BaseResultEnum.SUCCESS.getCode() == this.code;
    }
}
