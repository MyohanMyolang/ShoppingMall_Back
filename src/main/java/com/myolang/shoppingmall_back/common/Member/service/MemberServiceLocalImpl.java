package com.myolang.shoppingmall_back.common.Member.service;

import com.myolang.shoppingmall_back.common.Member.entity.Member;
import com.myolang.shoppingmall_back.common.Member.exceptions.DeveloperException;
import com.myolang.shoppingmall_back.common.Member.exceptions.MemberErrorCode;
import com.myolang.shoppingmall_back.common.Member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Profile("local")
@Slf4j
public class MemberServiceLocalImpl implements MemberService {

  private final MemberRepository memberRepository;




  public boolean duplicateCheckUserId(String userId){
    return memberRepository.findByUserId(userId).isPresent();
  }
}
