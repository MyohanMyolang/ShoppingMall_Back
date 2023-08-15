package com.myolang.shoppingmall_back.Member.service;


import com.myolang.shoppingmall_back.Member.dto.MemberDto;
import com.myolang.shoppingmall_back.Member.entity.Member;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {

  public boolean regist(Member member);

  public boolean duplicateCheckUserId(String userId);

  default public boolean regist(MemberDto memberDto){

    return regist(Member.builder().build());
  }
}
