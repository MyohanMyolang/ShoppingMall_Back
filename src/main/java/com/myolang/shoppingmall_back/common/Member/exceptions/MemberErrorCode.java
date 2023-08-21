package com.myolang.shoppingmall_back.common.Member.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public enum MemberErrorCode {
    DEVELOPER_MISS(500, "Should Check Code", HttpStatus.INTERNAL_SERVER_ERROR);

    @Getter
    private final int code;
    @Getter
    private final String message;
    @Getter
    private final HttpStatus status;

    MemberErrorCode(int code, String message, HttpStatus status) {
      this.code = code;
      this.message = message;
      this.status = status;
    }

}
