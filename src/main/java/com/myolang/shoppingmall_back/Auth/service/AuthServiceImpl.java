package com.myolang.shoppingmall_back.Auth.service;

import com.myolang.shoppingmall_back.Auth.repository.AuthRepository;
import com.myolang.shoppingmall_back.common.Member.entity.Member;
import com.myolang.shoppingmall_back.common.Member.exceptions.DeveloperException;
import com.myolang.shoppingmall_back.common.Member.exceptions.MemberErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
  private final AuthRepository authRepository;
  @Override
  public boolean regist(Member member) throws DeveloperException {
    return authRepository.regist(member);
  }
}
