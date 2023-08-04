package com.myolang.shoppingmall_back.Member.repository;

import com.myolang.shoppingmall_back.Member.entity.Member;
import com.myolang.shoppingmall_back.Member.entity.Role;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberRepositoryTest {
  @Autowired
  MemberRepository memberRepository;

  @Test
  @DisplayName("Jpa Save Test And FindByRole")
  @Transactional
  void jpaSaveTest(){
//    assertThat(memberRepository.findByRole(Role.Admin)).isEmpty();
    IllegalArgumentException except = assertThrows(IllegalArgumentException.class, () -> {
      Assert.notEmpty(memberRepository.findByRole(Role.Admin), "비어있습니다.");
    });
    assertThat(except.getMessage()).isEqualTo("비어있습니다.");
    //given
    Member member = Member.builder()
      .userId("test")
      .pw("test")
      .address("주소")
      .jwt("jwt")
      .phoneNumber("010-0000-0000")
      .role(Role.Admin)
      .build();
    memberRepository.save(member);
    Member member2 = Member.builder()
      .userId("test")
      .pw("test")
      .address("주소")
      .jwt("jwt1")
      .phoneNumber("0110-0000-0000")
      .role(Role.Admin)
      .build();
    memberRepository.save(member2);
      //when
    List<Member> result = memberRepository.findByRole(Role.Admin);

    //then
    assertThat(result.size()).isEqualTo(2);

  }

  @Test
  @DisplayName("Same Jwt Insert Test")
  void sameJwtTest(){
      //given

      //when

      //then
  }


}