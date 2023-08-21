package com.myolang.shoppingmall_back.common.Member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class MemberAddress {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member", referencedColumnName = "id")
  @Setter
  Member member;

  @Setter
  String city;

  @Setter
  String detail;

  public MemberAddress(String city, String detail) {
    this.city = city;
    this.detail = detail;
  }

  public MemberAddress() {

  }
}