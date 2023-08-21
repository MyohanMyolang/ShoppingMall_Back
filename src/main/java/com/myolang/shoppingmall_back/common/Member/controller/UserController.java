package com.myolang.shoppingmall_back.common.Member.controller;

import com.myolang.shoppingmall_back.common.Member.dto.MemberDto;
import com.myolang.shoppingmall_back.common.Member.exceptions.DeveloperException;
import com.myolang.shoppingmall_back.common.Member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
  private final MemberService memberService;



}
