package com.myolang.shoppingmall_back.Member.service;

import com.myolang.shoppingmall_back.Member.repository.MemberRepository;
import com.myolang.shoppingmall_back.global.config.P6SpyFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ImportAutoConfiguration(P6SpyFormatter.class)
class MemberServiceLocalImplTest {
  @Autowired
  MemberService memberService;


}