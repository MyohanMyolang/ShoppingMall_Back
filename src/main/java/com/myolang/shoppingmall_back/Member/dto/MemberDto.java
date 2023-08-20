package com.myolang.shoppingmall_back.Member.dto;

import com.myolang.shoppingmall_back.Member.entity.Member;
import com.myolang.shoppingmall_back.Member.entity.MemberAddress;
import com.myolang.shoppingmall_back.Member.entity.MemberInfo;
import com.myolang.shoppingmall_back.Member.entity.MemberRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

public class MemberDto {


  @NotBlank(message = "ID를 입력하여 주십시오.")
  @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "소문자, 대문자, 숫자로만 이루어져야 합니다.")
  @Size(min = 4, max = 16, message = "ID는 4-16 글자로 작성되어야 합니다.")
  private String id;

  @NotBlank(message = "PASSWORD를 입력하여 주십시오.")
  @Pattern(regexp = "^(?=.?[A-Z])(?=.?[a-z])(?=.?[0-9])(?=.?[#?!@$ %^&*-])$", message = "영어, 숫자, 대문자를 포함시켜 주십시오.")
  private String pw;

  @NotBlank(message = "Nickname을 입력하여 주십시오.")
  @Pattern(regexp = "^[A-Za-z0-9ㄱ-힣]*$")
  private String nickName;

  @NotNull(message = "형식에 맞지 않는 요청")
  @Enumerated(EnumType.STRING)
  private MemberRole role;


  private InfoDto info;

  private List<AddressDto> addressList;

  @Builder
  public MemberDto(String id, String pw, String nickName, MemberRole role, InfoDto info, List<AddressDto> addressList) {
    this.id = id;
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
    @NotBlank(message = "휴대폰 번호를 입력하여 주십시오.")
    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$")
    String phoneNumber;

    @NotBlank(message = "이름을 입력하여 주십시오.")
    @Pattern(regexp = "^[가-힣]*$")
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
      .userId(this.id)
      .pw(this.pw)
      .nickname(this.nickName)
      .memberRole(this.role)
      .build();
    member.setInfo(info);
    return member;
  }
}
