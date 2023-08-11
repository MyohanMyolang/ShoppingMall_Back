package com.myolang.shoppingmall_back.Member.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class MemberErrorCode {

  private static Map<String, String> errCode;
  static {
    errCode = new HashMap<String,String>();
    errCode.put("user_id","");
  }
  protected ResponseEntity getResponseEntity(HttpStatus status, String uniqueKey, String value){
    return ResponseEntity.status(status).build();
  }
}
