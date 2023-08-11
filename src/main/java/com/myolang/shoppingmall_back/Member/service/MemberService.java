package com.myolang.shoppingmall_back.Member.service;


import org.springframework.stereotype.Service;

@Service
public interface MemberService {

  public boolean regist();

  public boolean duplicateCheckUserId(String userId);
}
