package com.myolang.shoppingmall_back.Member.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class MemberErrorCode {

  protected enum ErrorCode {

  }

  private static Map<String, String> errCode;
  static {
    errCode = new HashMap<String,String>();
//    errCode.put(ErrorCode.,"");
  }
}
