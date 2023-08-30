package com.myolang.shoppingmall_back.Auth.repository;

import com.myolang.shoppingmall_back.common.Member.entity.Member;
import com.myolang.shoppingmall_back.common.Member.repository.MemberRepository;
import com.myolang.shoppingmall_back.global.exceptions.AlreadyHasDataException;
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
public class AuthRepository {
  private final MemberRepository memberRepository;
  private final PasswordEncoder passwordEncoder;

  public boolean regist(Member member){
    if(memberRepository.findByUserId(member.getUserId()).isPresent())
      throw new AlreadyHasDataException("이미 ID가 존재합니다.");
    member.setPw(passwordEncoder.encode(member.getPw()));
    memberRepository.save(member);
    return true;
  }


  public Member getByUserId(String userId){
    return memberRepository.findByUserId(userId).orElse(null);
  }

  public Member getByNickname(String nickname){ return memberRepository.findByNickName(nickname).orElseThrow();}

  public void changePw(Member user,
                       @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[#?!@$%^&*-]).*$", message = "대문자, 숫자, 특수 문자를 포함 시켜 주십시오.")
                       @Size(min = 8, max = 16, message = "PASSWORD는 8글자 이상으로 작성되어야 합니다.") @Valid String pw) {
    user.setPw(passwordEncoder.encode(pw));
  }
}
