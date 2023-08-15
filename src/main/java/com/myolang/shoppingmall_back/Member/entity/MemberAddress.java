package com.myolang.shoppingmall_back.Member.entity;

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
  @JoinColumn(name = "member_info_id")
  @Setter
  MemberInfo memberInfo;

  @Setter
  String city;

  @Setter
  String detail;
}