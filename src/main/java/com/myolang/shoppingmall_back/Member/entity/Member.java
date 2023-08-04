package com.myolang.shoppingmall_back.Member.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(indexes = {
  @Index(name = "Jwt_Index", columnList = "Jwt", unique = true)
})
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  @Column(nullable = false)
  private String userId;
  @Column(nullable = false)
  private String pw;
  @Column(nullable = false)
  private String phoneNumber;
  @Column(nullable = false)
  private String address;
  private String jwt;

  @Column(nullable = false)
  @Enumerated
  private Role role;

  @Builder
  public Member(String userId, String pw, String phoneNumber, String address, String jwt, Role role) {
    this.userId = userId;
    this.pw = pw;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.jwt = jwt;
    this.role = role;
  }
}
