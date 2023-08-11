package com.myolang.shoppingmall_back.Member.service;

import com.myolang.shoppingmall_back.Member.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
@Profile("local")
public class MemberServiceLocalImpl implements MemberService {

  private final MemberRepository memberRepository;
  private final EntityManager em;


  @Override
  public boolean regist() {
    return false;
  }

  public boolean duplicateCheckUserId(String userId){
    return memberRepository.findByUserId(userId).isPresent();
  }
}
