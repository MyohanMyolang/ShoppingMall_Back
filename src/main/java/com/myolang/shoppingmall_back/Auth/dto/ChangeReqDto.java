package com.myolang.shoppingmall_back.Auth.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.Map;

@Getter
public class ChangeReqDto {
  @NotBlank(message = "닉네임이 존재하지 않습니다.")
  String nickname;

  @NotNull(message = "Data가 제대로 전달되지 않았습니다.")
  Map<String, Object> datas;
}
