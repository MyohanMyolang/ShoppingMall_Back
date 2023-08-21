package com.myolang.shoppingmall_back.Auth.repository;

import com.myolang.shoppingmall_back.common.Member.entity.Member;
import com.myolang.shoppingmall_back.common.Member.exceptions.DeveloperException;
import com.myolang.shoppingmall_back.common.Member.exceptions.MemberErrorCode;
import com.myolang.shoppingmall_back.common.Member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AuthRepository {
  private final MemberRepository memberRepository;

  public boolean regist(Member member) throws DeveloperException {
    try {
      memberRepository.save(member);
      return true;
    }
    catch (InvalidDataAccessApiUsageException e){
      throw new DeveloperException(MemberErrorCode.DEVELOPER_MISS);
    }
  }

}
