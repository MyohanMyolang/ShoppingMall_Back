package com.myolang.shoppingmall_back.Member.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(indexes = {
  @Index(name = "refreshToken_Index", columnList = "refreshToken", unique = true)
})
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  private Long Id;

  @Column(nullable = false, unique = true)
  private String userId;
  @Column(nullable = false)
  private String pw;

  private String refreshToken;
  private String nickName;

  @Column(nullable = false)
  @Enumerated // Default Type이 Ordinal 이며, Ordinal의 사용 이유는 변화가 없을 것이라 판단되는 EnumType이기 때문이다.
  private MemberRole memberRole;

//  @Column(nullable = false)
  @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
  @Setter
  MemberInfo info;

  @Builder
  public Member(String userId, String pw, String refreshToken, MemberRole memberRole, String nickname) {
    this.userId = userId;
    this.pw = pw;
    this.refreshToken = refreshToken;
    this.memberRole = memberRole;
    this.nickName = nickname;
  }

  public Member changeInfo(MemberInfo info){ this.info = info; return this;}

  public Member changePw(String pw) {this.pw = pw;return this;}

  public Member changeNickname(String nickname){
    this.nickName = nickname;
    return this;
  }

  public Member changeRole(MemberRole memberRole){
    this.memberRole = memberRole;
    return this;
  }

  public Member changeJwt(String jwt){
    this.refreshToken = jwt;
    return this;
  }
}
