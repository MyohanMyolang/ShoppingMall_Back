package com.myolang.shoppingmall_back.Member.service;

import com.myolang.shoppingmall_back.Member.entity.Member;
import com.myolang.shoppingmall_back.Member.exceptions.DeveloperException;
import com.myolang.shoppingmall_back.Member.exceptions.MemberErrorCode;
import com.myolang.shoppingmall_back.Member.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
@Profile("local")
@Slf4j
public class MemberServiceLocalImpl implements MemberService {

  private final MemberRepository memberRepository;


  @Override
  public boolean regist(Member member) throws DeveloperException {
    try {
      log.info("test");
      memberRepository.save(member);
    }
    catch (InvalidDataAccessApiUsageException e){
      throw new DeveloperException(MemberErrorCode.DEVELOPER_MISS);
    }
    return false;
  }

  public boolean duplicateCheckUserId(String userId){
    return memberRepository.findByUserId(userId).isPresent();
  }
}
