package com.myolang.shoppingmall_back.Member.entity;

public enum Role {
  Admin(1, "Admin"),
  LoginUser(2, "LoginUser"),
  NotLoginUser(3, "NotLoginUser"),
  Seller(4, "Seller");


  Role(int id, String roleName) {

  }
}
