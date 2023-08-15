package com.myolang.shoppingmall_back.Member.service;

import com.myolang.shoppingmall_back.Member.entity.Member;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"dev", "prod"})
@Service
public class MemberServiceImpl implements MemberService{


  @Override
  public boolean regist(Member member) {
    return false;
  }

  @Override
  public boolean duplicateCheckUserId(String userId) {
    return false;
  }
}
