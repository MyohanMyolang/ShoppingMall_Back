package com.myolang.shoppingmall_back.Member.controller;

import com.myolang.shoppingmall_back.Member.dto.MemberDto;
import com.myolang.shoppingmall_back.Member.exceptions.DeveloperException;
import com.myolang.shoppingmall_back.Member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
  private final MemberService memberService;

  @PostMapping("/regist")
  boolean regis(@RequestBody @Valid MemberDto memberDto) throws DeveloperException {
    memberService.regist(memberDto);
    return false;
  }

  @GetMapping("/checkid/{userId}")
  boolean checkUserId(@PathVariable String userId){
    return memberService.duplicateCheckUserId(userId);
  }
}
