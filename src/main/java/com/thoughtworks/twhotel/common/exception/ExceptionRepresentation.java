package com.thoughtworks.twhotel.common.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionRepresentation {
    private String message;
    private ExceptionCode exceptionCode;
    private Map<String, Object> parameters;
    private int statusCode;
}
