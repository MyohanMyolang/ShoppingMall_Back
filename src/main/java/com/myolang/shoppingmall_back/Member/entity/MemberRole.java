package com.myolang.shoppingmall_back.Member.entity;

import lombok.Getter;

public enum MemberRole {
  LoginUser(1, "LoginUser"),
  NotLoginUser(2, "NotLoginUser"),
  Seller(3, "Seller"),
  Admin(100, "Admin");

  @Getter
  private final int id;
  @Getter
  private final String roleName;

  MemberRole(int id, String roleName) {
    this.id = id;
    this.roleName = roleName;
  }
}
