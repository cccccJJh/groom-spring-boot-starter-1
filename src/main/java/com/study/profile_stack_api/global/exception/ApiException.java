package com.study.profile_stack_api.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

// 공통 예외 래퍼
@Getter
public class ApiException extends RuntimeException {
    private final ErrorCode errorCode;

    public ApiException(ErrorCode errorCode) {
        super(errorCode.defaultMessage());
        this.errorCode = errorCode;
    }

    public ApiException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ApiException(HttpStatus status, String message) {
        super(message);
        this.errorCode = null; // 필드에 따라 적절히 처리
        //this.status = status;
    }

}
