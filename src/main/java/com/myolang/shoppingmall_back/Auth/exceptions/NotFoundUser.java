package com.myolang.shoppingmall_back.Auth.exceptions;

public class NotFoundUser extends RuntimeException{

  public NotFoundUser(){
    super("아이디 또는 비밀번호를 확인하여 주십시오.");
  }
}
