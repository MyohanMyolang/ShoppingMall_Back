package com.myolang.shoppingmall_back.Member.repository;

import com.myolang.shoppingmall_back.common.Member.entity.Member;
import com.myolang.shoppingmall_back.common.Member.entity.MemberAddress;
import com.myolang.shoppingmall_back.common.Member.entity.MemberInfo;
import com.myolang.shoppingmall_back.common.Member.entity.MemberRole;
import com.myolang.shoppingmall_back.common.Member.repository.MemberJpaRepository;
import com.myolang.shoppingmall_back.global.config.P6SpyFormatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;


import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ImportAutoConfiguration(P6SpyFormatter.class)
class MemberJpaRepositoryTest {
  @Autowired
  MemberJpaRepository memberJpaRepository;

  @BeforeEach
  void before(){
    Member member = Member.builder()
      .userId("test")
      .memberRole(MemberRole.Admin)
      .nickname("test")
      .pw("pw")
      .build();
    MemberInfo info = new MemberInfo("010-0000-0000", "이름", "a@b.c");
    member.setInfo(info);

    MemberAddress addr = new MemberAddress("test", "test");
    member.addAddress(addr);
    //when
    assertDoesNotThrow(() -> memberJpaRepository.save(member));
  }

//  @Test
//  @DisplayName("Save Test")
//  void save(){
//      //given
//      Member member = Member.builder()
//        .userId("test")
//        .memberRole(MemberRole.Admin)
//        .nickname("test")
//        .pw("pw")
//        .refreshToken("")
//        .build();
//      MemberInfo info = new MemberInfo("010-0000-0000", "이름");
//      member.setInfo(info);
//
//      MemberAddress addr = new MemberAddress("test", "test");
//      member.addAddress(addr);
//      //when
//    assertDoesNotThrow(() -> memberRepository.save(member));
//
//    //then
//    memberRepository.findByUserId("test").ifPresent((mem) -> {
//      assertThat(mem.getInfo().getName()).isEqualTo("이름");
//    });
//
//  }

  @Test
  @DisplayName("search Test")
  void search(){
      //given
    Optional<Member> test = memberJpaRepository.findByUserId("test");
    //when & then
    test.ifPresent(member -> {
      assertThat(member.getInfo().getName()).isEqualTo("이름");
    });
  }
}