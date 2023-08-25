package com.myolang.shoppingmall_back.Auth.repository;

import com.myolang.shoppingmall_back.common.Member.entity.Member;
import com.myolang.shoppingmall_back.common.Member.exceptions.DeveloperException;
import com.myolang.shoppingmall_back.common.Member.exceptions.MemberErrorCode;
import com.myolang.shoppingmall_back.common.Member.repository.MemberRepository;
import com.myolang.shoppingmall_back.global.exceptions.AlreadyHasDataException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Repository
@RequiredArgsConstructor
public class AuthRepository {
  private final MemberRepository memberRepository;

  public boolean regist(Member member) throws AlreadyHasDataException {
    if(memberRepository.findByUserId(member.getUserId()).isPresent())
      throw new AlreadyHasDataException("이미 ID가 존재합니다.");
    memberRepository.save(member);
    return true;
  }
}
