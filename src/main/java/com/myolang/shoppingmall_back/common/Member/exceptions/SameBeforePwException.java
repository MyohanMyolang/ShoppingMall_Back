package com.myolang.shoppingmall_back.common.Member.exceptions;

public class SameBeforePwException extends RuntimeException{

  public SameBeforePwException(String message) {
    super(message);
  }
}
