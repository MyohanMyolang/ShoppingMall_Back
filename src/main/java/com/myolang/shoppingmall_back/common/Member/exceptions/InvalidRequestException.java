package com.myolang.shoppingmall_back.common.Member.exceptions;

public class InvalidRequestException extends RuntimeException{
  public InvalidRequestException(String message) {
    super(message);
  }
}
