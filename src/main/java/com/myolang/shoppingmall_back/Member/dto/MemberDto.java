package com.myolang.shoppingmall_back.Member.dto;

import lombok.Getter;
import lombok.Setter;

public class MemberDto {


  String userId;
  String pw;
  String nickName;


  InfoDto info;

  AddressDto address;


  @Setter
  @Getter
  public static class AddressDto{
    String city;

    String detail;
  }
  @Setter
  @Getter
  public static class InfoDto{
    String phoneNumber;
    String name;
  }
}
