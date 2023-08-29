package com.myolang.shoppingmall_back.common.Member.exceptions;

import org.springframework.http.ResponseEntity;

public class DeveloperException extends RuntimeException {

  MemberErrorCode errorCode;
  public DeveloperException(MemberErrorCode errorCode){
    super(errorCode.getMessage());
    this.errorCode = errorCode;
  }

  ResponseEntity createResEntity(){
    return ResponseEntity.status(errorCode.getStatus()).body("Server Error");
  }
}
