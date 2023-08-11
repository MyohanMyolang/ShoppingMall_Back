package com.myolang.shoppingmall_back.Member.controller;

import com.myolang.shoppingmall_back.Member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis/user")
@RequiredArgsConstructor
@Log4j2
public class UserController {
  private final MemberService memberService;

  @GetMapping("/checkid")
  boolean checkUserId(@RequestBody String userId){
    log.info(userId);
    return memberService.duplicateCheckUserId(userId);
  }
}
