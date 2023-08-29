package com.myolang.shoppingmall_back.global.exceptions;

public class AlreadyHasDataException extends RuntimeException{
  public AlreadyHasDataException(String message) {
    super(message);
  }
}
