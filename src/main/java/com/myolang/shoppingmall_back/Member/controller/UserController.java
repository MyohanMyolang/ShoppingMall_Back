package com.myolang.shoppingmall_back.Member.controller;

import com.myolang.shoppingmall_back.Member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis/user")
@RequiredArgsConstructor
public class UserController {
  private final MemberService memberService;
}
