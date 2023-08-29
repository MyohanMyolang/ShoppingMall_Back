package com.myolang.shoppingmall_back.Auth.controller;

import com.myolang.shoppingmall_back.Auth.dto.ChangeReqDto;
import com.myolang.shoppingmall_back.Auth.dto.LoginDto;
import com.myolang.shoppingmall_back.Auth.service.AuthService;
import com.myolang.shoppingmall_back.common.Member.dto.MemberResDto;
import com.myolang.shoppingmall_back.common.Member.dto.RegistDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
  private final AuthService authService;
  @PostMapping("/regist")
  boolean regist(@RequestBody @Valid RegistDto registDto){ return authService.regist(registDto); }
  @GetMapping("/login")
  MemberResDto login(@RequestBody @Valid LoginDto user){
    return authService.login(user.getId(), user.getPw());
  }

  @PatchMapping("/change")
  void changeData(@RequestBody @Valid ChangeReqDto changeReqDto){
    authService.changeData(changeReqDto.getNickname(), changeReqDto.getDatas());
  }
}
