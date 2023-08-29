package com.myolang.shoppingmall_back.common.Member.entity;

import com.myolang.shoppingmall_back.common.Member.dto.MemberResDto;
import com.myolang.shoppingmall_back.common.Member.dto.RegistDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
//@Table(indexes = {
//  @Index(name = "refreshToken_Index", columnList = "refreshToken", unique = true)
//})
//@DynamicUpdate
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  private Long Id;

  @Column(nullable = false, unique = true)
  @Setter
  private String userId;
  @Column(nullable = false)
  @Setter
  private String pw;
  @Column(nullable = false, unique = true)
  @Setter
  private String nickName;

  @Setter
  private String refreshToken;

  @Column(nullable = false)
  @Enumerated // Default Type이 Ordinal 이며, Ordinal의 사용 이유는 변화가 없을 것이라 판단되는 EnumType이기 때문이다.
  @Setter
  private MemberRole memberRole;

//  @Column(nullable = false)
  @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
  MemberInfo info;

  public void setInfo(MemberInfo info){
    info.setMember(this);
    this.info = info;
  }

  @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<MemberAddress> address = new ArrayList<>();

  public boolean addAddress(MemberAddress addr){
    try {
      addr.setMember(this);
      address.add(addr);
      return true;
    } catch (Exception e){
//      Log
      return false;
    }
  }


  @Builder
  public Member(String userId, String pw, MemberRole memberRole, String nickname) {
    this.userId = userId;
    this.pw = pw;
    this.memberRole = memberRole;
    this.nickName = nickname;
  }

  public MemberResDto toMemberResDto(){
    return MemberResDto.builder()
      .nickName(this.nickName)
      .role(this.memberRole)
      .build();
  }
}
