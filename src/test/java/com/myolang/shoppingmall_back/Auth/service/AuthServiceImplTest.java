package com.myolang.shoppingmall_back.Auth.service;

import com.myolang.shoppingmall_back.Auth.exceptions.NotFoundUser;
import com.myolang.shoppingmall_back.Auth.repository.AuthRepository;
import com.myolang.shoppingmall_back.LocalServiceTest;
import com.myolang.shoppingmall_back.common.Member.dto.MemberResDto;
import com.myolang.shoppingmall_back.common.Member.entity.Member;
import com.myolang.shoppingmall_back.common.Member.entity.MemberAddress;
import com.myolang.shoppingmall_back.common.Member.entity.MemberInfo;
import com.myolang.shoppingmall_back.common.Member.entity.MemberRole;
import com.myolang.shoppingmall_back.global.exceptions.AlreadyHasDataException;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class AuthServiceImplTest {

  @Autowired
  AuthService authService;


  @BeforeEach
  void beforeEach() {
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

    authService.regist(member);
  }

  @Test
  @DisplayName("if Login Failure then throw NotFoundUser Exception")
  void loginFalse() {

    NotFoundUser notFoundUser = assertThrows(NotFoundUser.class, () -> {
      authService.login("test1", "");
    });
    assertThat(notFoundUser.getMessage()).isEqualTo("아이디 또는 비밀번호를 확인하여 주십시오.");
  }

  @Test
  @DisplayName("Login success")
  void loginSuccess(){
    MemberResDto login = authService.login("test", "pw");

    assertThat(login.getNickName()).isEqualTo("test");
  }

}