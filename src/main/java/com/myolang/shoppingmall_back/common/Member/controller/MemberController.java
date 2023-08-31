package com.myolang.shoppingmall_back.common.Member.controller;


import com.myolang.shoppingmall_back.Auth.dto.ChangeReqDto;
import com.myolang.shoppingmall_back.common.Member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @PatchMapping("/change")
  void changeData(@RequestBody @Valid ChangeReqDto changeReqDto){
    memberService.changeData(changeReqDto.getNickname(), changeReqDto.getDatas());
  }
}
