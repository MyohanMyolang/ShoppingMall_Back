package com.myolang.shoppingmall_back.Auth.service;

import com.myolang.shoppingmall_back.Auth.repository.AuthRepository;
import com.myolang.shoppingmall_back.common.Member.entity.Member;
import com.myolang.shoppingmall_back.common.Member.exceptions.DeveloperException;
import com.myolang.shoppingmall_back.common.Member.exceptions.MemberErrorCode;
import com.myolang.shoppingmall_back.global.exceptions.AlreadyHasDataException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
  private final AuthRepository authRepository;
  @Override
  public boolean regist(Member member) throws AlreadyHasDataException {
    return authRepository.regist(member);
  }
}
