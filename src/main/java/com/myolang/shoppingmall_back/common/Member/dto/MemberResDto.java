package com.myolang.shoppingmall_back.common.Member.dto;

import com.myolang.shoppingmall_back.common.Member.entity.MemberRole;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberResDto {
  String nickName;

  MemberRole role;

  // 아이디 저장 Option을 넣게 되면 jwt를 사용하도록 한다.

  @Builder
  public MemberResDto(String nickName, MemberRole role) {
    this.nickName = nickName;
    this.role = role;
  }
}
