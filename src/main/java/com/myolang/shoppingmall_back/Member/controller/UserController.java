package com.myolang.shoppingmall_back.Member.controller;

import com.myolang.shoppingmall_back.Member.dto.MemberDto;
import com.myolang.shoppingmall_back.Member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis/user")
@RequiredArgsConstructor
@Log4j2
public class UserController {
  private final MemberService memberService;

  @PostMapping("/regist")
  boolean regis(@RequestBody MemberDto memberDto){
    memberService.regist(memberDto);
    return false;
  }

  @GetMapping("/checkid/{userId}")
  boolean checkUserId(@PathVariable String userId){
    log.info(userId);
    return memberService.duplicateCheckUserId(userId);
  }
}
