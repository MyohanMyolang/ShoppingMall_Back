package com.myolang.shoppingmall_back.common.Member.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MemberInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(nullable = false)
  @Setter
  private String phoneNumber;

  @Column(nullable = false)
  @Setter
  private String name;


  @Column(nullable = false)
  @Setter
  private String email;

  @Builder
  public MemberInfo(String phoneNumber, String name, String email) {
    this.phoneNumber = phoneNumber;
    this.name = name;
    this.email = email;
  }

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member")
  @Setter
  private Member member;

}

