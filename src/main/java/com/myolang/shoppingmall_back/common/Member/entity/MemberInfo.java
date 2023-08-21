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
  @Getter
  private String phoneNumber;

  @Column(nullable = false)
  @Setter
  @Getter
  private String name;

  @Builder
  public MemberInfo(String phoneNumber, String name) {
    this.phoneNumber = phoneNumber;
    this.name = name;
  }



  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member")
  @Setter
  private Member member;





}

