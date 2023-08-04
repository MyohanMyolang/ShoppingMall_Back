package com.myolang.shoppingmall_back.Member.service;

import org.springframework.context.annotation.Profile;

@Profile({"dev", "prod"})
public class MemberServiceImpl implements MemberService{
  @Override
  public void save(){

  }
}
