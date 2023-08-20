package com.myolang.shoppingmall_back.Member.service;

import com.myolang.shoppingmall_back.Member.dto.MemberDto;
import com.myolang.shoppingmall_back.Member.entity.Member;
import com.myolang.shoppingmall_back.Member.entity.MemberAddress;
import com.myolang.shoppingmall_back.Member.entity.MemberInfo;
import com.myolang.shoppingmall_back.Member.entity.MemberRole;
import com.myolang.shoppingmall_back.Member.exceptions.DeveloperException;
import com.myolang.shoppingmall_back.Member.repository.MemberRepository;
import com.myolang.shoppingmall_back.global.config.P6SpyFormatter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ImportAutoConfiguration(P6SpyFormatter.class)
@Transactional
class MemberServiceLocalImplTest {

    MemberRepository memberRepository;
  MemberService memberService;

  @Autowired
  MemberServiceLocalImplTest(MemberRepository memberRepository){
    memberService = new MemberServiceLocalImpl(memberRepository);
  }

  @Test
  @DisplayName("Member Null Test")
  void memberNull(){
      //given
    Member member = Member.builder()
      .userId("test")
      .pw("test")
      .refreshToken("jwt")
      .memberRole(MemberRole.Admin)
      .build();
    MemberInfo info1 = MemberInfo.builder()
      .phoneNumber("010-0000-0000")
      .name("testName1")
      .build();
    //em.persist(info1);
    MemberAddress addr = new MemberAddress("city", "detail");
    addr.setMemberInfo(info1);

    member.setInfo(info1);
    info1.addAddress(addr);
    MemberAddress addr1 = new MemberAddress("city", "detail");
    addr1.setMemberInfo(info1);
    info1.addAddress(addr1);



    //when
    DeveloperException exception = assertThrows(DeveloperException.class, () -> memberService.regist((Member) null));

      //then
    assertThat(exception.getMessage()).isEqualTo("Should Check Code");
  }
}