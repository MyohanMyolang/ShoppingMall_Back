package com.myolang.shoppingmall_back.Member.dto;

import com.myolang.shoppingmall_back.Member.entity.Member;
import com.myolang.shoppingmall_back.Member.entity.MemberAddress;
import com.myolang.shoppingmall_back.Member.entity.MemberInfo;
import com.myolang.shoppingmall_back.Member.entity.MemberRole;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MemberDto {


  String userId;
  String pw;
  String nickName;

  MemberRole role;


  InfoDto info;

  List<AddressDto> addressList;

  @Builder
  public MemberDto(String userId, String pw, String nickName, MemberRole role, InfoDto info, List<AddressDto> addressList) {
    this.userId = userId;
    this.pw = pw;
    this.nickName = nickName;
    this.role = role;
    this.info = info;
    this.addressList = addressList;
  }

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

  Member toEntity(){
    MemberInfo info = new MemberInfo(this.info.phoneNumber, this.info.name);
    List<MemberAddress> addressList = new LinkedList<>();
    this.addressList.forEach(addr -> {
      MemberAddress memberAddress = new MemberAddress(addr.city, addr.detail);
      memberAddress.setMemberInfo(info);
      addressList.add(memberAddress);
    });

    info.setAddress(addressList);
    Member member = Member.builder()
      .userId(this.userId)
      .pw(this.pw)
      .nickname(this.nickName)
      .memberRole(this.role)
      .build();
    member.setInfo(info);
    return member;
  }
}
