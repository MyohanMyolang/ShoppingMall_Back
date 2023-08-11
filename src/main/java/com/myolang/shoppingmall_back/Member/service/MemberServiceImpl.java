package com.myolang.shoppingmall_back.Member.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"dev", "prod"})
@Service
public class MemberServiceImpl implements MemberService{


  @Override
  public boolean regist() {
    return false;
  }

  @Override
  public boolean duplicateCheckUserId(String userId) {
    return false;
  }
}
