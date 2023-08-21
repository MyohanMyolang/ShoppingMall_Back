package com.myolang.shoppingmall_back.Auth.service;

import com.myolang.shoppingmall_back.common.Member.dto.MemberDto;
import com.myolang.shoppingmall_back.common.Member.entity.Member;
import com.myolang.shoppingmall_back.common.Member.exceptions.DeveloperException;

public interface AuthService {
  
  public boolean regist(Member member) throws DeveloperException;

  default public boolean regist(MemberDto memberDto) throws DeveloperException {

    return regist(memberDto.toEntity());
  }
}
