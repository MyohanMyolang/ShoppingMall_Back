package com.myolang.shoppingmall_back.Member.service;

import com.myolang.shoppingmall_back.Member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Profile("local")
public class MemberServiceLocalImpl implements MemberService {

  private final MemberRepository memberRepository;

  public void save(){

  }
}
