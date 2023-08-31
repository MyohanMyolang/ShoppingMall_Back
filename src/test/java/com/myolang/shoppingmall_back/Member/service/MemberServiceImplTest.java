package com.myolang.shoppingmall_back.Member.service;

import com.myolang.shoppingmall_back.common.Member.repository.MemberJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class MemberServiceImplTest {
  @Autowired
  MemberJpaRepository memberJpaRepository;
}