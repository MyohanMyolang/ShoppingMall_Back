package com.myolang.shoppingmall_back.Auth.controller;

import com.myolang.shoppingmall_back.common.Member.dto.MemberDto;
import com.myolang.shoppingmall_back.common.Member.exceptions.DeveloperException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
  @PostMapping("/regist")
  boolean regis(@RequestBody @Valid MemberDto memberDto) throws DeveloperException {


    return false;
  }
}
