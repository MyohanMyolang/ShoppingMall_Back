package com.myolang.shoppingmall_back.Auth.repository;

import com.myolang.shoppingmall_back.common.Member.entity.Member;
import com.myolang.shoppingmall_back.common.Member.repository.MemberJpaRepository;
import com.myolang.shoppingmall_back.global.exceptions.AlreadyHasDataException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AuthRepository {
  private final MemberJpaRepository memberJpaRepository;
  private final PasswordEncoder passwordEncoder;

  public boolean regist(Member member){
    if(memberJpaRepository.findByUserId(member.getUserId()).isPresent())
      throw new AlreadyHasDataException("이미 ID가 존재합니다.");
    member.setPw(passwordEncoder.encode(member.getPw()));
    memberJpaRepository.save(member);
    return true;
  }

  public Member getByUserId(String userId){
    return memberJpaRepository.findByUserId(userId).orElse(null);
  }

  public Member getByNickname(String nickname){ return memberJpaRepository.findByNickName(nickname).orElseThrow();}

}
