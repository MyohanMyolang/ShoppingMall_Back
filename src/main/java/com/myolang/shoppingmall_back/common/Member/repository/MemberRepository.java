package com.myolang.shoppingmall_back.common.Member.repository;

import com.myolang.shoppingmall_back.common.Member.entity.Member;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Validated
public class MemberRepository {
  
  private final PasswordEncoder passwordEncoder;
  private final MemberJpaRepository memberJpaRepository;
  
  public void changePw(Member member, @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[#?!@$%^&*-]).*$", message = "대문자, 숫자, 특수 문자를 포함 시켜 주십시오.")
                @Size(min = 8, max = 16, message = "PASSWORD는 8글자 이상으로 작성되어야 합니다.") @Valid String pw){
    member.setPw(passwordEncoder.encode(member.getPw()));
  }

  public Member findByNickName(String nickname) {
    return memberJpaRepository.findByNickName(nickname).orElseThrow();
  }
}
