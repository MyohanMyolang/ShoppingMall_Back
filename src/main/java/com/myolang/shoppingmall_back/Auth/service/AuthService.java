package com.myolang.shoppingmall_back.Auth.service;

import com.myolang.shoppingmall_back.common.Member.dto.MemberResDto;
import com.myolang.shoppingmall_back.common.Member.dto.RegistDto;
import com.myolang.shoppingmall_back.common.Member.entity.Member;

import java.util.Map;

public interface AuthService {
  
  public boolean regist(Member member);
  default public boolean regist(RegistDto registDto) {return regist(registDto.toEntity());}

  public MemberResDto login(String id, String pw);

}
