package com.myolang.shoppingmall_back.Auth.service;

import com.myolang.shoppingmall_back.common.Member.dto.MemberDto;
import com.myolang.shoppingmall_back.common.Member.entity.Member;
import com.myolang.shoppingmall_back.common.Member.exceptions.DeveloperException;
import com.myolang.shoppingmall_back.global.exceptions.AlreadyHasDataException;

public interface AuthService {
  
  public boolean regist(Member member) throws AlreadyHasDataException;
  default public boolean regist(MemberDto memberDto) throws AlreadyHasDataException {return regist(memberDto.toEntity());}


}
