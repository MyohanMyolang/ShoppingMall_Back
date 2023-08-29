package com.myolang.shoppingmall_back.Auth.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
public class LoginDto {
  @NotBlank(message = "id를 입력하여 주십시오")
  String id;

  @NotBlank(message = "PassWord를 입력하여 주십시오.")
  String pw;

  // boolean rememberId; 추후 아이디 저장 기능 제작시 사용
}
