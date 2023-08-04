package com.myolang.shoppingmall_back.Member.service;

import com.myolang.shoppingmall_back.Member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class MemberServiceImplTest {
  @Autowired
  MemberRepository memberRepository;
  MemberService memberService = new MemberService() {
    @Override
    public void save() {
    }
  };
}